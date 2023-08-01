package OOP2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
	JTextField textField;
	JButton numButton0, numButton1, numButton2, numButton3, numButton4, numButton5, numButton6, numButton7, numButton8, numButton9;
	JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;
	double num1 = 0, num2 = 0, result = 0;
	char operator = ' ';
	public Calculator() {
		// Initialize the window
		setTitle("Calculator");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Initialize the text field
		textField = new JTextField(10);
		textField.setEditable(false);
		add(textField, BorderLayout.NORTH);
		
		// Initialize the number buttons
		numButton0 = new JButton("0");
		numButton1 = new JButton("1");
		numButton2 = new JButton("2");
		numButton3 = new JButton("3");
		numButton4 = new JButton("4");
		numButton5 = new JButton("5");
		numButton6 = new JButton("6");
		numButton7 = new JButton("7");
		numButton8 = new JButton("8");
		numButton9 = new JButton("9");
		
		// Initialize the operator buttons
		addButton = new JButton("+");
		subtractButton = new JButton("-");
		multiplyButton = new JButton("*");
		divideButton = new JButton("/");
		equalsButton = new JButton("=");
		clearButton = new JButton("C");
		
		// Add the buttons to the window
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		panel.add(numButton7);
		panel.add(numButton8);
		panel.add(numButton9);
		panel.add(divideButton);
		panel.add(numButton4);
		panel.add(numButton5);
		panel.add(numButton6);
		panel.add(multiplyButton);
		panel.add(numButton1);
		panel.add(numButton2);
		panel.add(numButton3);
		panel.add(subtractButton);
		panel.add(numButton0);
		panel.add(equalsButton);
		panel.add(clearButton);
		panel.add(addButton);
		add(panel, BorderLayout.CENTER);
		
		// Add action listeners to the buttons
		numButton0.addActionListener(this);
		numButton1.addActionListener(this);
		numButton2.addActionListener(this);
		numButton3.addActionListener(this);
		numButton4.addActionListener(this);
		numButton5.addActionListener(this);
		numButton6.addActionListener(this);
		numButton7.addActionListener(this);
		numButton8.addActionListener(this);
		numButton9.addActionListener(this);
		addButton.addActionListener(this);
		subtractButton.addActionListener(this);
		multiplyButton.addActionListener(this);
		divideButton.addActionListener(this);
		equalsButton.addActionListener(this);
		clearButton.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String buttonText = e.getActionCommand();
		
		switch (buttonText) {
			case "C" -> {
				// Clear the text field and reset the variables
				textField.setText("");
				num1 = 0;
				num2 = 0;
				result = 0;
				operator = ' ';
			}
			case "+", "-", "*", "/" -> {
				// Set the operator
				operator = buttonText.charAt(0);
				num1 = Double.parseDouble(textField.getText());
				textField.setText("");
			}
			case "=" -> {
				// Calculate the result
				num2 = Double.parseDouble(textField.getText());
				switch (operator) {
					case '+' -> result = num1 + num2;
					case '-' -> result = num1 - num2;
					case '*' -> result = num1 * num2;
					case '/' -> result = num1 / num2;
					default -> {
					}
				}
				textField.setText(Double.toString(result));
			}
			default ->
					// Append the digit to the text field
					textField.setText(textField.getText() + buttonText);
		}
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
}

