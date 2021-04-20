package nicellipse.component;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;

import javax.swing.JComponent;

public class NiImage extends JComponent implements NiBasicComponent {
	private static final long serialVersionUID = 606824579470358701L;
	private Image image;

	public NiImage(Image image) {
		this.image = image;
		int width          = this.image.getWidth(null);
		int height         = this.image.getHeight(null);
		this.setBounds(0,0,width,height);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Shape previousClip = g.getClip();
		
		g.setClip(this.getClipShape());
		g.translate(getX(), getY());
		g.drawImage(this.image, 0, 0, null);
		g.translate(-getX(), -getY());
		g.setClip(previousClip);
	}
}
