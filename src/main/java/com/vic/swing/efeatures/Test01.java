package com.vic.swing.efeatures;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Test01 {

	public static void main(String[] args) {
//		test1();
		
//		test2();
		
//		test3();
		
//		test4();
		
//		test5();
		
		test5();
		
//		test6();
	}
	
	private static void test6() {
		JFrame jf = new JFrame("测试窗口");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*
         * 布局绘制并显示，组件的坐标和宽高在这里确定，并设置回组件，在这句代码之后才能获取到组件的坐标和宽高
         */
        jf.setVisible(true);
        
	}
	
	/**
	 * 2. 组件位置和尺寸的获取
	 */
	private static void test5() {
		JFrame jf = new JFrame("测试窗口");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 创建内容面板，使用浮动布局
        JPanel panel = new JPanel(new FlowLayout());

        // 创建标签组件
        JLabel label = new JLabel("一个标签");

        // 添加标签到内容面板
        panel.add(label);

        jf.setContentPane(panel);

        /*
         * 布局绘制并显示，组件的坐标和宽高在这里确定，并设置回组件，在这句代码之后才能获取到组件的坐标和宽高
         */
        jf.setVisible(true);

        // 获取标签的坐标（相对于父容器）
        Point labelLocation = label.getLocation();
        // 获取标签的坐标（相对于屏幕左上角）
        Point labelLocationOnScreen = label.getLocationOnScreen();
        // 获取标签的宽高
        Dimension labelSize = label.getSize();

        System.out.println("标签: Location = " + labelLocation
                + ", LocationOnScreen = " + labelLocationOnScreen
                + ", Size = " + labelSize);

        /*
         * 对于 JFrame（窗口）的 坐标 和 宽高 获取
         */
        // 获取窗口的坐标（相对于父容器，对于窗口而言，父容器就是屏幕，所以此坐标实际上就是相对于屏幕左上角的坐标）
        Point jfLocation = jf.getLocation();
        // 获取窗口的坐标（相对于屏幕左上角）
        Point jfLocationOnScreen = jf.getLocationOnScreen();
        // 获取窗口的宽高（包含标题栏）
        Dimension jfSize = jf.getSize();

        System.out.println("窗口: Location = " + jfLocation
                + ", LocationOnScreen = " + jfLocationOnScreen
                + ", Size = " + jfSize);
	}



	/**
	 * 窗口（JFrame）的坐标设置
	 */
	private static void test4() {
		JFrame jf = new JFrame("测试窗口");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 设置窗口的宽高（包括标题栏）
        jf.setSize(250, 250);

        // 设置窗口坐标（相对于父容器，对于窗口而言，父容器就是屏幕左上角）
        jf.setLocation(0, 0);

        // 设置窗口坐标，此方法是间接设置窗口坐标，把窗口设置到指定组件的中心，null 表示屏幕
        jf.setLocationRelativeTo(null);

        // 如果需要把窗口设置到屏幕左边或右边，可以通过下面方法获取屏幕的宽高
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JPanel panel = new JPanel();
        
        jf.setContentPane(panel);

        // 包裹内容，此方法会根据内容重新计算窗口的宽高（之前设置的宽高将无效），
        // 此方法会改变窗口宽高，坐标却不会改变，如果需要将窗口设置到屏幕中心，
        // 需要重新调用 jf.setLocationRelativeTo(null) 方法计算窗口的坐标。
        jf.pack();

        jf.setVisible(true);
	}
	
	/**
	 * 窗口（JFrame）和 内容面板 的宽高设置
	 */
	private static void test3() {
		JFrame jf = new JFrame("测试窗口");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // 设置内容面板的首选尺寸
        panel.setPreferredSize(new Dimension(300, 300));

        // 设置内容面板到窗口
        jf.setContentPane(panel);

        // 包裹内容
        jf.pack();

        // 必须在尺寸确定后（pack之后），再设置窗口位置
        jf.setLocationRelativeTo(null);

        /* 如此设置，在任何操作系统上，内容面板的尺寸都固定为 300*300，并且在屏幕居中显示*/

        jf.setVisible(true);
	}

	/**
	 * 绝对布局
	 */
	private static void test2() {
		JFrame jf = new JFrame("测试窗口");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);

        // 创建一个标签，设置其背景为灰色（方便查看组件边界）
        JLabel label = new JLabel("一个标签");
        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);

        // 设置标签的坐标和宽高
        label.setLocation(50, 50);  // 坐标指的是相对于父容器左上角的坐标
        label.setSize(100, 50);     // 绝对布局的宽高设置，使用 setSize(...)

        // 也可以使用下面一句代码一次性设置坐标和宽高
        // label.setBounds(50, 50, 100, 50);

        panel.add(label);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}
	
	
	/**
	 * 1. 组件的位置和尺寸的设置
	 */
	private static void test1() {
		JFrame jf = new JFrame("测试窗口");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 创建内容面板，使用浮动布局
        JPanel panel = new JPanel(new FlowLayout());

        // 创建一个标签，设置其背景为灰色（方便查看组件边界）
        JLabel label = new JLabel("一个标签");
        label.setOpaque(true); //不透明
        label.setBackground(Color.LIGHT_GRAY); //背景颜色

        /*
         * 设置标签的宽高，对于浮动布局，这里需要使用 首选尺寸，设置其他尺寸无效
         */
        label.setPreferredSize(new Dimension(100, 100));

        // 里设置坐标将无效，因为对于浮动布局设置其子组件的坐标无意义，坐标将在绘制显示后自动确定
        // label.setLocation(...);

        panel.add(label);

        jf.setContentPane(panel);

        // 绘制组件显示
        jf.setVisible(true);

        /* 到了这里，组件已绘制显示完成，坐标和尺寸才真正确定 */
	}

}
