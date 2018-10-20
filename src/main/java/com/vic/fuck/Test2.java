package com.vic.fuck;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test2 {
	public static void main(String args[]) {
		new ConnectNet("读取网络文本文件示意程序");
	}
}

class ConnectNet extends JFrame implements ActionListener {
	JTextField text = new JTextField(30);
	JTextArea showArea = new JTextArea();
	JButton b = new JButton("下载");
	JPanel p = new JPanel();

	ConnectNet(String s) {
		super(s);
		Container con = this.getContentPane();
		p.add(text);
		p.add(b);
		JScrollPane jsp = new JScrollPane(showArea);
		b.addActionListener(this);
		con.add(p, "North");
		con.add(jsp, "Center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String urlName = text.getText();
		try {
			URL url = new URL(urlName);// 由网址创建URL对象
			URLConnection tc = url.openConnection();// 获得URLConnection对象
			tc.connect();// 设置网络连接
			InputStreamReader in = new InputStreamReader(tc.getInputStream());
			BufferedReader dis = new BufferedReader(in);
			String inLine;
			while ((inLine = dis.readLine()) != null) {
				showArea.append(inLine + "＼n");
			}
			dis.close();
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
	}
}