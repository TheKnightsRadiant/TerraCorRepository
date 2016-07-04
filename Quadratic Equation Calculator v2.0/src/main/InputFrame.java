package main;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class InputFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public InputFrame() {
		super("QEC2.0 - Input");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(200, 200, 370, 370);
		getContentPane().setLayout(null);

		JLabel Title = new JLabel("Quadratic Equation Calc:");
		Title.setFont(Main.titleFontA);
		Title.setBounds(20, 10, 300, 30);
		getContentPane().add(Title);

		JLabel AText = new JLabel("A:");
		AText.setFont(Main.labelFontA);
		AText.setBounds(10, 70, 25, 30);
		getContentPane().add(AText);

		Main.aInput.setFont(Main.textFontA);
		Main.aInput.setBounds(50, 70, 250, 30);
		getContentPane().add(Main.aInput);

		JLabel BText = new JLabel("B:");
		BText.setFont(Main.labelFontA);
		BText.setBounds(10, 120, 25, 30);
		getContentPane().add(BText);

		Main.bInput.setFont(Main.textFontA);
		Main.bInput.setBounds(50, 120, 250, 30);
		getContentPane().add(Main.bInput);

		JLabel CText = new JLabel("C:");
		CText.setFont(Main.labelFontA);
		CText.setBounds(10, 170, 25, 30);
		getContentPane().add(CText);

		Main.cInput.setFont(Main.textFontA);
		Main.cInput.setBounds(50, 170, 250, 30);
		getContentPane().add(Main.cInput);

		Main.chkboxAdvancedInfo.setBounds(100, 200, 150, 20);
		Main.chkboxAdvancedInfo.setSelected(true);
		getContentPane().add(Main.chkboxAdvancedInfo);

		Main.chkboxShowWork.setBounds(100, 220, 150, 20);
		Main.chkboxShowWork.setSelected(true);
		getContentPane().add(Main.chkboxShowWork);

		Main.chkboxRound.setBounds(100, 240, 150, 20);
		Main.chkboxRound.setSelected(true);
		getContentPane().add(Main.chkboxRound);
		MiscListener MiscListener = new MiscListener();
		Main.chkboxRound.setActionCommand("Round");
		Main.chkboxRound.addActionListener(MiscListener);

		Main.roundGroup.add(Main.nearestInt);
		Main.roundGroup.add(Main.nearestTenth);
		Main.roundGroup.add(Main.nearestHundredth);
		Main.roundGroup.add(Main.nearestThousandth);
		Main.roundGroup.add(Main.nearestTenThousandth);

		Main.nearestInt.setBounds(0, 260, 37, 20);
		Main.nearestInt.setFont(Main.checkFontA);
		getContentPane().add(Main.nearestInt);

		Main.nearestTenth.setBounds(40, 260, 51, 20);
		Main.nearestTenth.setFont(Main.checkFontA);
		getContentPane().add(Main.nearestTenth);

		Main.nearestHundredth.setBounds(94, 260, 75, 20);
		Main.nearestHundredth.setFont(Main.checkFontA);
		getContentPane().add(Main.nearestHundredth);

		Main.nearestThousandth.setBounds(172, 260, 81, 20);
		Main.nearestThousandth.setFont(Main.checkFontA);
		getContentPane().add(Main.nearestThousandth);

		Main.nearestTenThousandth.setBounds(256, 260, 96, 20);
		Main.nearestTenThousandth.setFont(Main.checkFontA);
		Main.nearestTenThousandth.setSelected(true);
		getContentPane().add(Main.nearestTenThousandth);

		Main.chkboxSimplifyRoot.setBounds(100, 280, 150, 20);
		Main.chkboxSimplifyRoot.setSelected(true);
		getContentPane().add(Main.chkboxSimplifyRoot);

		Main.chkboxUsei.setBounds(100, 300, 150, 20);
		Main.chkboxUsei.setSelected(false);
		getContentPane().add(Main.chkboxUsei);

		Main.calculate.setBounds(130, 320, 100, 20);
		getContentPane().add(Main.calculate);
		InputActionListener MainActionListener = new InputActionListener();
		Main.calculate.addActionListener(MainActionListener);
	}
}
