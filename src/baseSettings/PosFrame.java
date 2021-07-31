package baseSettings;

import java.awt.*;

import javax.swing.*;

public class PosFrame extends JFrame {
	
	public void setDefaultOptions() {
		setSize(1300,800);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
		setResizable(false); 
		setVisible(true); 
	}
}
