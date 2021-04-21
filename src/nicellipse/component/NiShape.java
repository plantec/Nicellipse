package nicellipse.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.CubicCurve2D;

import javax.swing.JComponent;

public class NiShape extends JComponent implements NiBasicComponent {
	private static final long serialVersionUID = -3829818147581275076L;
	Shape shape;
	Stroke stroke;
	
	public Shape defaultShape() {
		return new Rectangle(0,0,40,40);
	}
	
	public Stroke defaultStroke() {
		return new BasicStroke(1);
	}
	
	public Color defaultBackground() {
		return Color.white;
	}

	public Color defaultForeground() {
		return Color.black;
	}
	
	public NiShape() {
		this.shape = this.defaultShape();
		this.defaultSetup();
	}
	
	public NiShape(Shape shape) {
		this();
		this.setShape(shape);
	}

	public void setShape(Shape shape) {
		this.shape = shape;
		this.setUp();
	}
	
	public void defaultSetup() {
		this.setBackground(this.defaultBackground());
		this.setForeground(this.defaultForeground());
		this.setLayout(null);
		stroke = this.defaultStroke();
		Rectangle r = this.shape.getBounds();
		this.setBounds(r);
		this.setPreferredSize(this.getSize());
	}
	
	public void setUp() {
		this.setBounds(this.shape.getBounds());
		this.setPreferredSize(this.getSize());
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.translate(-this.getX(), -this.getY());
		g2d.clip(this.getClipShape());
		super.paint(g2d);
		g2d.dispose();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.clip(this.getClipShape());
		super.paintComponent(g2d);
		g2d.setColor(this.getBackground());
		g2d.setStroke(this.stroke);
		g2d.fill(this.shape);
		g2d.setColor(this.getForeground());
		g2d.draw(this.shape);
		g2d.dispose();
	}
	
	public Shape getClipShape() {
		return this.shape;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

	public void setStrokeWidth(float w) {
		this.setStroke(new BasicStroke(w, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
	}

	public void setLineColor(Color color) {
		this.setForeground(color);
	}

}
