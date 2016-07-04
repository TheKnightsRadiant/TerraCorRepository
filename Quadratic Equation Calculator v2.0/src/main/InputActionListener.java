package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Calculate") {
			Main.solutions++;
			// Convert text to A, B, C
			double valueA = Double.parseDouble(Main.aInput.getText());
			double valueB = Double.parseDouble(Main.bInput.getText());
			double valueC = Double.parseDouble(Main.cInput.getText());
			String textA = Double.toString(valueA);
			if (textA.endsWith(".0")) {
				textA = textA.replace(".0", "");
			}
			String textB = Double.toString(valueB);
			if (textB.endsWith(".0")) {
				textB = textB.replace(".0", "");
			}
			String textC = Double.toString(valueC);
			if (textC.endsWith(".0")) {
				textC = textC.replace(".0", "");
			}

			// Determinant stuff
			double valueDeterminant = valueB * valueB - 4 * valueA * valueC;
			int determinantSolutions = 0;
			if (valueDeterminant < 0) {
				determinantSolutions = 0;
			} else if (valueDeterminant == 0) {
				determinantSolutions = 1;
			} else if (valueDeterminant > 0) {
				determinantSolutions = 2;
			}
			String textDeterminant = Double.toString(valueDeterminant);
			if (textDeterminant.endsWith(".0")) {
				textDeterminant = textDeterminant.replace(".0", "");
			}
			String determinantSolutionsName = "real solutions";
			if (determinantSolutions == 1) {
				determinantSolutionsName = "real solution";
			}

			// Sqrt stuff
			double valueSqrt = Math.sqrt(valueDeterminant);
			String textSqrt = Double.toString(valueSqrt);
			String addSqrt = "";
			boolean evenRoot = false;
			if (textSqrt.endsWith(".0")) {
				textSqrt = textSqrt.replace(".0", "");
				evenRoot = true;
			}
			if(determinantSolutions >0){
			addSqrt = "\nRoot: " + textSqrt;
			}
			
			// Other variables
			double axisOfSymetry = -valueB / 2 * valueA;
			String textAxisOfSymetry = Double.toString(axisOfSymetry);
			if (textAxisOfSymetry.endsWith(".0")) {
				textAxisOfSymetry = textAxisOfSymetry.replace(".0", "");
			}
			// Equation
			String stringTextA = textA + "x²";
			String stringTextB = textB + "x";
			String stringTextC = textC;
			if (stringTextA.startsWith("1x²")) {
				stringTextA = "x²";
			}
			if (stringTextB.startsWith("1x")) {
				stringTextB = "x";
			}
			if (stringTextA.startsWith("-1x²")) {
				stringTextA = "-x²";
			}
			if (stringTextB.startsWith("-1x")) {
				stringTextB = "-x";
			}

			if (valueB > 0) {
				stringTextA = stringTextA + " + ";
			}
			if (valueC > 0) {
				stringTextB = stringTextB + " + ";
			}
			if (valueA == 0) {
				stringTextA = "";
			}
			if (valueB == 0) {
				stringTextB = "";
			}
			if (valueC == 0) {
				stringTextC = "";
			}
			if (stringTextB == "" && stringTextA != "" && stringTextC != "") {
				// add in +/- changer when no B value present
			}

			String Equation = "Equation: " + stringTextA + stringTextB + stringTextC + "=0";

			// Info (that doesn't need answers)
			if (Main.solutionOutput.getText().equals("No solutions so far")) {
				Main.solutionOutput.setText("");
			}

			if (Main.chkboxAdvancedInfo.isSelected()) {
				Main.solutionOutput.setText(Main.solutions + ")\nx = potato\n\n" + "A: " + textA + ", B: " + textB
						+ ", C: " + textC + "\nAxis of Symetry: " + textAxisOfSymetry + "\nDeterminant: "
						+ textDeterminant + " (" + determinantSolutions + " " + determinantSolutionsName + ")" + addSqrt
						+ "\n" + Equation + "\n31415" + Main.solutionOutput.getText());
			} else {
				Main.solutionOutput
						.setText(Main.solutions + ")\nx = potato\n" + "31415" + Main.solutionOutput.getText());
			}
			// Start solution branch
			if (determinantSolutions == 1 && evenRoot) {
				// Solution path 1 (1 answer, has root)
				Soln1_1Answer.Soln1(valueA, valueB, valueC);
			} else if (determinantSolutions == 2 && evenRoot) {
				// Solution path 2 (2 answers, has root)
				Soln2_2_Answer_Root.Soln2(valueA, valueB, valueC);
			} else if (determinantSolutions == 2 && !evenRoot) {
				// Solution path 3 (2 answers, has no root)
				Soln3_2Answer_NoRoot.Soln3(valueA, valueB, valueC);
			} else if (determinantSolutions == 0 && Main.chkboxUsei.isSelected()) {
				// Solution path 3 (2 answers, has neg root)
				Soln4_2Answer_NegRoot.Soln4UseI(valueA, valueB, valueC);
			}
		}
	}
}
