package nicellipse.examples;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import java.awt.Component;
import nicellipse.component.NiEllipse;
import nicellipse.component.NiRectangle;
import nicellipse.component.NiSpace;


// Model 
class Something {
	Point pos;
	
	public Something(Point position) {
		this.pos = position;
	}
	
	public Point getPosition() {
		return pos;
	}
	
	public void move () {
		Random rand = new Random();
		this.pos.x = this.pos.x + rand.nextInt(11) - 5;
		this.pos.y = this.pos.y + rand.nextInt(11) - 5;
	}
}

// View : it knows its model
class SomethingView extends NiEllipse {
	private static final long serialVersionUID = 8010266472160477056L;
	Something thing;
	
	public SomethingView(Something model) {
		this.thing = model;
		this.setBackground(new Color((int) (Math.random() * 0x1000000)));
		this.setDimension(new Dimension(4,4));
		this.setLocation(this.thing.getPosition());
	}
	
	public void thingHasChanged() {
		this.setLocation(this.thing.getPosition());
	}
}


// The animation spec
class GraphicAnimation implements ActionListener {
	final int graphicAnimationDelay = 10;
	NiRectangle home;
	
	public GraphicAnimation(NiRectangle home) {
		this.home = home;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Component[] views =  this.home.getComponents();
		for (int i = 0; i < views.length; i++) {
			SomethingView next = (SomethingView) views[i];
			next.thingHasChanged();
		}
	}
	
	public void start() {
		Timer animation = new Timer(0, this);
		animation.setDelay(this.graphicAnimationDelay);
		animation.start();
	}
	
}

// The main app
public class MovingThings {
	ArrayList<Something> population;
	final int populationSize = 2000;
	NiRectangle home;
	
	public MovingThings() {
		population = new ArrayList<>();
		
		Random x = new Random();
		NiSpace space = new NiSpace("Moving things", new Dimension(800, 600));
		this.home = new NiRectangle();
		this.home.setBounds(100, 100, 600, 400);
		this.home.setBackground(Color.lightGray);

		space.add(this.home);
		space.setDoubleBuffered(true);

		int width = this.home.getWidth();
		int height = this.home.getHeight();
		
		for (int i = 0; i < this.populationSize; i++) {
			Something thing = new Something(new Point(x.nextInt(width), x.nextInt(height)));
			this.population.add(thing);
			SomethingView view = new SomethingView(thing);
			this.home.add(view);
		}
		
		space.openInWindow();
	}
	
	public void startGraphicAnimation() {
		GraphicAnimation animation = new GraphicAnimation(this.home);
		animation.start();
	}
	
	public void mainLoop() {
	
		while (true) {
			for (Something s : this.population) {
				s.move();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		MovingThings movingThings = new MovingThings();
		movingThings.startGraphicAnimation();
		movingThings.mainLoop();
	}


}
