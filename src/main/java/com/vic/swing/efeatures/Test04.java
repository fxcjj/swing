package com.vic.swing.efeatures;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

/**
 * https://blog.csdn.net/xietansheng/article/details/78389265
 * @author Victor
 *
 */
public class Test04 {
	public static void main(String[] args) {
        
//		test1();
        
//        test2();
		
		test3();
    }
	
	/**
	 * SwingWorker 线程间通信的应用
	 */
	private static void test3() {
		SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        createGUI3();
                    }
                }
        );
	}
	
	public static void createGUI3() {
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(300, 300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        final JLabel label = new JLabel("正在下载: 0%");
        panel.add(label, BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea();
        panel.add(textArea, BorderLayout.CENTER);

        jf.setContentPane(panel);
        jf.setVisible(true);

        // 创建后台任务
        SwingWorker<String, Integer> task = new SwingWorker<String, Integer>() {
            @Override
            protected String doInBackground() throws Exception {
                for (int i = 0; i < 100; i += 10) {
                    // 延时模拟耗时操作
                    Thread.sleep(1000);

                    // 设置 progress 属性的值（通过属性改变监听器传递数据到事件调度线程）
                    setProgress(i);

                    // 通过 SwingWorker 内部机制传递数据到事件调度线程
                    publish(i);
                }
                // 返回计算结果
                return "下载完成";
            }

            @Override
            protected void process(List<Integer> chunks) {
                // 此方法在 调用 doInBackground 调用 public 方法后在事件调度线程中被回调
                Integer progressValue = chunks.get(0);
                textArea.append("已下载: " + progressValue + "%\n");
            }

            @Override
            protected void done() {
                // 此方法将在后台任务完成后在事件调度线程中被回调
                String result = null;
                try {
                    // 获取计算结果
                    result = get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                label.setText(result);
                textArea.append(result);
            }
        };

        // 添加属性改变监听器
        task.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("progress".equals(evt.getPropertyName())) {
                    Object progressValue = evt.getNewValue();
                    label.setText("正在下载: " + progressValue + "%");
                }
            }
        });

        // 启动任务
        task.execute();
    }

	/**
	 * SwingWorker 的简单应用
	 */
	private static void test2() {
		SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        createGUI2();
                    }
                }
        );
	}
	
	public static void createGUI2() {
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(300, 300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        final JLabel label = new JLabel();
        label.setText("正在计算");
        panel.add(label);

        jf.setContentPane(panel);
        jf.setVisible(true);

        // 创建后台任务
        SwingWorker<String, Object> task = new SwingWorker<String, Object>() {
            @Override
            protected String doInBackground() throws Exception {
                // 此处处于 SwingWorker 线程池中
                // 延时 5 秒，模拟耗时操作
                Thread.sleep(5000);
                // 返回计算结果
                return "Hello";
            }
            
            @Override
            protected void done() {
                // 此方法将在后台任务完成后在 事件调度线程 中被回调
                String result = null;
                try {
                    // 获取计算结果
                    result = get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                label.setText("结算结果: " + result);
            }
        };

        // 启动任务
        task.execute();
    }


	/**
	 * 事件调度线程（Event Dispatching Thread）
	 */
	private static void test1() {
		// 此处处于 主线程，提交任务到 事件调度线程 创建窗口
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        // 此处处于 事件调度线程
                        createGUI();
                    }
                }
        );
	}

    public static void createGUI() {
        // 此处处于 事件调度线程
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(300, 300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JButton btn = new JButton("Btn");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 此处处于 事件调度线程（所有监听器的回调都在 事件调度线程 中回调）
            }
        });
        
        panel.add(btn);
        
        jf.setContentPane(panel);
        jf.setVisible(true);
    }
}
