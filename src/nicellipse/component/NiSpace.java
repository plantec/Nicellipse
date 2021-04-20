package nicellipse.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NiSpace extends JPanel implements NiBasicComponent {
	private static final long serialVersionUID = -7681440479994731039L;
	private String name;
	
	
	public Color defaultBackground() {
		return Color.white;
	}
	
	public NiSpace(String name, Dimension dim) {
		this.defaultSetup();
		this.name = name;
		this.setPreferredSize(dim);
		this.setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setClip(this.getClipShape());
		super.paintComponent(g2d);
		g2d.dispose();
	}
	
	public void paintChildren(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setClip(this.getClipShape());
		super.paintChildren(g2d);
		g2d.dispose();
	}
	
	public void openInWindow() {
		JFrame frame = new JFrame(name);
		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		frame.addWindowListener(wa);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		requestFocus();
	}


}
