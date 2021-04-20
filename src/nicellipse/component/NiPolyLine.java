package nicellipse.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JComponent;

import java.awt.Point;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Iterator;

public class NiPolyLine extends JComponent implements NiBasicComponent {
	private static final long serialVersionUID = -5784576824493195326L;
	ArrayList<Point> points;
	Stroke stroke;

	public NiPolyLine(List<Point> points) {
		Iterator<Point> itor = points.iterator();
		while (itor.hasNext())
			this.points.add(itor.next());
	}

	public NiPolyLine() {
		points = new ArrayList<Point>();
		stroke = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
	}

	public Color defaultColor() {
		return Color.cyan;
	}
	
	public void addPoint(Point p) {
		points.add(p);
	}

	public void removePoint(Point p) {
		points.remove(p);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Stroke previousStroke = g2d.getStroke();
		Color previousColor = g2d.getColor();
		int[] x = new int[points.size()];
		int[] y = new int[points.size()];
		int idx = 0;
		Iterator<Point> itor = points.iterator();
		while (itor.hasNext()) {
			Point curr = itor.next();
			x[idx] = curr.x;
			y[idx] = curr.y;
			idx++;
		}
		g2d.setStroke(stroke);
		g2d.setColor(this.getBackground());
		g2d.drawPolyline(x, y, idx);
		g2d.setColor(previousColor);
		g2d.setStroke(previousStroke);
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

	public void setWidth(float w) {
		this.setStroke(new BasicStroke(w, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
	}

	public void moveTo(int x, int y) {
		for (Point p : points) {
			p.translate(x, y);
		}
	}

}
