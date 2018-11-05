package com.vic.test.b;

import java.applet.Applet;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Test extends Applet implements ActionListener {
	
	JTextField textA, textB, textC;
	JButton b1, b2, b3;

	public void init() {
		setSize(250, 150);
		/* 这里的代码实现设置布局、创建有关的组件、添加组件，为按钮注册监视器等 */
		
		GridLayout layout = new GridLayout(4, 3);
		
		setLayout(layout);
		
		JLabel labela = new JLabel("运算数1");
		JLabel labelb = new JLabel("运算数1");
		JLabel labelc = new JLabel("结果");
		
		textA = new JTextField(6);
		textB = new JTextField(6);
		textC = new JTextField(6);
		
		
		b1 = new JButton("+");
		b2 = new JButton("-");
		b3 = new JButton("*");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		add(labela);
		add(textA);
		add(b1);
		add(labelb);
		add(textB);
		add(b2);
		add(labelc);
		add(textC);
		add(b3);
		
//		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		String text1 = textA.getText();
		String text2 = textB.getText();
		Double value1 = Double.valueOf(text1);
		Double value2 = Double.valueOf(text2);
		if("+".equals(command)) {
			textC.setText(String.valueOf(value1+value2));
		} else if("-".equals(command)) {
			textC.setText(String.valueOf(value1-value2));
		} else if("*".equals(command)) {
			textC.setText(String.valueOf(value1*value2));
		}
	}

}
