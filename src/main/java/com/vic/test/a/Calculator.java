package com.vic.test.a;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 计算器
 * @author Victor
 *
 */
public class Calculator extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private Graphics2D g;
	
	/** 数字按钮、运算按钮 */
	String[] BUTTON_VALUE = {"1","2","3","C",
			"4","5","6","CE",
			"7","8","9","←",
			"+","-","0",".",
			"*","/","%","="};
	
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.initFrame();
	}

	private void initFrame() {
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		this.setTitle("calc"); //标题
		this.setSize(300, 400); //大小
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口时程序退出
		this.setLocationRelativeTo(null); //居中
		this.setLayout(null);
		
		//文本输入框
		JTextField jtf = topSurface();
		//数字和按钮
		this.bottomSurface(jtf);
		
		this.setVisible(true);
	}
	
	/**
	 * 下部分
	 * @param jtf
	 */
	private void bottomSurface(JTextField jtf) {
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(8, 80, 270, 250);
		bottomPanel.setLayout(new GridLayout(5, 4, 1, 1)); //5行4列，水平间隙1，垂直间隙1
		
		CalcListener listener = new CalcListener(jtf);
		for(int i = 0; i < BUTTON_VALUE.length; i++) {
			JButton btn = new JButton(BUTTON_VALUE[i]); //text
			btn.setBorder(BorderFactory.createRaisedBevelBorder());
			btn.setForeground(Color.blue);
			btn.setFont(new Font("宋体", 0, 25));
			bottomPanel.add(btn);
			btn.addActionListener(listener); //每一个按钮都加监听器
		}
		
		this.add(bottomPanel); //添加数字和按钮
	}

	/**
	 * 上部分
	 * @return
	 */
	private JTextField topSurface() {
		JPanel topPanel = new JPanel();
		topPanel.setBounds(-5, 10, 300, 50);
		
		JTextField jtf = new JTextField(16);
		jtf.setHorizontalAlignment(JTextField.RIGHT);
		jtf.setText("0"); //默认
		jtf.setFont(new Font("SansSerif", Font.PLAIN, 20)); //字体
		jtf.setForeground(Color.red); //前景颜色
		jtf.setEditable(true); //可编辑
		
		topPanel.add(jtf);
		this.add(topPanel); //添加 文本输入框 到frame
		return jtf;
	}
	
	// 定义自己的画笔，把paint方法的Graphics对象强转为自定义画笔
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.g = (Graphics2D) g;
		this.g.setStroke(new BasicStroke(3));
		this.g.setColor(new Color(18,18,9));
		this.g.drawLine(0, 95, this.getWidth(), 95);
	}
	
}
