package nicellipse.examples;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import nicellipse.component.NiCubicCurve;
import nicellipse.component.NiEllipse;
import nicellipse.component.NiLine;
import nicellipse.component.NiPolyLine;
import nicellipse.component.NiRectangle;
import nicellipse.component.NiSpace;

public class Example4 {
	public static void main(String[] args) {
		
		NiSpace space = new NiSpace("Some components", new Dimension(800,600));

		Point start = new Point(100, 150); 
		Point control1 = new Point(400, 40);
		Point control2 = new Point(175, 250);
		Point end = new Point(500, 150);
		NiCubicCurve curve = new NiCubicCurve(start, control1, control2, end);
		space.add(curve);

		NiLine line = new NiLine(new Point(10,30), new Point(150,60));
		line.setColor(Color.black);
		line.setWidth(2);
		space.add(line);
		
		
		NiEllipse ellipse = new NiEllipse();
		ellipse.setBounds(50,20,270,270);
		ellipse.setBackground(Color.yellow);
		space.add(ellipse);
		
		NiPolyLine pline = new NiPolyLine();
		pline.setWidth(8);
		pline.addPoint(new Point(5,140));
		pline.addPoint(new Point(50,180));
		pline.addPoint(new Point(70,130));
		pline.addPoint(new Point(95,180));
		pline.addPoint(new Point(150,130));
		pline.addPoint(new Point(170,180));
		pline.moveTo(0, 100);
		space.add(pline);

		NiRectangle pane = new NiRectangle();
		pane.setBounds(100, 100, 200, 200);
		pane.setBackground(Color.red);
		space.add(pane);

		
		space.openInWindow();
	}

}
