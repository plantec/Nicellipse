package nicellipse.examples;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;

import nicellipse.component.NiEllipse;
import nicellipse.component.NiRectangle;
import nicellipse.component.NiSpace;

public class Example5 {

	public static void main(String[] args) {
		int population = 5000;
		Random x = new Random();
		NiSpace space = new NiSpace("It makes me mad", new Dimension(800, 600));
		NiRectangle gb = new NiRectangle();
		gb.setBounds(10, 10, 780, 580);
		gb.setBackground(Color.lightGray);

		space.add(gb);

		int width = gb.getWidth();
		int height = gb.getHeight();
		
		for (int i = 0; i < population/2; i++) {
			int ox = x.nextInt(width);
			int oy = x.nextInt(height);
			NiEllipse oval = new NiEllipse();
			oval.setBackground(new Color((int) (Math.random() * 0x1000000)));
			oval.setBounds(ox, oy, x.nextInt(50), x.nextInt(50));
			gb.add(oval);
		}
		
		for (int i = 0; i < population/2; i++) {
			int ox = x.nextInt(width);
			int oy = x.nextInt(height);
			NiRectangle rect = new NiRectangle();
			rect.setBackground(new Color((int) (Math.random() * 0x1000000)));
			rect.setBounds(ox, oy, x.nextInt(30), x.nextInt(30));
			gb.add(rect);
		}
		space.openInWindow();
		

		int delay = 50; // milliseconds
		ActionListener taskPerformer = new ActionListener() {
			List<Component> removed = new ArrayList<Component>();

			public void actionPerformed(ActionEvent evt) {
				gb.setLocation(new Point(x.nextInt(11), x.nextInt(11)));
				Component[] elements = gb.getComponents();
				for (int i = 0; i < elements.length; i++) {
					Component next = (Component) elements[i];
					Point loc = next.getLocation();
					next.setLocation(loc.x + x.nextInt(11) - 5, loc.y + x.nextInt(11) - 5);
					if (x.nextInt(10) == 0) {
						removed.add(next);
					}
				}
				if (gb.getComponents().length < 10) {
					for (Component c : removed)
						gb.add(c);
					removed.clear();
				}
				else
					for (Component c : removed)
						gb.remove(c);

				space.repaint();
			}
		};
		Timer animation = new Timer(0, taskPerformer);
		animation.setDelay(delay);
		animation.start();
	
	}


}
