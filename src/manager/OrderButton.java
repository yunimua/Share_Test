package manager;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class OrderButton extends JButton{

    public OrderButton() {
        super();
    }

    public OrderButton(String exp,int cur_x,int cur_y,int wid,int height,int color) {

        super(exp);

        super.setBounds(cur_x, cur_y, wid, height);
        super.setFont(new Font("System",Font.BOLD,20));
        super.setBackground(new Color(color));
    }
}