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

		Point start = new Point(5, 5); 
		Point control1 = new Point(400, 40);
		Point control2 = new Point(175, 250);
		Point end = new Point(800, 5);
		NiCubicCurve curve = new NiCubicCurve(start, control1, control2, end);
		curve.setStrokeWidth(10);
		space.add(curve);

		NiLine line = new NiLine(new Point(10,10), new Point(2000,500));
		line.setColor(Color.black);
		line.setStrokeWidth(20);
		space.add(line);
		
		
		NiEllipse ellipse = new NiEllipse();
		ellipse.setBounds(10,10,270,270);
		ellipse.setBackground(Color.yellow);
		space.add(ellipse);
		
		NiPolyLine pline = new NiPolyLine();
		pline.setStrokeWidth(8);
		pline.setBackground(Color.lightGray);
		pline.setLocation(0,0);
		pline.setSize(800,600);
		pline.addPoint(new Point(205,340));
		pline.addPoint(new Point(250,380));
		pline.addPoint(new Point(270,330));
		pline.addPoint(new Point(295,380));
		pline.addPoint(new Point(350,330));
		pline.addPoint(new Point(370,380));
		space.add(pline);
		
		NiRectangle pane = new NiRectangle();
		pane.setBounds(140, 140, 200, 200);
		pane.setBackground(Color.red);
		ellipse.add(pane);

		NiRectangle innerPane = new NiRectangle();
		innerPane.setBounds(30, 30, 300, 300);
		innerPane.setBackground(Color.gray);
		pane.add(innerPane);

		
		space.openInWindow();
	}

}
