package nicellipse.examples;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import nicellipse.component.NiEllipse;
import nicellipse.component.NiImage;
import nicellipse.component.NiLabel;
import nicellipse.component.NiRectangle;
import nicellipse.component.NiShape;
import nicellipse.component.NiSpace;

public class Example8 {
	public static void main(String[] args) throws IOException {
		NiSpace space = new NiSpace("Space with shapes", new Dimension(550, 550));

		NiRectangle container = new NiRectangle();
		container.setBackground(Color.white);
		container.setSize(new Dimension(500,500));
		container.setLocation(10, 10);
		
		space.add(container);

		int xPoly[] = {150,250,325,375,450,275,100};
        int yPoly[] = {150,100,125,225,250,375,300};
        Polygon polygon = new Polygon(xPoly, yPoly, xPoly.length);
		NiShape shape3 = new NiShape(polygon);
		shape3.setStroke(new BasicStroke(10));
		shape3.setBackground(Color.blue);
		container.add(shape3);
				
		space.openInWindow();
		space.repaint();
		
		
	}

}
