import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeCalculatorGUI extends JFrame {
    private JTextField circleRadiusField, rectLengthField, rectWidthField, triSide1Field, triSide2Field, triSide3Field;
    private JTextArea resultArea;

    public ShapeCalculatorGUI() {
        setTitle("Shape Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2, 5, 5));

       
        add(new JLabel("Circle Radius:"));
        circleRadiusField = new JTextField();
        add(circleRadiusField);

     
        add(new JLabel("Rectangle Length:"));
        rectLengthField = new JTextField();
        add(rectLengthField);
        add(new JLabel("Rectangle Width:"));
        rectWidthField = new JTextField();
        add(rectWidthField);

        add(new JLabel("Triangle Side 1:"));
        triSide1Field = new JTextField();
        add(triSide1Field);
        add(new JLabel("Triangle Side 2:"));
        triSide2Field = new JTextField();
        add(triSide2Field);
        add(new JLabel("Triangle Side 3:"));
        triSide3Field = new JTextField();
        add(triSide3Field);

   
        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);

        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

      
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateShapes();
            }
        });

        setVisible(true);
    }

    private void calculateShapes() {
        StringBuilder results = new StringBuilder();

        try {
            double radius = Double.parseDouble(circleRadiusField.getText());
            double circlePerimeter = 2 * Math.PI * radius;
            double circleArea = Math.PI * radius * radius;
            results.append("Circle - Perimeter: ").append(circlePerimeter).append(", Area: ").append(circleArea).append("\n");
        } catch (NumberFormatException ignored) {
            results.append("Invalid Circle Input!\n");
        }

       
        try {
            double length = Double.parseDouble(rectLengthField.getText());
            double width = Double.parseDouble(rectWidthField.getText());
            double rectPerimeter = 2 * (length + width);
            double rectArea = length * width;
            results.append("Rectangle - Perimeter: ").append(rectPerimeter).append(", Area: ").append(rectArea).append("\n");
        } catch (NumberFormatException ignored) {
            results.append("Invalid Rectangle Input!\n");
        }

       
        try {
            double side1 = Double.parseDouble(triSide1Field.getText());
            double side2 = Double.parseDouble(triSide2Field.getText());
            double side3 = Double.parseDouble(triSide3Field.getText());

            
            if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
                double triPerimeter = side1 + side2 + side3;
                double s = triPerimeter / 2;
                double triArea = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
                results.append("Triangle - Perimeter: ").append(triPerimeter).append(", Area: ").append(triArea).append("\n");
            } else {
                results.append("Invalid Triangle Sides!\n");
            }
        } catch (NumberFormatException ignored) {
            results.append("Invalid Triangle Input!\n");
        }

      
        resultArea.setText(results.toString());
    }

    public static void main(String[] args) {
        new ShapeCalculatorGUI();
    }
}
