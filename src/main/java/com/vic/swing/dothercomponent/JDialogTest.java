package com.vic.swing.dothercomponent;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class JDialogTest {
	
	public static void main(String[] args) {
//		test1();
		test2();
	}
	
	/**
	 * 自定义对话框的显示（JDialog）
	 */
	public static void test2() {
		final JFrame jf = new JFrame("测试窗口");
        jf.setSize(300, 300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton btn = new JButton("显示自定义对话框");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCustomDialog(jf, jf);
            }
        });

        JPanel panel = new JPanel();
        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);
	}
	
	 /**
     * 显示一个自定义的对话框
     *
     * @param owner 对话框的拥有者
     * @param parentComponent 对话框的父级组件
     */
    private static void showCustomDialog(Frame owner, Component parentComponent) {
        // 创建一个模态对话框
        final JDialog dialog = new JDialog(owner, "提示", true);
        // 设置对话框的宽高
        dialog.setSize(250, 150);
        // 设置对话框大小不可改变
        dialog.setResizable(false);
        // 设置对话框相对显示的位置
        dialog.setLocationRelativeTo(parentComponent);

        // 创建一个标签显示消息内容
        JLabel messageLabel = new JLabel("对话框消息内容");

        // 创建一个按钮用于关闭对话框
        JButton okBtn = new JButton("确定");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 关闭对话框
                dialog.dispose();
            }
        });

        // 创建对话框的内容面板, 在面板内可以根据自己的需要添加任何组件并做任意是布局
        JPanel panel = new JPanel();

        // 添加组件到面板
        panel.add(messageLabel);
        panel.add(okBtn);

        // 设置对话框的内容面板
        dialog.setContentPane(panel);
        // 显示对话框
        dialog.setVisible(true);
    }

	/**
	 * 标准对话框的显示（JOptionPane）
	 */
	public static void test1() {
		final JFrame jf = new JFrame("测试窗口");
        jf.setSize(400, 400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /*
         * 1. 消息对话框（信息消息）
         */
        JButton btn01 = new JButton("showMessageDialog（信息消息）");
        btn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 消息对话框无返回, 仅做通知作用
                JOptionPane.showMessageDialog(
                        jf,
                        "Hello Information Message",
                        "消息标题",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        /*
         * 2. 消息对话框（警告消息）
         */
        JButton btn02 = new JButton("showMessageDialog（警告消息）");
        btn02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 消息对话框无返回, 仅做通知作用
                JOptionPane.showMessageDialog(
                        jf,
                        "Hello Warning Message",
                        "消息标题",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        /*
         * 3. 确认对话框
         */
        JButton btn03 = new JButton("showConfirmDialog");
        btn03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                 * 返回用户点击的选项, 值为下面三者之一:
                 *     是:   JOptionPane.YES_OPTION
                 *     否:   JOptionPane.NO_OPTION
                 *     取消: JOptionPane.CANCEL_OPTION
                 *     关闭: JOptionPane.CLOSED_OPTION
                 */
                int result = JOptionPane.showConfirmDialog(
                        jf,
                        "确认删除？",
                        "提示",
                        JOptionPane.YES_NO_CANCEL_OPTION
                );
                System.out.println("选择结果: " + result);
            }
        });

        /*
         * 4. 输入对话框（文本框输入）
         */
        JButton btn04 = new JButton("showInputDialog（文本框输入）");
        btn04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 显示输入对话框, 返回输入的内容
                String inputContent = JOptionPane.showInputDialog(
                        jf,
                        "输入你的名字:",
                        "默认内容"
                );
                System.out.println("输入的内容: " + inputContent);
            }
        });

        /*
         * 5. 输入对话框（下拉框选择）
         */
        JButton btn05 = new JButton("showInputDialog（下拉框选择）");
        btn05.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] selectionValues = new Object[]{"香蕉", "雪梨", "苹果"};

                // 显示输入对话框, 返回选择的内容, 点击取消或关闭, 则返回null
                Object inputContent = JOptionPane.showInputDialog(
                        jf,
                        "选择一项: ",
                        "标题",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        selectionValues,
                        selectionValues[0]
                );
                System.out.println("输入的内容: " + inputContent);
            }
        });

        /*
         * 6. 选项对话框
         */
        JButton btn06 = new JButton("showOptionDialog");
        btn06.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 选项按钮
                Object[] options = new Object[]{"香蕉", "雪梨", "苹果"};

                // 显示选项对话框, 返回选择的选项索引, 点击关闭按钮返回-1
                int optionSelected = JOptionPane.showOptionDialog(
                        jf,
                        "请点击一个按钮选择一项",
                        "对话框标题",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.ERROR_MESSAGE,
                        null,
                        options,    // 如果传null, 则按钮为 optionType 类型所表示的按钮（也就是确认对话框）
                        options[0]
                );

                if (optionSelected >= 0) {
                    System.out.println("点击的按钮: " + options[optionSelected]);
                }
            }
        });

        // 垂直排列按钮
        Box vBox = Box.createVerticalBox();
        vBox.add(btn01);
        vBox.add(btn02);
        vBox.add(btn03);
        vBox.add(btn04);
        vBox.add(btn05);
        vBox.add(btn06);

        JPanel panel = new JPanel();
        panel.add(vBox);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }
	

}
