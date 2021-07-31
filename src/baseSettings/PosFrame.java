package baseSettings;

import java.awt.*;

import javax.swing.*;

public class PosFrame extends JFrame {
	
	public void setDefaultOptions() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(new Point(100, 100));
		setSize(new Dimension(1200, 900));
		setVisible(true);
	}
}
