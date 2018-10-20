package com.vic.fuck;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class LoginUI {
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("User login");
		//关闭窗口，程序退出
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//创建内容面板，默认使用流式布局
		JPanel panel = new JPanel();
		
		//something
		
		jf.setContentPane(panel);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
		
	}
	
}
