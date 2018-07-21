/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gobang;

/**
 *
 * @author չ��
 */
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

/*
 ������������࣬����������
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
	// ���¿�ʼ���˳����ͻ���˵���
	public StartChessJFrame() {
		setTitle("������������");// ���ñ���
		setResizable(false);
		chessBoard = new ChessBoard();

		contentPane = getContentPane();//Container 
		contentPane.add(chessBoard);
		chessBoard.setOpaque(true);//����͸����

		// ��������Ӳ˵�
		menuBar = new JMenuBar();// ��ʼ���˵���
		sysMenu = new JMenu("ϵͳ");// ��ʼ���˵�
		musicMenu = new JMenu("����");
		// ��ʼ���˵���
		startMenuItem = new JMenuItem("���¿�ʼ");
		exitMenuItem = new JMenuItem("�˳�");
		backMenuItem = new JMenuItem("����");
		saveItem=new JMenuItem("����");
		readSaveItem= new JMenuItem("��ȡ");
		
		startMusicMenuItem = new JMenuItem("����");
		nextMusicMenuItem = new JMenuItem("��һ��");
		lastMusicMenuItem = new JMenuItem("��һ��");

		// �������˵�����ӵ��˵���
		sysMenu.add(startMenuItem);
		sysMenu.add(exitMenuItem);
		sysMenu.add(backMenuItem);
		sysMenu.add(saveItem);
		sysMenu.add(readSaveItem);
		
		musicMenu.add(startMusicMenuItem);
		musicMenu.add(nextMusicMenuItem);
		musicMenu.add(lastMusicMenuItem);
		
		
		// ��ʼ����ť�¼��������ڲ���
		MyItemListener lis = new MyItemListener();
		// �������˵�ע�ᵽ�¼���������
		this.startMenuItem.addActionListener(lis);
		backMenuItem.addActionListener(lis);
		exitMenuItem.addActionListener(lis);
		startMusicMenuItem.addActionListener(lis);
		nextMusicMenuItem.addActionListener(lis);
		lastMusicMenuItem.addActionListener(lis);
		menuBar.add(sysMenu);// ��ϵͳ�˵���ӵ��˵�����
		menuBar.add(musicMenu);
		setJMenuBar(menuBar);// ��menuBar����Ϊ�˵���

		toolbar = new JPanel();// �������ʵ����
		// ������ť��ʼ��
		startButton = new JButton("���¿�ʼ");
		exitButton = new JButton("�˳�");
		backButton = new JButton("����");
		saveButton = new JButton("����");
		readSaveButton = new JButton("��ȡ");
		
		startMusicButton = new JButton("����");
		nextMusicButton = new JButton("��һ��");
		lastMusicButton = new JButton("��һ��");
		lastMusicButton.setEnabled(false);
		nextMusicButton.setEnabled(false);
		startMusicButton.setEnabled(true);
		// ��������尴ť��FlowLayout����
		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
		// ��������ť��ӵ��������
		toolbar.add(startButton);
		toolbar.add(exitButton);
		toolbar.add(backButton);
		toolbar.add(saveButton);
		toolbar.add(readSaveButton);
		
		toolbar.add(startMusicButton);
		toolbar.add(nextMusicButton);
		toolbar.add(lastMusicButton);
		// ��������ťע������¼�
		startButton.addActionListener(lis);
		exitButton.addActionListener(lis);
		backButton.addActionListener(lis);
		saveButton.addActionListener(lis);
		readSaveButton.addActionListener(lis);
		startMusicButton.addActionListener(lis);
		nextMusicButton.addActionListener(lis);
		lastMusicButton.addActionListener(lis);
		// ��������岼�ֵ����桱�Ϸ���Ҳ�����·�
		add(toolbar, BorderLayout.SOUTH);
		add(chessBoard);// ����������ӵ�������
		// ���ý���ر��¼�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setSize(800,800);
		pack();// ����Ӧ��С

	}

	private class MyItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();// ����¼�Դ
			if (obj == StartChessJFrame.this.startMenuItem || obj == startButton) {
				// ���¿�ʼ
				// JFiveFrame.this�ڲ��������ⲿ��
				System.out.println("���¿�ʼ");
				chessBoard.restartGame();
			}
			if (obj == exitMenuItem || obj == exitButton)
				System.exit(0);
			if (obj == backMenuItem || obj == backButton) {
				System.out.println("����...");
				chessBoard.goback();
			}
			if (obj == startMusicMenuItem || obj == startMusicButton) {
				if (startMusicButton.getText().equals("����") || startMusicMenuItem.getText().equals("����")) {
					new musicPlayer().startMusic();
					nextMusicButton.setEnabled(true);
					lastMusicButton.setEnabled(true);
					startMusicButton.setEnabled(true);
					startMusicButton.setText("ֹͣ");
					startMusicMenuItem.setText("ֹͣ");
				} else if (startMusicButton.getText().equals("ֹͣ") || startMusicMenuItem.getText().equals("ֹͣ")) {
					musicPlayer.stopMusic();
					nextMusicButton.setEnabled(false);
					lastMusicButton.setEnabled(false);
					startMusicButton.setEnabled(true);
					startMusicButton.setText("����");
					startMusicMenuItem.setText("����");
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
		StartChessJFrame f = new StartChessJFrame();// ���������
		f.setVisible(true);// ��ʾ�����

	}
}