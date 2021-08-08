package manager;
import java.awt.*;
import java.util.*;

import javax.swing.*;

// 관리자메뉴 버튼 5개 위치, 크기 설정
public class Manager_Btns extends JButton {

	private ArrayList<JButton> btns;
	
	public Manager_Btns() {
		btns = new ArrayList<>();	
		
		// 각각의 버튼 이름, 위치, 크기, 폰트, 버튼배경색을 설정
		btns.add(new JButton() {
			{
			setText("매출 현황");
			setFont(new Font("default", Font.BOLD, 16));
			setBackground(new Color(0xD7E7F7));
			}
		});
		
		btns.add(new JButton() {
			{
			setText("마감 용지 출력");
			setFont(new Font("default", Font.BOLD, 16));
			setBackground(new Color(0xD7E7F7));
			}
		});
		
		btns.add(new JButton() {
			{
			setText("직원 등록");
			setFont(new Font("default", Font.BOLD, 16));
			setBackground(new Color(0xD7E7F7));
			}
		});
		
		btns.add(new JButton() {
			{
			setText("출퇴근 기록 열람");
			setFont(new Font("default", Font.BOLD, 16));
			setBackground(new Color(0xD7E7F7));
			}
		});
		
		btns.add(new JButton() {
			{
			setText("메뉴 관리");
			setFont(new Font("default", Font.BOLD, 16));
			setBackground(new Color(0xD7E7F7));
			}
		});
	}
	
	public ArrayList<JButton> getJBtns() {
		return btns;	
	}
}