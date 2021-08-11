package manager;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.*;
import java.sql.*;
import java.text.*;
import java.util.*;

import javax.swing.*;

import baseSettings.*;

public class ActionBtns implements ActionListener {

	private String sql = "SELECT SUM(credit) AS card, "
			+ "SUM(cash) AS cash, SUM(total) AS total "
			+ "FROM history_payment WHERE state = 'complete' "
			+ "AND datetime > (select to_char(sysdate,'yyyy-mm-dd') from dual) ";
	private File f = new File("salesfile.txt"); 
	
	public ActionBtns() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane end = new JOptionPane();				
		Font f1 = new Font("", Font.BOLD, 15);
		UIManager.put("OptionPane.messageFont", f1);
		UIManager.put("OptionPane.minimumSize",new Dimension(200,100)); 
		sumDB();
		end.showMessageDialog(null, "마감 용지 출력이 완료되었습니다.", "마감 용지 출력", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void sumDB() {
		try (
	    	Connection conn = DBConnector.getConnection();
	    	PreparedStatement pstmt = conn.prepareStatement(sql);
	    	ResultSet rs = pstmt.executeQuery();
			BufferedWriter out = new BufferedWriter(new FileWriter(f, Charset.forName("UTF-8")));
	    	){
	    	ResultSetMetaData meta = rs.getMetaData();
	    	
			while(rs.next()) {
				int card = rs.getInt("card");
				int cash = rs.getInt("cash");
				int total = rs.getInt("total");
				System.out.println("◇ 현금 매출 합계 ◇ " + cash + " 원\n" 
						+ "◇ 카드 매출 합계 ◇ " + card + " 원\n" 
						+ "▶ cafe 매출 총 합계 ◀ " + total + " 원\n");
				
				out.write("◇ 현금 매출 합계 ◇");
				out.write(""+ cash);
				out.write("\n◇ 카드 매출 합계 ◇");
				out.write(""+ card);
				out.write("\n▶ cafe 매출 총 합계 ◀");
				out.write(""+ total);
				out.close();
			}
			System.out.println("매출 전표 저장 완료");

		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
