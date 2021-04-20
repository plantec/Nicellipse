package nicellipse.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

public class NiCubicCurve extends JComponent implements NiBasicComponent {
	private static final long serialVersionUID = -3829818147581275076L;
	CubicCurve2D curve = new CubicCurve2D.Double();
	Stroke stroke;
	Color color;

	public NiCubicCurve(Point from, Point ctrl1, Point ctrl2, Point to) {
		curve.setCurve(from.x, from.y, ctrl1.x, ctrl1.y, ctrl2.x, ctrl2.y, to.x, to.y);
		stroke = new BasicStroke();
		this.defaultSetup();
		this.setBounds(this.curve.getBounds());
		this.color = this.defaultColor();
	}

	public Color defaultColor() {
		return Color.magenta;
	}

	public void moveTo(int x, int y) {
		Point2D from = curve.getP1();
		Point2D to = curve.getP2();
		Point2D ctrl1 = curve.getCtrlP1();
		Point2D ctrl2 = curve.getCtrlP1();
		from.setLocation(from.getX() + x, from.getY() + y);
		to.setLocation(to.getX() + x, to.getY() + y);
		ctrl1.setLocation(ctrl1.getX() + x, ctrl1.getY() + y);
		ctrl2.setLocation(ctrl2.getX() + x, ctrl2.getY() + y);
		this.setBounds(this.curve.getBounds());
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(this.getBackground());
		g2d.translate(-getX(), -getY());
		Rectangle gcr = new Rectangle();

		g2d.getClipBounds(gcr);
		Shape cr = this.getClipShape();
		if (cr.intersects(gcr)) {
			Area area1;
			Area area2;
			area1 = new Area(gcr);
			area2 = new Area(cr);
			area1.intersect(area2);
			g2d.setClip(area1);
			g2d.setStroke(this.stroke);
			g2d.setColor(this.color);

			g2d.draw(this.curve);
		}

		g2d.dispose();
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

	public void setStrokeWidth(float w) {
		this.setStroke(new BasicStroke(w, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setWidth(float w) {
		setStroke(new BasicStroke(w));
	}

}
