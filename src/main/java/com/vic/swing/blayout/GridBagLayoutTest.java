package com.vic.swing.blayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * https://blog.csdn.net/xietansheng/article/details/72814552
 * @author Victor
 *
 */
public class GridBagLayoutTest {

	public static void main(String[] args) {
		
//		test1();
		
		test2();
        
	}
	
	/**
	 * 未做详细测试
	 */
	private static void test2() {
		JFrame jf = new JFrame("测试窗口2");
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setSize(250, 250); //窗口大小
		
		//布局管理器
		GridBagLayout gridBag = new GridBagLayout();
		//约束
		GridBagConstraints c = null;
		
		JPanel panel = new JPanel(gridBag);
		
		JButton btn01 = new JButton("Button01");
        
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.NORTH;
        gridBag.addLayoutComponent(btn01, c);
        
        //添加组件到内容面板
        panel.add(btn01);
        
        jf.setContentPane(panel);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
	}

	private static void test1() {
		JFrame jf = new JFrame("测试窗口");
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//布局管理器
		GridBagLayout gridBag = new GridBagLayout();
		//约束
		GridBagConstraints c = null;
		
		JPanel panel = new JPanel(gridBag);
		
		JButton btn01 = new JButton("Button01");
        JButton btn02 = new JButton("Button02");
        JButton btn03 = new JButton("Button03");
        JButton btn04 = new JButton("Button04");
        JButton btn05 = new JButton("Button05");
        JButton btn06 = new JButton("Button06");
        JButton btn07 = new JButton("Button07");
        JButton btn08 = new JButton("Button08");
        JButton btn09 = new JButton("Button09");
        JButton btn10 = new JButton("Button10");
		
		//添加组件  和 约束 到布局管理器
        //button01
        c = new GridBagConstraints();
        //内部使用的仅是 c 的副本
        gridBag.addLayoutComponent(btn01, c);
        
        //button02
		c = new GridBagConstraints();
		gridBag.addLayoutComponent(btn02, c);
		
		// Button03
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn03, c);
        
        //button04 显示区域占满当前行剩余空间（换行），组件填充显示区域
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn04, c);
        
        //botton05显示区域独占一行（换行），组件填充显示 区域 
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn05, c);
        
        //botton06 显示区域占到当前尾倒数第二个单元格（下一个组件后需要手动换行），组件填充区域
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn05, c);
        
        //button07放置在当前行最后一个单元格（换行）
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.addLayoutComponent(btn07, c);
        
        //button08 显示区域占两列，组件填充显示区域
        c = new GridBagConstraints();
        c.gridheight = 2;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn08, c);
        
        //button09 显示区域占满当前行剩余空间（换行），组件填充显示区域
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn09, c);
        
        //button10 显示区域占满 当前行剩余空间（换行），组件填充显示区域
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn10, c);
        
        //添加组件到内容面板
        panel.add(btn01);
        panel.add(btn02);
        panel.add(btn03);
        panel.add(btn04);
        panel.add(btn05);
        panel.add(btn06);
        panel.add(btn07);
        panel.add(btn08);
        panel.add(btn09);
        panel.add(btn10);
        
        jf.setContentPane(panel);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
	}

}
