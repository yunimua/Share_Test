package baseSettings;

import java.awt.*;

import javax.swing.*;

public class PosFrame extends JFrame {
	
	public void setDefaultOptions() {
		// ������ ������ ����
		setSize(1300,800);
		
		// Dimension : �ڽ� ȭ���� ũ��, ���μ��� ���� �������ִ� Ŭ����
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
		/*
			dim.width/2 : �� ȭ���� ���� ���̸� ������ ������,
			getSize().width/2 : ���� ���� �������� ���� ���̸� ������ ����
			dim.height/2 : �� ȭ���� ���� ���̸� ������ ������,
			getSize().height/2 : ���� ���� �������� ���� ���̸� ������ ����
			���� 2������ setLocation(x��ǥ,y��ǥ)�� ������ ȭ�� �� �߾ӿ� �������� ��µȴ�.
		*/
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
		
		// ������ ������ �ϰ�����(true) ���� (false)
		setResizable(false); 
		
		// ȭ�鿡 �������(true) ����(false)
		setVisible(true); 
	}
}
