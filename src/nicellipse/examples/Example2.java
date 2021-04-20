package nicellipse.examples;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import nicellipse.component.NiEllipse;
import nicellipse.component.NiLabel;
import nicellipse.component.NiRectangle;
import nicellipse.component.NiSpace;

public class Example2 {
	public static void main(String[] args) {
		NiSpace space = new NiSpace("With flow layout", new Dimension(300, 200));
		space.setLayout(new FlowLayout());
		((FlowLayout) space.getLayout()).setAlignment(FlowLayout.TRAILING);
		
		NiLabel label = new NiLabel("Head");
		label.setFont(new Font("Arial", Font.BOLD, 24));
		label.setForeground(Color.darkGray);
		label.setBackground(Color.yellow);
		space.add(label);
		
		NiEllipse ellipse = new NiEllipse();
		ellipse.setBackground(Color.magenta);
		ellipse.setSize(new Dimension(50,50));
		ellipse.setPreferredSize(new Dimension(50,50));
		space.add(ellipse);
		
		NiEllipse subellipse = new NiEllipse();
		subellipse.setBackground(Color.white);
		subellipse.setSize(10,10);
		subellipse.setCenter(ellipse.getCenter());
		ellipse.add(subellipse);
		
		NiRectangle rectangle = new NiRectangle();
		rectangle.setBackground(Color.yellow);	
		rectangle.setPreferredSize(new Dimension(30,30));
		space.add(rectangle);
		
		NiEllipse ellipse2 = new NiEllipse();
		ellipse2.setBackground(Color.black);	
		ellipse2.setPreferredSize(new Dimension(30,30));
		space.add(ellipse2);
		
		NiRectangle rectangle2 = new NiRectangle();
		rectangle2.setBackground(Color.yellow);	
		rectangle2.setPreferredSize(new Dimension(30,30));
		space.add(rectangle2);

		NiEllipse ellipse3 = new NiEllipse();
		ellipse3.setBackground(Color.black);	
		ellipse3.setPreferredSize(new Dimension(30,30));
		space.add(ellipse3);
		
		NiRectangle rectangle3 = new NiRectangle();
		rectangle3.setBackground(Color.yellow);	
		rectangle3.setPreferredSize(new Dimension(30,30));
		space.add(rectangle3);
		
		NiLabel label2 = new NiLabel("Tail");
		label2.setFont(new Font("Arial", Font.BOLD, 24));
		label2.setForeground(Color.darkGray);
		label2.setBackground(Color.yellow);
		space.add(label2);


		space.openInWindow();
	
	}
}
