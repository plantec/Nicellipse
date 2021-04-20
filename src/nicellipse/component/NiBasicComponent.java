package nicellipse.component;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;

public interface NiBasicComponent {

	void setBackground(Color defaultBackground);
	default Color defaultBackground() { return Color.blue; }
	
	default void defaultSetup() { 
		this.setBackground(this.defaultBackground());
	}
	
	default Shape getClipShape() {
		return this.getBounds();
	}
	
	public Rectangle getBounds();
	
}
