package main;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Main {
	// Create Frames
	public static void main(String[] args) {
		OutputFrame MainOutputFrame = new OutputFrame();
		InputFrame MainInputFrame = new InputFrame();

		MainInputFrame.setVisible(true);
		MainOutputFrame.setVisible(true);

	}

	// Create text areas needed throughout
	public static JTextArea aInput = new JTextArea("Enter A");
	public static JTextArea bInput = new JTextArea("Enter B");
	public static JTextArea cInput = new JTextArea("Enter C");
	public static JTextArea solutionOutput = new JTextArea("No solutions so far");

	// Create Buttons/other needed throughout
	public static JButton calculate = new JButton("Calculate");
	public static JCheckBox chkboxAdvancedInfo = new JCheckBox("Advanced Info");
	public static JCheckBox chkboxShowWork = new JCheckBox("Show Work");
	public static JCheckBox chkboxRound = new JCheckBox("Round:");
	public static JCheckBox chkboxUsei = new JCheckBox("Use i");
	public static JRadioButton nearestInt = new JRadioButton("Int");
	public static JRadioButton nearestTenth = new JRadioButton("Tenth");
	public static JRadioButton nearestHundredth = new JRadioButton("Hundredth");
	public static JRadioButton nearestThousandth = new JRadioButton("Thousandth");
	public static JRadioButton nearestTenThousandth = new JRadioButton("Tenthousandth");
	public static ButtonGroup roundGroup = new ButtonGroup();
	public static JCheckBox chkboxSimplifyRoot = new JCheckBox("Simplify Square Root");

	// Create fonts used throughout
	public static Font textFontA = new Font("Andalus", 0, 20);
	public static Font textFontB = new Font("Andalus", 0, 10);
	public static Font labelFontA = new Font("Andalus", Font.BOLD, 25);
	public static Font titleFontA = new Font("Anadalus", Font.BOLD, 25);
	public static Font checkFontA = new Font("Andalus", Font.BOLD, 10);

	// Create variables used throughout
	public static int solutions = 0;
}
