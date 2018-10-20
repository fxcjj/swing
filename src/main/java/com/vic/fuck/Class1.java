package com.vic.fuck;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Class1 extends Applet {
	
	public static void main(String[] args) {
		Class1 clazz = new Class1();
		clazz.init();
	}
	public void init() {
		MyWindow myWndow = new MyWindow();
	}
}

class MyPanel extends JPanel {
	public void print(Graphics g, int x, int y) {
		g.setColor(Color.red);
		g.drawLine(x - 5, y - 5, x + 5, y + 5);
		g.drawLine(x + 5, y - 5, x - 5, y + 5);
	}
}

class MyWindow extends JFrame implements MouseListener {
	final int maxMarks = 20;
	int currentMarks = 0, markCount = 0;
	Point marks[] = new Point[maxMarks];
	MyPanel panel;

	MyWindow() {
		this.setLocation(100, 100);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container con = this.getContentPane();
		panel = new MyPanel();
		con.add(panel);
		addMouseListener(this);
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		
		Graphics2D g2d=( Graphics2D) g;
		   Line2D line=new Line2D.Double(10,20,30,40);
		   g2d.draw(line);
		   
		   
		int i;
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		for (i = 0; i < markCount; i++) {
			panel.print(g, marks[i].x, marks[i].y);
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		marks[currentMarks] = new Point(e.getX(), e.getY());
		if (markCount < maxMarks)
			markCount++;
		currentMarks = (currentMarks + 1) % maxMarks;
		repaint();
	}
}
