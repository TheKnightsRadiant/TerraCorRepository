package main;

public class Soln4_2Answer_NegRoot {
	// Solution for ones that have 2 answers and neg root (w/ i)
	public static void Soln4UseI(double valueA, double valueB, double valueC) {
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
		double valueDeterminant = Math.abs(valueBSquared + value4AC);
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

		double valueSqrt2ASoln = valueSqrt2A;
		// Rounding
		if (Main.chkboxRound.isSelected()) {
			if (Main.nearestInt.isSelected()) {
				valueBNegTwoA = Math.round(valueBNegTwoA);
				valueSqrt2ASoln = Math.round(valueSqrt2ASoln);
			} else if (Main.nearestTenth.isSelected()) {
				valueBNegTwoA = Math.round(valueBNegTwoA * 10);
				valueBNegTwoA = valueBNegTwoA / 10;
				valueSqrt2ASoln = Math.round(valueSqrt2ASoln * 10);
				valueSqrt2ASoln = valueSqrt2ASoln / 10;
			} else if (Main.nearestHundredth.isSelected()) {
				valueBNegTwoA = Math.round(valueBNegTwoA * 100);
				valueBNegTwoA = valueBNegTwoA / 100;
				valueSqrt2ASoln = Math.round(valueSqrt2ASoln * 100);
				valueSqrt2ASoln = valueSqrt2ASoln / 100;
			} else if (Main.nearestThousandth.isSelected()) {
				valueBNegTwoA = Math.round(valueBNegTwoA * 1000);
				valueBNegTwoA = valueBNegTwoA / 1000;
				valueSqrt2ASoln = Math.round(valueSqrt2ASoln * 1000);
				valueSqrt2ASoln = valueSqrt2ASoln / 1000;
			} else if (Main.nearestTenThousandth.isSelected()) {
				valueBNegTwoA = Math.round(valueBNegTwoA * 10000);
				valueBNegTwoA = valueBNegTwoA / 10000;
				valueSqrt2ASoln = Math.round(valueSqrt2ASoln * 10000);
				valueSqrt2ASoln = valueSqrt2ASoln / 10000;
			}
		}
		String textBNegTwoA = Double.toString(valueBNegTwoA);
		if (textBNegTwoA.endsWith(".0")) {
			textBNegTwoA = textBNegTwoA.replace(".0", "");
		}

		String textSqrt2ASoln = Double.toString(valueSqrt2ASoln);
		if (textSqrt2ASoln.endsWith(".0")) {
			textSqrt2ASoln = textSqrt2ASoln.replace(".0", "");
		}

		// Fixing +/- Symbols
		if (value4AC >= 0) {
			text4AC = " + " + text4AC;
		} else {
			text4AC = " - " + text4AC;
		}

		// Answer
		Main.solutionOutput
				.setText(Main.solutionOutput.getText().replace("potato", "{" + textBNegTwoA + "+" + textSqrt2ASoln
						+ "(i)" + ", " + textBNegTwoA + "-" + textSqrt2ASoln + "(i)" + "}\n" + "(No real solution)"));

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
			Work = Work + "x = " + textBNeg + "/" + textATwo + " ± " + textSqrt + "(i)" + "/" + textATwo + "\n";
			// Work (5)
			Work = Work + "x = " + textBNegTwoA + " ± " + textSqrt2A + "(i)" + "\n";
			// Work (6)
			Work = Work + "x = {" + textBNegTwoA + "+" + textSqrt2ASoln + "(i)" + ", " + textBNegTwoA + "-"
					+ textSqrt2ASoln + "(i)" + "}\n";
			// Put it all together

			Main.solutionOutput
					.setText(Main.solutionOutput.getText().replace("31415", Work + "————————————————————————————\n"));
		} else {
			Main.solutionOutput
					.setText(Main.solutionOutput.getText().replace("31415", "————————————————————————————\n"));
		}
	}

	// Solution for ones that have 2 answers and neg root (w/o i)
	public static void Soln4NoI(double valueA, double valueB, double valueC) {

	}
}
