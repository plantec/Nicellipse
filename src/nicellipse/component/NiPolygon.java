package nicellipse.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JComponent;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Iterator;

public class NiPolygon extends JComponent implements NiBasicComponent {
	private static final long serialVersionUID = -5784576824493195326L;
	Polygon polygon;
	Stroke stroke;

	public NiPolygon(List<Point> points) {
		stroke = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
		this.polygon = new Polygon();
		Iterator<Point> itor = points.iterator();
		while (itor.hasNext()) {
			Point next = itor.next();
			this.polygon.addPoint(next.x, next.y);
		}
		this.setBounds(this.polygon.getBounds());
	}

	public NiPolygon(int [] xs, int [] ys) {
		stroke = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
		this.polygon = new Polygon();
		for (int i = 0; i < xs.length; i++) {
			this.polygon.addPoint(xs[i], ys[i]);
		}
		this.setBounds(this.polygon.getBounds());
	}

	public NiPolygon() {
		this.polygon = new Polygon();
		stroke = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
		this.setBounds(this.polygon.getBounds());
	}

	public Color defaultColor() {
		return Color.cyan;
	}

	public void addPoint(Point p) {
		this.polygon.addPoint(p.x, p.y);
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		super.paint(g2d);
		g2d.dispose();
	}
		
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setStroke(this.stroke);
		g2d.setColor(this.getForeground());
		super.paintComponent(g2d);
		
		g2d.draw(this.polygon);

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
