package igu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class PropiedadesSecundariasClara  extends BasicComboBoxUI{
	
	private Color c = new Color(83, 83, 115);	
	
	public static ComboBoxUI createUI(JComponent comp) {
		return new PropiedadesSecundariasClara();
	}
	@Override
	protected JButton createArrowButton() {
		JButton btn = new JButton();
		ImageIcon logo= new ImageIcon(getClass().getResource("/imgs/imagenMenuClara.png"));
		btn.setIcon(new ImageIcon(logo.getImage().getScaledInstance(24,23,Image.SCALE_SMOOTH)));
		return btn;
	} 

@Override
public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
	g.setColor(c);
	g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
}
	

	
}
