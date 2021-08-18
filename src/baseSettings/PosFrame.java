package baseSettings;

import java.awt.*;

import javax.swing.*;

public class PosFrame extends JFrame {
	private Image img = Toolkit.getDefaultToolkit().getImage("image/coffee_bg.png");
	
	public void setDefaultOptions() {	
		setSize(1300,800);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); 
		setVisible(true); 
		
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon("image/coffee_bg.png"));
		add(background);
	}
}
