package com.vic.swing.blayout;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * https://blog.csdn.net/xietansheng/article/details/72814541
 * @author Victor
 *
 */
public class FlowLayoutTest {
	
	public static void main(String[] args) {
		
		//窗口图标
		Image image = Toolkit.getDefaultToolkit().getImage("D:\\bill\\swing\\src\\main\\resources\\tray.jpg");
		
		JFrame jf = new JFrame("测试窗口");
		jf.setIconImage(image);
        jf.setSize(200, 250);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        
        //流式布局
        FlowLayout flowLayout = new FlowLayout();
        //每行的对齐方式
        flowLayout.setAlignment(FlowLayout.LEFT);
        
        // 创建内容面板，指定使用 流式布局，默认居中对齐
        JPanel panel = new JPanel(flowLayout);
        
        /**
         * 中间容器内的元素排列方向方式
         * LEFT_TO_RIGHT: 从左往右排列
         * RIGHT_TO_LEFT: 从右往左排列
         */
        panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        JButton btn01 = new JButton("按钮01");
        JButton btn02 = new JButton("按钮02");
        JButton btn03 = new JButton("按钮03");
        JButton btn04 = new JButton("按钮04");
        JButton btn05 = new JButton("按钮05");

        panel.add(btn01);
        panel.add(btn02);
        panel.add(btn03);
        panel.add(btn04);
        panel.add(btn05);

        jf.setContentPane(panel);
        jf.setVisible(true);        // PS: 最后再设置为可显示(绘制), 所有添加的组件才会显示
	}
}
