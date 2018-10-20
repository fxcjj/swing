package com.vic.swing.cbasecomponent;

import java.util.Hashtable;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderTest {

	public static void main(String[] args) {
//		test1();
		
		test2();
	}
	
	/**
	 * 自定义标签刻度值
	 */
	private static void test2() {
		JFrame jf = new JFrame("测试窗口");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // 创建一个滑块，最小值、最大值、初始值 分别为 0、20、10
        final JSlider slider = new JSlider(0, 20, 10);

        // 设置主刻度间隔
        slider.setMajorTickSpacing(5);

        // 设置次刻度间隔
        slider.setMinorTickSpacing(1);

        // 绘制 刻度 和 标签
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        /*
         * 设置滑块方向为垂直方向
         */
        slider.setOrientation(SwingConstants.VERTICAL);

        /*
         * 给指定的刻度值显示自定义标签
         */
        Hashtable<Integer, JComponent> hashtable = new Hashtable<Integer, JComponent>();
        hashtable.put(0, new JLabel("Start"));      //  0  刻度位置，显示 "Start"
        hashtable.put(10, new JLabel("Middle"));    //  10 刻度位置，显示 "Middle"
        hashtable.put(20, new JLabel("End"));       //  20 刻度位置，显示 "End"

        /*
         * 将刻度值和自定义标签的对应关系设置到滑块（设置后不再显示默认的刻度值）
         */
        slider.setLabelTable(hashtable);

        // 添加刻度改变监听器
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("当前值: " + slider.getValue());
            }
        });

        // 添加滑块到内容面板
        panel.add(slider);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}

	private static void test1() {
		JFrame jf = new JFrame("测试窗口");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // 创建一个滑块，最小值、最大值、初始值 分别为 0、20、10
        final JSlider slider = new JSlider(0, 20, 10);

        // 设置主刻度间隔
        slider.setMajorTickSpacing(5);
        
        // 设置次刻度间隔
        slider.setMinorTickSpacing(1);
        
        // 绘制 刻度 和 标签
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // 添加刻度改变监听器
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("当前值: " + slider.getValue());
            }
        });

        // 添加滑块到内容面板
        panel.add(slider);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}

}
