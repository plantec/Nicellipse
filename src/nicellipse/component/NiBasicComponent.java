package nicellipse.component;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

public interface NiBasicComponent {

	void setBackground(Color defaultBackground);

	default Color defaultBackground() {
		return Color.blue;
	}

	default void defaultSetup() {
		this.setBackground(this.defaultBackground());
		this.setLayout(null);
	}

	void setLayout(LayoutManager m);

	default Shape getClipShape() {
		return this.getBounds();
	}

	default void setCenter(Point p) {
		Point c = new Point(p.x, p.y);
		c.translate(-(this.getWidth() / 2), -(this.getHeight() / 2));
		this.setBounds(c.x, c.y, this.getWidth(), this.getHeight());
	}

	void setBounds(int x, int y, int w, int h);

	default Point getCenter() {
		Rectangle bnds = this.getBounds();
		Point c = new Point((int) bnds.getCenterX(), (int) bnds.getCenterY());
		Point l = this.getLocation();
		c.translate(-l.x, -l.y);
		return c;
	}

	int getWidth();

	int getHeight();

	Point getLocation();
	void setLocation(Point p);

	public Rectangle getBounds();

}
