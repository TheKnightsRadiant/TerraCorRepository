package main;

public class Soln2_2_Answer_Root {
	// Solution for ones that have 2 answers and root
	public static void Soln2(double valueA, double valueB, double valueC) {
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

		double valueBNeg = -valueB;
		if (valueBNeg == -0) {
			valueBNeg = 0;
		}
		String textBNeg = Double.toString(valueBNeg);
		if (textBNeg.endsWith(".0")) {
			textBNeg = textBNeg.replace(".0", "");
		}
		double valueATwo = 2 * valueA;
		String textATwo = Double.toString(valueATwo);
		if (textATwo.endsWith(".0")) {
			textATwo = textATwo.replace(".0", "");
		}
		double valueBNegTwoA = valueBNeg / valueATwo;
		String textBNegTwoA = Double.toString(valueBNegTwoA);
		if (textBNegTwoA.endsWith(".0")) {
			textBNegTwoA = textBNegTwoA.replace(".0", "");
		}
		double valueBSquared = valueB * valueB;
		String textBSquared = Double.toString(valueBSquared);
		if (textBSquared.endsWith(".0")) {
			textBSquared = textBSquared.replace(".0", "");
		}
		double value4AC = -4 * valueA * valueC;
		String text4AC = Double.toString(Math.abs(value4AC));
		if (text4AC.endsWith(".0")) {
			text4AC = text4AC.replace(".0", "");
		}
		double valueDeterminant = valueBSquared + value4AC;
		String textDeterminant = Double.toString(valueDeterminant);
		if (textDeterminant.endsWith(".0")) {
			textDeterminant = textDeterminant.replace(".0", "");
		}
		double valueSqrt = Math.sqrt(valueDeterminant);
		String textSqrt = Double.toString(valueSqrt);
		if (textSqrt.endsWith(".0")) {
			textSqrt = textSqrt.replace(".0", "");
		}
		double valueSqrt2A = valueSqrt / valueATwo;
		String textSqrt2A = Double.toString(valueSqrt2A);
		if (textSqrt2A.endsWith(".0")) {
			textSqrt2A = textSqrt2A.replace(".0", "");
		}
		double valueSoln1 = (valueBNeg / (2 * valueA)) + (valueSqrt / (2 * valueA));
		double valueSoln2 = (valueBNeg / (2 * valueA)) - (valueSqrt / (2 * valueA));

		// Rounding
		if (Main.chkboxRound.isSelected()) {
			if (Main.nearestInt.isSelected()) {
				valueSoln1 = Math.round(valueSoln1);
				valueSoln2 = Math.round(valueSoln2);
			} else if (Main.nearestTenth.isSelected()) {
				valueSoln1 = Math.round(valueSoln1 * 10);
				valueSoln2 = Math.round(valueSoln2 * 10);
				valueSoln1 = valueSoln1 / 10;
				valueSoln2 = valueSoln2 / 10;
			} else if (Main.nearestHundredth.isSelected()) {
				valueSoln1 = Math.round(valueSoln1 * 100);
				valueSoln2 = Math.round(valueSoln2 * 100);
				valueSoln1 = valueSoln1 / 100;
				valueSoln2 = valueSoln2 / 100;
			} else if (Main.nearestThousandth.isSelected()) {
				valueSoln1 = Math.round(valueSoln1 * 1000);
				valueSoln2 = Math.round(valueSoln2 * 1000);
				valueSoln1 = valueSoln1 / 1000;
				valueSoln2 = valueSoln2 / 1000;
			} else if (Main.nearestTenThousandth.isSelected()) {
				valueSoln1 = Math.round(valueSoln1 * 10000);
				valueSoln2 = Math.round(valueSoln2 * 10000);
				valueSoln1 = valueSoln1 / 10000;
				valueSoln2 = valueSoln2 / 10000;
			}
		}

		String textSoln1 = Double.toString(valueSoln1);
		if (textSoln1.endsWith(".0")) {
			textSoln1 = textSoln1.replace(".0", "");
		}
		String textSoln2 = Double.toString(valueSoln2);
		if (textSoln2.endsWith(".0")) {
			textSoln2 = textSoln2.replace(".0", "");
		}

		// Fixing +/- Symbols
		if (value4AC >= 0) {
			text4AC = " + " + text4AC;
		} else {
			text4AC = " - " + text4AC;
		}

		// Answer
		Main.solutionOutput
				.setText(Main.solutionOutput.getText().replace("potato", "{" + textSoln1 + ", " + textSoln2 + "}"));

		String Work = "";

		if (Main.chkboxShowWork.isSelected()) {
			// Work (1)
			Work = "\nWork:\nx = " + textBNeg + "/(2*" + textA + ") ± (√" + textB + "² - 4*" + textA + "*" + textC
					+ ")/(2*" + textA + ")" + "\n";
			// Work (2)
			Work = Work + "x = " + textBNeg + "/" + textATwo + " ± (√" + textBSquared + text4AC + ")/" + textATwo
					+ "\n";
			// Work (3)
			Work = Work + "x = " + textBNeg + "/" + textATwo + " ± (√" + textDeterminant + ")/" + textATwo + "\n";
			// Work (4)
			Work = Work + "x = " + textBNeg + "/" + textATwo + " ± " + textSqrt + "/" + textATwo + "\n";
			// Work (5)
			Work = Work + "x = " + textBNegTwoA + " ± " + textSqrt2A + "\n";
			// Work (6)
			Work = Work + "x = {" + textBNegTwoA + "+" + textSqrt2A + ", " + textBNegTwoA + "-" + textSqrt2A + "}\n";
			// Work (7)
			Work = Work + "x = {" + textSoln1 + ", " + textSoln2 + "}\n";
			// Put it all together

			Main.solutionOutput
					.setText(Main.solutionOutput.getText().replace("31415", Work + "————————————————————————————\n"));
		} else {
			Main.solutionOutput
					.setText(Main.solutionOutput.getText().replace("31415", "————————————————————————————\n"));
		}
	}
}
