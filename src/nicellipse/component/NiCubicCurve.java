package nicellipse.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.CubicCurve2D;

import javax.swing.JComponent;

public class NiCubicCurve extends JComponent implements NiBasicComponent {
	private static final long serialVersionUID = -3829818147581275076L;
	CubicCurve2D curve = new CubicCurve2D.Double();
	Stroke stroke;

	public NiCubicCurve(Point from, Point ctrl1, Point ctrl2, Point to) {
		curve.setCurve(from.x, from.y, ctrl1.x, ctrl1.y, ctrl2.x, ctrl2.y, to.x, to.y);
		stroke = new BasicStroke(1);
		this.defaultSetup();
		this.setBounds(this.curve.getBounds());
		this.setForeground(this.defaultColor());
	}

	public Color defaultColor() {
		return Color.magenta;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(this.getForeground());
		g2d.clip(this.getClipShape());
		g2d.setStroke(this.stroke);
		super.paintComponent(g2d);
		g2d.draw(this.curve);
		g2d.dispose();
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
