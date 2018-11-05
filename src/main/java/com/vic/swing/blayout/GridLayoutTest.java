package com.vic.swing.blayout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * https://blog.csdn.net/xietansheng/article/details/72814548
 * @author Victor
 *
 */
public class GridLayoutTest {
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("测试窗口");
        jf.setSize(200, 250);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        // 创建 3 行 3 列 的网格布局
        GridLayout layout = new GridLayout(3, 2); //列数为2时不起作用,列数通过指定的行数和布局中的组件总数来确定

        // 设置 水平 和 竖直 间隙
//         layout.setHgap(10);
//         layout.setVgap(10);

        JPanel panel = new JPanel(layout);

        JButton btn01 = new JButton("按钮01");
        JButton btn02 = new JButton("按钮02");
        JButton btn03 = new JButton("按钮03");
        JButton btn04 = new JButton("按钮04");
        JButton btn05 = new JButton("按钮05");
        JButton btn06 = new JButton("按钮06");
        JButton btn07 = new JButton("按钮07");
        JButton btn08 = new JButton("按钮08");

        panel.add(btn01);
        panel.add(btn02);
        panel.add(btn03);
        panel.add(btn04);
//        panel.add(new JLabel());
        panel.add(btn05);
        panel.add(btn06);
        panel.add(btn07);
//        panel.add(btn08);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}
	
}
