package nicellipse.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class NiRectangle extends JPanel implements NiBorderedComponent {
	private static final long serialVersionUID = 128422045550852289L;

	public NiRectangle() {
		this.defaultSetup();
		this.setLayout(null);
	}

	public void paintChildren(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setClip(this.getBounds());
		//g2d.setClip(new Rectangle(100,100, 300, 300));
		super.paintChildren(g2d);
		g2d.dispose();
	}
	

}
