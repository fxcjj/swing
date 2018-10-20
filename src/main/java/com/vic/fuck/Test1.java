package com.vic.fuck;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test1 {

	public static void main(String args[]) {
		JFrame mw = new JFrame("一个示意窗口");
		mw.setSize(400, 250);
		Container con = mw.getContentPane();
		con.setLayout(new BorderLayout());
		MyPanela panel1, panel2;
		panel1 = new MyPanela("按钮1", "标签1");
		panel2 = new MyPanela("按钮2", "标签2");
		JButton button = new JButton("开始按钮");
		con.add(panel1, "North");
		con.add(panel2, "South");
		con.add(button, "Center");
		mw.setVisible(true);
	}

}

class MyPanela extends JPanel {
	JButton button;
	JLabel label;

	MyPanela(String s1, String s2) {
		this.setLayout(new GridLayout(2, 2));
		button = new JButton(s1);
		label = new JLabel(s2, JLabel.CENTER);
		add(button);
		add(label);
		add(new JLabel());
	}
}
