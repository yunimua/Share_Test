import javax.swing.*;

import baseSettings.PosFrame;
import manager.*;

public class Main extends PosFrame {

	/*
	 	모든 화면들을 띄워줄 기본 프래임.
	 */
	public Main() {
		super();
		setLayout(null);
		
		Manager_Btns mb = new Manager_Btns();
		for(JButton btns : mb.getJBtns()) {
			add(btns);
		}
		
	}
	
	public static void main(String[] args) {
		Main frame = new Main();
		frame.setDefaultOptions();
	}
}
