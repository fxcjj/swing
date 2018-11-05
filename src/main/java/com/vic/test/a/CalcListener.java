package com.vic.test.a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * 监听器
 * @author Victor
 *
 */
public class CalcListener implements ActionListener {
		
	StringBuffer sb = new StringBuffer();
	JTextField jtf;
	String text;
	
	public CalcListener(JTextField jtf) {
		this.jtf = jtf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch(command) {
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
		case ".":
		case "+":
		case "-":
		case "*":
		case "/":
		case "%":
			sb.append(command);
			jtf.setText(sb.toString().trim());
			break;
			
		//清空输入框内容
		case "C":
		case "CE":
			sb.setLength(0);
			jtf.setText("0");
			break;
			
		//退格
		case "←":
			text = jtf.getText();
			if("0".equals(text)) {
				break;
			} else {
				if(text.length() != 0) {
					jtf.setText(text.substring(0, text.length() - 1));
					if(text.length() == 1) {
						jtf.setText("0");
					}
				} else {
					jtf.setText("0");
				}
			}
			break;
			
		//四则运算符处理
		case "=":
			text = jtf.getText();
			if(text.contains("+")) {
				String[] str = text.split("\\+");
				String first = str[0];
				String next = str[1];
				double result = Double.valueOf(first) + Double.valueOf(next);
				jtf.setText(String.valueOf(result));
			} else if(text.contains("-")) {
				String[] str = text.split("-");
				String first = str[0];
				String next = str[1];
				double result = Double.valueOf(first) - Double.valueOf(next);
				jtf.setText(String.valueOf(result));
			} else if(text.contains("*")) {
				String[] str = text.split("\\*");
				String first = str[0];
				String next = str[1];
				double result = Double.valueOf(first) * Double.valueOf(next);
				jtf.setText(String.valueOf(result));
			} else if(text.contains("/")) {
				String[] str = text.split("\\/");
				String first = str[0];
				String next = str[1];
				double result = Double.valueOf(first) / Double.valueOf(next);
				jtf.setText(String.valueOf(result));
			} else if(text.contains("%")) {
				String[] str = text.split("\\%");
				String first = str[0];
				String next = str[1];
				double result = Double.valueOf(first) % Double.valueOf(next);
				jtf.setText(String.valueOf(result));
			}
			break;
		}
		
		
	}
	
}