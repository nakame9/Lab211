import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class Contact {
    private int id;
    private String fullname;
    private String firstname;
    private String lastname;
    private String group;
    private String address;
    private String phone;
    public Contact(int id,String fullname,String group,String address,String phone) {
        this.id = id;
        this.fullname = fullname;
        this.group = group;
        this.address = address;
        this.phone = phone;
        String[] names = fullname.split(" ", 2);
        this.firstname = names[0];
        this.lastname = names.length > 1 ? names[1] : "";
    }
    public int getId() { return id; }
    public String getFullname(){return fullname; }
    public String getFirstname(){return firstname; }
    public String getLastname(){return lastname; }
    public String getGroup(){return group; }
    public String getAddress(){return address; }
    public String getPhone(){return phone; }
}
public class ContactManager {
    private ArrayList<Contact> contacts;
    private int nextId;
    private Scanner scanner;

    public ContactManager() {
        contacts = new ArrayList<>();
        nextId = 1;
        scanner = new Scanner(System.in);
    }
    public void displayMenu() {
        while (true) {
            System.out.println("Contact Management ");
            System.out.println("1. add contact");
            System.out.println("2. display all ");
            System.out.println("3. delete contact");
            System.out.println("4. exit");
            System.out.print("Select(1-4): ");
            
            String choice = scanner.nextLine();
            performAction(choice);
        }
    }

    private boolean isValidPhone(String phone) {
        String[] patterns = {"^\\d{10}$",                   
              
        };
        for (String pattern : patterns) {
            if (Pattern.matches(pattern, phone)) {
                return true;
            }
        }
        return false;
    }

    private void addContact() {
        System.out.println("add New Contact");
        System.out.print("enter full name: ");
        String fullname = scanner.nextLine();
        System.out.print("enter group: ");
        String group = scanner.nextLine();
        System.out.print("enter address: ");
        String address = scanner.nextLine();
        String phone;
        while (true) {
            System.out.print("enter phone number: ");
            phone = scanner.nextLine();
            if (isValidPhone(phone)) {
                break;
            }
            System.out.println("Invalid phone num");
            
        }
        Contact contact = new Contact(nextId++, fullname, group, address, phone);
        contacts.add(contact);
        System.out.println(" added success");
    }

    private void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No found");
            return;
        }
        System.out.println("Contact List:");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s%n", 
            "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        System.out.println("-".repeat(100));
        
        for (Contact contact : contacts) {
            System.out.printf("%-15d %-15s %-15s %-15s %-15s %-15s %-15s%n",
                contact.getId(),contact.getFullname(),contact.getFirstname(),
                contact.getLastname(),contact.getGroup(),contact.getAddress(), 
               contact.getPhone());
      }
    }
    private void deleteContact() {
        System.out.println("\nDelete Contact");
        System.out.print("Enter ID to delete: ");
        try {
           int idToDelete = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).getId() == idToDelete) {
                    contacts.remove(i);
                   System.out.println(" deleted success");
                    return;
                }}
            System.out.println("No found");
        } catch (NumberFormatException e) {
            System.out.println("enter valid num");
        }
    }
    private void performAction(String choice) {
        switch (choice) {
            case "1":
                addContact();
           break;
            case "2":
                displayContacts();
           break;
            case "3":
                deleteContact();
           break;
            case "4":
                System.out.println("exit");
                System.exit(0);
           break;
            default:
                System.out.println("Pls select 1-4.");
        }
    }
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        manager.displayMenu();
    }
}