import java.awt.*;
import java.util.*;

import javax.swing.*;

import baseSettings.*;

public class Registration extends PosFrame {

	public Registration() {
		super();
		setLayout(null); 
		
		// 프레임 배경 색 변경
		getContentPane().setBackground(new Color(0xF5F6CE)); 

		// 관리자 메뉴 버튼 5개 추가
		Manager_Btns mb = new Manager_Btns();		
		for (JButton btns : mb.getJBtns()) {
			add(btns);
		}
	}
	
	public static void main(String[] args) {
		Registration frame = new Registration();
		frame.setDefaultOptions();
	}
}
