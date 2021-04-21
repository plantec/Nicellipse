package nicellipse.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class NiLine extends JComponent implements NiBasicComponent {
	private static final long serialVersionUID = -1617090627730247010L;
	Stroke stroke;
	Line2D line;

	public Color defaultColor() {
		return Color.magenta;
	}

	public NiLine(Point from, Point to) {
		this.line = new Line2D.Double(from, to);
		this.stroke = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
		this.setForeground(this.defaultColor());
		Rectangle bnds = this.line.getBounds();
		Point loc = bnds.getLocation();
		this.setBounds(loc.x, loc.y, bnds.width, bnds.height);
	}

	public NiLine(int fromX, int fromY, int toX, int toY) {
		this(new Point(fromX, fromY), new Point(toX, toY));
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(this.getForeground());
		g2d.clip(this.getClipShape());
		g2d.setStroke(this.stroke);
		super.paintComponent(g2d);
		g2d.draw(this.line);
		g2d.dispose();
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

	public void setColor(Color color) {
		this.setForeground(color);
	}

	public void setStrokeWidth(float w) {
		this.setStroke(new BasicStroke(w, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
	}


}
