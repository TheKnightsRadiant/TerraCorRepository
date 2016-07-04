package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiscListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Round") {
			if (Main.chkboxRound.isSelected()) {
				Main.chkboxUsei.setBounds(100, 300, 150, 20);
				Main.chkboxSimplifyRoot.setBounds(100, 280, 150, 20);
				Main.nearestInt.setVisible(true);
				Main.nearestTenth.setVisible(true);
				Main.nearestHundredth.setVisible(true);
				Main.nearestThousandth.setVisible(true);
				Main.nearestTenThousandth.setVisible(true);
				Main.chkboxRound.setText("Round:");
			} else {
				Main.chkboxUsei.setBounds(100, 280, 150, 20);
				Main.chkboxSimplifyRoot.setBounds(100, 260, 150, 20);
				Main.nearestInt.setVisible(false);
				Main.nearestTenth.setVisible(false);
				Main.nearestHundredth.setVisible(false);
				Main.nearestThousandth.setVisible(false);
				Main.nearestTenThousandth.setVisible(false);
				Main.chkboxRound.setText("Round");
			}
		}
	}

}
