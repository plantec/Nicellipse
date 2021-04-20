package nicellipse.examples;

import java.awt.Color;
import java.awt.Dimension;

import nicellipse.component.NiRectangle;
import nicellipse.component.NiSpace;

public class Example1 {
	public static void main(String[] args) {
		NiSpace space = new NiSpace("Space with two Rectangles", new Dimension(140, 200));
		
		NiRectangle pane = new NiRectangle();
		pane.setBounds(5, 5, 20, 20);
		pane.setBackground(Color.red);
		space.add(pane);
		
		NiRectangle rect = new NiRectangle();
		rect.setBounds(30, 30, 100, 50);
		space.add(rect);
		
		NiRectangle inner = new NiRectangle();
		inner.setBounds(10, 10, 200, 20);
		inner.setBackground(Color.black);
		rect.add(inner);
		
		space.openInWindow();
	}

}
