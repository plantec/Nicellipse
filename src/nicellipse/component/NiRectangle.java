package nicellipse.component;

import java.awt.Dimension;

import javax.swing.JPanel;

public class NiRectangle extends JPanel implements NiBorderedComponent {
	private static final long serialVersionUID = 128422045550852289L;

	public NiRectangle() {
		this.defaultSetup();
		this.setLayout(null);
	}
	
	public void setDimension(Dimension dim) {
		this.setBounds(this.getX(), this.getY(), (int)dim.getWidth(), (int)dim.getHeight());
	}

}
