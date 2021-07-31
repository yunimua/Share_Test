package baseSettings;

import java.awt.*;

import javax.swing.*;

public class PosFrame extends JFrame {
	
	public void setDefaultOptions() {
		// 프레임 사이즈 설정
		setSize(1300,800);
		
		// Dimension : 자신 화면의 크기, 가로세로 값을 저장해주는 클래스
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
		/*
			dim.width/2 : 내 화면의 가로 길이를 반으로 나누고,
			getSize().width/2 : 내가 만든 프레임의 가로 길이를 반으로 나눔
			dim.height/2 : 내 화면의 세로 길이를 반으로 나누고,
			getSize().height/2 : 내가 만든 프레임의 세로 길이를 반으로 나눔
			위에 2가지를 setLocation(x좌표,y좌표)에 넣으면 화면 정 중앙에 프레임이 출력된다.
		*/
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
		
		// 사이즈 조절을 하게할지(true) 말지 (false)
		setResizable(false); 
		
		// 화면에 출력할지(true) 말지(false)
		setVisible(true); 
	}
}
