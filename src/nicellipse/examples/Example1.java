package nicellipse.examples;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import nicellipse.component.NiEllipse;
import nicellipse.component.NiImage;
import nicellipse.component.NiSpace;

public class Example1 {
	public static void main(String[] args) {
		NiSpace space = new NiSpace("Space with circles", new Dimension(400, 400));
				
		NiEllipse circle = new NiEllipse();
		circle.setBounds(0, 0, 300, 300);
		space.add(circle);
		
		NiEllipse inner = new NiEllipse();
		inner.setSize(100, 100);
		inner.setCenter(circle.getCenter());
		inner.setBackground(Color.yellow);
		circle.add(inner);
		
		File path = new File("I_love_Brest_city.jpg");
		BufferedImage rawImage = null;
		try {
			rawImage = ImageIO.read(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		NiImage image = new NiImage(rawImage);
		image.setCenter(circle.getCenter());
		circle.add(image);
		
		space.setBackground(Color.lightGray);
		space.openInWindow();
	}

}
