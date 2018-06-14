package org.sgdk.resourcemanager.ui.panels.components.components;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.apache.commons.lang3.StringUtils;
import org.sgdk.resourcemanager.entities.SGDKFXSound;

public class OutrateComponent extends JPanel{
		
	private static final long serialVersionUID = 1L;
	private SGDKFXSound fxSound = null;
	private JTextField outrate = new JTextField();
	
	public OutrateComponent() {
		super(new GridLayout(1,1));
		setBorder(
			BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),
				"Outrate",
				TitledBorder.RIGHT,
				TitledBorder.ABOVE_TOP
			)
		);
		
		outrate.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				if(fxSound != null  && !StringUtils.isEmpty(outrate.getText())){
					fxSound.setOutrate(Math.round(Float.valueOf(outrate.getText())));
				}
			}
		});
		add(outrate);
	}
	
	public void setSGDKFXSound(SGDKFXSound fxSound) {
		this.fxSound = fxSound;
		outrate.setText(""+ fxSound.getOutrate());
	}
	
}
