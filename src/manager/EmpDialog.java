package manager;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;

import javax.swing.*;

import baseSettings.*;

public class EmpDialog extends JDialog {
//EmpRegister, position
	/*
	 	# 직원 등록 팝업 창
	 	  - 직원 이름 입력, 전화번호 입력, 직급 선택 후 추가 버튼을 누르면 employees_info 테이블에 추가
	 	  
	 		- 메뉴 이름, 가격, 분류 입력 후 추가 버튼을 누르면 menu 테이블에 추가.
	 		- display_order는 분류의 마지막 번호 + 1로 추가.
	 		- 분류가 추가되면 콤보박스에도 새로 추가, display_order는 1로 추가.
	*/
	
	JTextField emp_name = new JTextField(20);
	JTextField emp_tel = new JTextField(20);
	JTextField emp_degree = new JTextField(10);
	
	//직원등급 리스트
	ArrayList<String> position;
	
	JComboBox<String> cb_pos;
	JButton btn_add = new JButton("등록");
	JButton btn_can = new JButton("취소");
	
	public EmpDialog() {		

		position = new ArrayList();
		// 직원등급 불러오기
		selTypes();
		cb_pos = new JComboBox<String>(position.toArray(new String[position.size()]));
		cb_pos.setPreferredSize(new Dimension(100, 20));
//		btn_add.setSize(new Dimension(150, 20));
		
		setLayout(new FlowLayout());
		add(new JLabel("이름"));
		add(emp_name);
		add(new JLabel("전화번호"));
		add(emp_tel);
		add(new JLabel("직급"));
		add(cb_pos);
		add(emp_degree);
		add(btn_add);
		add(btn_can);
		setSize(270, 160);
		setLocation(100, 100);
		
		btn_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				if(ptChk) {
//					System.out.println("입력하신 정보가 올바르지 않습니다. 다시 확인해 주시기 바랍니다.");
//					return;
//				}
				// 이름 번호가 비어있는 경우 리턴
				if(emp_name.getText().equals("") || emp_tel.getText().equals("")) {
					System.out.println("입력하신 정보가 올바르지 않습니다. 다시 확인해 주시기 바랍니다.");
					return;
				}

				InsertDB insert = new InsertDB();
				// 콤보 박스의 인덱스에 맞춰서 분류 이름 가져오기.
				
				insert.dbinsert("INSERT INTO employees_info VALUES((SELECT MAX(emp_no) + 1 FROM employees_info), "
						+ "'" + emp_name.getText() + "', '" + emp_tel.getText() + "', "
						+ "TO_DATE(sysdate, 'YY-MM-DD hh24:mi:ss')" + "'" + emp_degree.getText() + "'");
				
//				String r_name;
//				// 분류를 추가한 경우
//				if(cb_pos.getSelectedIndex() == cb_pos.getItemCount() - 1) {
//					r_name = emp_degree.getText();
//					if(r_name.equals("")) {
//						System.out.println("입력하신 정보가 올바르지 않습니다. 다시 확인해 주시기 바랍니다.");
//						return;
//					}
//					insert.dbinsert("INSERT INTO employees_info VALUES((SELECT MAX(emp_no) + 1 FROM employees_info), "
//							+ "'" + emp_name.getText() + "', '" + emp_tel.getText() + "', "
//							+ "TO_DATE(sysdate, 'YY-MM-DD hh24:mi:ss')" + "'" + emp_degree.getText() + "'");
//					
//					// 분류 새로 가져오기.
//					position.clear();
//					selTypes();
//					cb_pos.removeAllItems();
//					for(String pt : position) {
//						cb_pos.addItem(pt);
//					}
//				} else { // 분류 추가 없이 기존 분류에 추가한 경우
//					r_name = position.get(cb_pos.getSelectedIndex());
//					insert.dbinsert("INSERT INTO employees_info VALUES((SELECT MAX(emp_no) + 1 FROM employees_info), "
//							+ "'" + emp_name.getText() + "', '" + emp_tel.getText() + "', "
//							+ "TO_DATE(sysdate, 'YY-MM-DD hh24:mi:ss')" + "'" + r_name + "'");
//				}
//				
//				// 초기화
//				emp_name.setText("");
//				emp_tel.setText("");
//				emp_degree.setText("");
//				cb_pos.setSelectedIndex(0);
			}
		});
		
		// 취소 버튼 눌렀을 때 창 닫하기
		btn_can.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				emp_name.setText("");
				emp_tel.setText("");
				cb_pos.setSelectedIndex(0);
				setVisible(false);
			}
		});
	}
	
	// 직원 등급 db에서 가져오기.
	private void selTypes() {
		String sql = "SELECT DISTINCT emp_degree FROM employees_info";
	    try (
	    	Connection conn = DBConnector.getConnection();
	    	PreparedStatement pstmt = conn.prepareStatement(sql);
	    	ResultSet rs = pstmt.executeQuery();
	    	){
	    	
			while(rs.next()) {
				position.add(rs.getString("degree"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
