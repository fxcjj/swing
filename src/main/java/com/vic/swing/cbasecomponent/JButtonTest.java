package com.vic.swing.cbasecomponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * https://blog.csdn.net/xietansheng/article/details/74363221
 * @author Victor
 *
 */
public class JButtonTest {

	public static void main(String[] args) {
		JFrame jf = new JFrame("测试窗口");
        jf.setSize(200, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // 创建一个按钮
        final JButton btn = new JButton("测试按钮");
        
        btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//获取到的事件源就是按钮本身
				JButton btn = (JButton) e.getSource();
				System.out.println(btn.getText()+", 按钮被点击");
			}
			
		});
        
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}

}
