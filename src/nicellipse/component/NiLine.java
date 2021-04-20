package nicellipse.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class NiLine extends JComponent implements NiBasicComponent {
	private static final long serialVersionUID = -1617090627730247010L;
	Stroke stroke;
	Color color;
	Line2D line;
	
	public Color defaultColor() {
		return Color.magenta;
	}
	
	public NiLine(Point from, Point to) {
		this.line = new Line2D.Double(from, to);
		this.stroke = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
		this.color = this.defaultColor();
		Rectangle bnds = this.line.getBounds();
		Point loc = bnds.getLocation();
		this.setBounds(loc.x, loc.y, bnds.width, bnds.height);
	}
	
	public NiLine(int fromX, int fromY, int toX, int toY) {
		this(new Point(fromX, fromY), new Point(toX, toY));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Stroke previousStroke = g2d.getStroke();
		Color previousColor = g2d.getColor();
		Shape previousClip = g.getClip();
		
		g2d.setStroke(stroke);
		g2d.setColor(color);
		
		g.translate(-getX(), -getY());
		g.setClip(this.getClipShape());
		
		g2d.draw(this.line);
		
		g.setClip(previousClip);
		g.translate(getX(), getY());

		g2d.setColor(previousColor);
		g2d.setStroke(previousStroke);
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setWidth(float w) {
		setStroke(new BasicStroke(w));
	}

}
