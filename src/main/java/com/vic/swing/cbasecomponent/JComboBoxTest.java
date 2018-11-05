package com.vic.swing.cbasecomponent;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * https://blog.csdn.net/xietansheng/article/details/74363699
 * @author Victor
 *
 */
public class JComboBoxTest {
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("测试窗口");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        
        // 添加一个标签
        JLabel label = new JLabel("水果：");
        panel.add(label);

        // 需要选择的条目
        String[] listData = new String[]{"香蕉", "雪梨", "苹果", "荔枝"};
        
        // 创建一个下拉列表框
        final JComboBox<String> comboBox = new JComboBox<String>(listData);

        // 添加条目选中状态改变的监听器
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("选中: " + comboBox.getSelectedIndex() + " = " + comboBox.getSelectedItem());
                }
            }
        });
        
        // 设置默认选中的条目
        comboBox.setSelectedIndex(2);
        
        // 添加到内容面板
        panel.add(comboBox);
        
        jf.setContentPane(panel);
        jf.setVisible(true);
	}

}
