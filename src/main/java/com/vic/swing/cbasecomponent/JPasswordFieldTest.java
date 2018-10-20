package com.vic.swing.cbasecomponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;

/**
 * https://blog.csdn.net/xietansheng/article/details/74363621
 * @author Victor
 *
 */
public class JPasswordFieldTest {

	public static void main(String[] args) {
		JFrame jf = new JFrame("测试窗口");
        jf.setSize(300, 300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // 创建密码框，指定可见列数为10列
        final JPasswordField passwordField = new JPasswordField(10);
        panel.add(passwordField);

        // 创建一个按钮，点击后获取密码框中输入的密码
        JButton btn = new JButton("提交");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("提交密码为: " + new String(passwordField.getPassword()));
            }
        });
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}

}
