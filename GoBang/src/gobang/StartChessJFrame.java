/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gobang;

/**
 *
 * @author 展贝
 */
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

/*
 五子棋主框架类，程序启动类
 */
public class StartChessJFrame extends JFrame {
	private ChessBoard chessBoard;
	private JPanel toolbar;
	private JButton startButton, backButton, exitButton, startMusicButton, nextMusicButton, lastMusicButton,saveButton,readSaveButton;

	private JMenuBar menuBar;
	private JMenu sysMenu, musicMenu;
	private JMenuItem startMenuItem, exitMenuItem, backMenuItem, startMusicMenuItem, nextMusicMenuItem,
			lastMusicMenuItem,saveItem,readSaveItem;
	private Container contentPane;
	// 重新开始，退出，和悔棋菜单项
	public StartChessJFrame() {
		setTitle("单机版五子棋");// 设置标题
		setResizable(false);
		chessBoard = new ChessBoard();

		contentPane = getContentPane();//Container 
		contentPane.add(chessBoard);
		chessBoard.setOpaque(true);//设置透明度

		// 创建和添加菜单
		menuBar = new JMenuBar();// 初始化菜单栏
		sysMenu = new JMenu("系统");// 初始化菜单
		musicMenu = new JMenu("音乐");
		// 初始化菜单项
		startMenuItem = new JMenuItem("重新开始");
		exitMenuItem = new JMenuItem("退出");
		backMenuItem = new JMenuItem("悔棋");
		saveItem=new JMenuItem("保存");
		readSaveItem= new JMenuItem("读取");
		
		startMusicMenuItem = new JMenuItem("播放");
		nextMusicMenuItem = new JMenuItem("下一首");
		lastMusicMenuItem = new JMenuItem("上一首");

		// 将三个菜单项添加到菜单上
		sysMenu.add(startMenuItem);
		sysMenu.add(exitMenuItem);
		sysMenu.add(backMenuItem);
		sysMenu.add(saveItem);
		sysMenu.add(readSaveItem);
		
		musicMenu.add(startMusicMenuItem);
		musicMenu.add(nextMusicMenuItem);
		musicMenu.add(lastMusicMenuItem);
		
		
		// 初始化按钮事件监听器内部类
		MyItemListener lis = new MyItemListener();
		// 将三个菜单注册到事件监听器上
		this.startMenuItem.addActionListener(lis);
		backMenuItem.addActionListener(lis);
		exitMenuItem.addActionListener(lis);
		startMusicMenuItem.addActionListener(lis);
		nextMusicMenuItem.addActionListener(lis);
		lastMusicMenuItem.addActionListener(lis);
		menuBar.add(sysMenu);// 将系统菜单添加到菜单栏上
		menuBar.add(musicMenu);
		setJMenuBar(menuBar);// 将menuBar设置为菜单栏

		toolbar = new JPanel();// 工具面板实例化
		// 三个按钮初始化
		startButton = new JButton("重新开始");
		exitButton = new JButton("退出");
		backButton = new JButton("悔棋");
		saveButton = new JButton("保存");
		readSaveButton = new JButton("读取");
		
		startMusicButton = new JButton("播放");
		nextMusicButton = new JButton("下一首");
		lastMusicButton = new JButton("上一首");
		lastMusicButton.setEnabled(false);
		nextMusicButton.setEnabled(false);
		startMusicButton.setEnabled(true);
		// 将工具面板按钮用FlowLayout布局
		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
		// 将三个按钮添加到工具面板
		toolbar.add(startButton);
		toolbar.add(exitButton);
		toolbar.add(backButton);
		toolbar.add(saveButton);
		toolbar.add(readSaveButton);
		
		toolbar.add(startMusicButton);
		toolbar.add(nextMusicButton);
		toolbar.add(lastMusicButton);
		// 将三个按钮注册监听事件
		startButton.addActionListener(lis);
		exitButton.addActionListener(lis);
		backButton.addActionListener(lis);
		saveButton.addActionListener(lis);
		readSaveButton.addActionListener(lis);
		startMusicButton.addActionListener(lis);
		nextMusicButton.addActionListener(lis);
		lastMusicButton.addActionListener(lis);
		// 将工具面板布局到界面”南方“也就是下方
		add(toolbar, BorderLayout.SOUTH);
		add(chessBoard);// 将面板对象添加到窗体上
		// 设置界面关闭事件
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setSize(800,800);
		pack();// 自适应大小

	}

	private class MyItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();// 获得事件源
			if (obj == StartChessJFrame.this.startMenuItem || obj == startButton) {
				// 重新开始
				// JFiveFrame.this内部类引用外部类
				System.out.println("重新开始");
				chessBoard.restartGame();
			}
			if (obj == exitMenuItem || obj == exitButton)
				System.exit(0);
			if (obj == backMenuItem || obj == backButton) {
				System.out.println("悔棋...");
				chessBoard.goback();
			}
			if (obj == startMusicMenuItem || obj == startMusicButton) {
				if (startMusicButton.getText().equals("播放") || startMusicMenuItem.getText().equals("播放")) {
					new musicPlayer().startMusic();
					nextMusicButton.setEnabled(true);
					lastMusicButton.setEnabled(true);
					startMusicButton.setEnabled(true);
					startMusicButton.setText("停止");
					startMusicMenuItem.setText("停止");
				} else if (startMusicButton.getText().equals("停止") || startMusicMenuItem.getText().equals("停止")) {
					musicPlayer.stopMusic();
					nextMusicButton.setEnabled(false);
					lastMusicButton.setEnabled(false);
					startMusicButton.setEnabled(true);
					startMusicButton.setText("播放");
					startMusicMenuItem.setText("播放");
				}

			}
			if (obj == nextMusicMenuItem || obj == nextMusicButton) {
				new musicPlayer().next();
				nextMusicButton.setEnabled(true);
				lastMusicButton.setEnabled(true);
				startMusicButton.setEnabled(true);
			}
			if (obj == lastMusicMenuItem || obj == lastMusicButton) {
				new musicPlayer().last();
				nextMusicButton.setEnabled(true);
				lastMusicButton.setEnabled(true);
				startMusicButton.setEnabled(true);
			}
			if (obj == saveItem || obj == saveButton) {
				chessBoard.saveChess();
			}
			if (obj == readSaveItem || obj == readSaveButton) {
				chessBoard.getSaveChess();
				contentPane.repaint();
				contentPane.revalidate();
			}
		}
	}

	public static void main(String[] args) {
		StartChessJFrame f = new StartChessJFrame();// 创建主框架
		f.setVisible(true);// 显示主框架

	}
}