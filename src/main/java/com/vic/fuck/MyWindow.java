package com.vic.fuck;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyWindow extends JFrame implements ItemListener {
	
	public static void main(String[] args) {
		new MyWindow("ssssssss");
	}
	
	JTextField text;
	JCheckBox box1, box2;

	MyWindow(String s) {
		super(s);
		Container con = this.getContentPane();
		this.setLocation(100, 100);
		this.setSize(400, 200);
		text = new JTextField(10);
		box1 = new JCheckBox("A计算机", false);
		box2 = new JCheckBox("B计算机", false);
		con.setLayout(new GridLayout(3, 2));
		con.add(new JLabel("计算机产品介绍", JLabel.CENTER));
		add(new JLabel("计算机2选1", JLabel.CENTER));
		con.add(box1);
		con.add(box2);
		con.add(text);
		box1.addItemListener(this);
		box2.addItemListener(this);
		this.setVisible(true);
		this.pack();
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getItemSelectable() == box1) {
			text.setText("A公司生产");
		} else if (e.getItemSelectable() == box2) {
			text.setText("B公司生产");
		}
	}
}