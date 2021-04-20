package nicellipse.examples;

import java.awt.Dimension;

import nicellipse.component.NiSpace;

public class Example0 {
	public static void main(String[] args) {
		NiSpace space = new NiSpace("Empty Space", new Dimension(300, 200));
		space.openInWindow();
	}
}
