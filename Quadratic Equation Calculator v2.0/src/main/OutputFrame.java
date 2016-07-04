package main;

import javax.swing.JFrame;

public class OutputFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public OutputFrame() {
		super("QEC2.0 - Output");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(570, 200, 370, 370);
		getContentPane().setLayout(null);

		Main.solutionOutput.setBounds(10, 10, 345, 320);
		Main.solutionOutput.setFont(Main.textFontB);
		Main.solutionOutput.setEditable(false);
		Main.solutionOutput.setLineWrap(true);
		Main.solutionOutput.setWrapStyleWord(true);
		getContentPane().add(Main.solutionOutput);
	}
}
