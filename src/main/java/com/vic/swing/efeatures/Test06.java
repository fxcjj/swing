package com.vic.swing.efeatures;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * https://blog.csdn.net/xietansheng/article/details/78389278
 * 
 * 系统托盘
 * 
 * @author Victor
 * 
 */
public class Test06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createGUI();
			}
		});
		
	}

	protected static void createGUI() {
		JFrame jf = new JFrame("系统托盘测试");
		jf.setSize(300, 300);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null); //居中
		
		if(SystemTray.isSupported()) {
			SystemTray systemTray = SystemTray.getSystemTray();
			
			Image image = Toolkit.getDefaultToolkit().getImage("D:\\bill\\swing\\src\\main\\resources\\tray.jpg");
			
			PopupMenu popupMenu = new PopupMenu();
			
			MenuItem openMenu = new MenuItem("Open");
			MenuItem exitMenu = new MenuItem("Exit");
			
			openMenu.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//点击打开菜单时显示窗口
					if(!jf.isShowing()) {
						jf.setVisible(true);
					}
				}
				
			});
			
			exitMenu.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//点击退出菜单时退出程序
					System.exit(0);
				}
				
			});
			
			popupMenu.add(openMenu);
			popupMenu.add(exitMenu);
			
			
			
			TrayIcon trayIcon = new TrayIcon(image, "This is a tray icon", popupMenu);
			trayIcon.setImageAutoSize(true);
			
			//托盘图标右键点击
			trayIcon.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("托盘图标被右键点击");
				}
				
			});
			
			//鼠标监听器
			trayIcon.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					switch(e.getButton()) {
						case MouseEvent.BUTTON1: {
							System.out.println("托盘图标被鼠标左键被点击");
							break;
						}
						case MouseEvent.BUTTON2: {
							System.out.println("托盘图标被鼠标中键被点击");
							break;
						}
						case MouseEvent.BUTTON3: {
							System.out.println("托盘图标被鼠标右键被点击");
							break;
						}
						default: {
							break;
						}
					}
					
				}
			});
			
			
			try {
				systemTray.add(trayIcon);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
			
		} else {
			System.out.println("当前系统不支持系统托盘");
		}
		
		jf.setVisible(true);
		
	}

}
