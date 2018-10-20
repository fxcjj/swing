package com.vic.swing.efeatures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * https://blog.csdn.net/xietansheng/article/details/78389255
 * @author Victor
 *
 */
public class Test03 {
	static final String COMMAND_OK = "Ok";
	static final String COMMAND_CANCEL = "Cancel";
	
	public static void main(String[] args) {
		
//		test1();
		
//		test2();
		
//		test3();
		
//		test4();
		
//		test5();
		
//		test6();
		
//		test7();
		
		
	}
	
	/**
	 * （7）窗口监听器 — WindowListener
	 * 窗口监听器只有窗口类组件支持，例如 JFrame、JDialog。
	 */
	private static void test7() {
		JFrame jf = new JFrame();

		jf.addWindowListener(new WindowListener() {
		    @Override
		    public void windowOpened(WindowEvent e) {
		        System.out.println("windowOpened: 窗口首次变为可见时调用");
		    }

		    @Override
		    public void windowClosing(WindowEvent e) {
		        System.out.println("windowClosing: 用户试图从窗口的系统菜单中关闭窗口时调用");
		    }

		    @Override
		    public void windowClosed(WindowEvent e) {
		        System.out.println("windowClosed: 窗口调用 dispose 而将其关闭时调用");
		    }

		    @Override
		    public void windowIconified(WindowEvent e) {
		        System.out.println("windowIconified: 窗口从正常状态变为最小化状态时调用");
		    }

		    @Override
		    public void windowDeiconified(WindowEvent e) {
		        System.out.println("windowDeiconified: 窗口从最小化状态变为正常状态时调用");
		    }

		    @Override
		    public void windowActivated(WindowEvent e) {
		        System.out.println("windowActivated: 窗口变为活动状态时调用");
		    }

		    @Override
		    public void windowDeactivated(WindowEvent e) {
		        System.out.println("windowDeactivated: 窗口变为不再是活动状态时调用");
		    }
		});

		// 窗口焦点监听器
		jf.addWindowFocusListener(new WindowFocusListener() {
		    @Override
		    public void windowGainedFocus(WindowEvent e) {
		        System.out.println("windowGainedFocus: 窗口得到焦点");
		    }

		    @Override
		    public void windowLostFocus(WindowEvent e) {
		        System.out.println("windowLostFocus: 窗口失去焦点");
		    }
		});

		// 窗口状态监听器
		jf.addWindowStateListener(new WindowStateListener() {
		    @Override
		    public void windowStateChanged(WindowEvent e) {
		        System.out.println("windowStateChanged: " + e.getNewState());
		    }
		});
	}


	/**
	 * （6）键盘监听器 — KeyListener
	 */
	private static void test6() {
		JFrame jf = new JFrame();

		jf.addKeyListener(new KeyListener() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        // 获取键值，和 KeyEvent.VK_XXXX 常量比较确定所按下的按键
		        int keyCode = e.getKeyCode();
		        System.out.println("按下: " + e.getKeyCode());
		    }

		    @Override
		    public void keyTyped(KeyEvent e) {
		        // e.getKeyChar() 获取键入的字符
		        System.out.println("键入: " + e.getKeyChar());
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		        System.out.println("释放: " + e.getKeyCode());
		    }
		});
	}



	/**
	 * （5）鼠标滚轮监听器 — MouseWheelListener
	 */
	private static void test5() {
		JPanel panel = new JPanel();

		panel.addMouseWheelListener(new MouseWheelListener() {
		    @Override
		    public void mouseWheelMoved(MouseWheelEvent e) {
		        // e.getWheelRotation() 为滚轮滚动多少的度量
		        System.out.println("mouseWheelMoved: " + e.getWheelRotation());
		    }
		});
	}

	/**
	 * （4）鼠标移动/拖动监听器 — MouseMotionListener
	 */
	private static void test4() {
		JPanel panel = new JPanel();

		panel.addMouseMotionListener(new MouseMotionListener() {
		    @Override
		    public void mouseDragged(MouseEvent e) {
		        // 鼠标保持按下状态移动即为拖动
		        System.out.println("鼠标拖动");
		    }
		    @Override
		    public void mouseMoved(MouseEvent e) {
		        System.out.println("鼠标移动");
		    }
		});
	}

	/**
	 * （3）鼠标监听器 — MouseListener
	 */
	private static void test3() {
		JPanel panel = new JPanel();

		panel.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        System.out.println("鼠标进入组件区域");
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        System.out.println("鼠标离开组建区域");
		    }

		    @Override
		    public void mousePressed(MouseEvent e) {
		        // 获取按下的坐标（相对于组件）
		        e.getPoint();
		        e.getX();
		        e.getY();

		        // 获取按下的坐标（相对于屏幕）
		        e.getLocationOnScreen();
		        e.getXOnScreen();
		        e.getYOnScreen();

		        // 判断按下的是否是鼠标右键
		        e.isMetaDown();

		        System.out.println("鼠标按下");
		    }

		    @Override
		    public void mouseReleased(MouseEvent e) {
		        System.out.println("鼠标释放");
		    }

		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // 鼠标在组件区域内按下并释放（中间没有移动光标）才识别为被点击
		        System.out.println("鼠标点击");
		    }
		});
	}


	/**
	 * （2）焦点监听器 — FocusListener
	 */
	private static void test2() {
		JButton btn = new JButton("OK");
		btn.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        System.out.println("获得焦点: " + e.getSource());
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        System.out.println("失去焦点: " + e.getSource());
		    }
		});

		JTextField textField = new JTextField(10);
		textField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        System.out.println("获得焦点: " + e.getSource());
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        System.out.println("失去焦点: " + e.getSource());
		    }
		});
	}



	/**
	 * （1）动作监听器 — ActionListener
	 */
	private static void test1() {
		JFrame jf = new JFrame("动作监听器");
		jf.setSize(300, 300);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获得事件源
//				e.getSource();
				String actionCommand = e.getActionCommand();
				if(COMMAND_OK.equals(actionCommand)) {
					System.out.println("OK 按钮被点击");
				} else if(COMMAND_CANCEL.equals(actionCommand)) {
					System.out.println("Cancel 按钮被点击");
				}
				
			}
		};
		
		JButton okBtn = new JButton("Ok");
		// 按钮绑定动作命令
		okBtn.setActionCommand(COMMAND_OK);
		
		JButton cancelBtn = new JButton("Cancel");
		// 按钮绑定动作命令
		cancelBtn.setActionCommand(COMMAND_CANCEL);
		
		
		// 设置两个按钮的动作监听器（使用同一个监听器实例）
		okBtn.addActionListener(listener);
		cancelBtn.addActionListener(listener);
		
		panel.add(okBtn);
		panel.add(cancelBtn);
		
		jf.setContentPane(panel);
		jf.setVisible(true);
		
	}

}
