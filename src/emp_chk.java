import java.sql.*;
import java.util.*;

import baseSettings.*;

public class emp_chk {

	public static void main(String[] args) {
		chk_name();
	}
	
	public static void chk_name() {
		String sql = "SELECT * FROM employees_info";
		ArrayList<employees_info> list = new ArrayList<>();
		
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			ResultSetMetaData meta = rs.getMetaData();
		while(rs.next()) {
			list.add(new employees_info(
					rs.getInt("emp_no"), 
					rs.getString("name"),
					rs.getString("tel"),
					rs.getDate("start_date"), 
					rs.getString("emp_degree")));
			
		}
		// list에 추가가된 데이터 출력
		for (employees_info info : list) {
			System.out.println(info);
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
