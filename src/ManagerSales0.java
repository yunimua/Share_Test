import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import baseSettings.*;
import net.sourceforge.jdatepicker.impl.*;

public class ManagerSales0 extends PosFrame {
	
	private JSplitPane jsp = new JSplitPane();
	private JScrollPane scrollpane;

	public ManagerSales0() {
		super();
		
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
		TotalLabel tl = new TotalLabel();
		for (JLabel labels : tl.getLabels()) {
			add(labels);
		}
	}

	
	public static void main(String[] args) {
		ManagerSales0 frame = new ManagerSales0();
		frame.setDefaultOptions();
	}
}
