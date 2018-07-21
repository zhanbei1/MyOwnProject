package gobang;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class musicPlayer implements Runnable {
	// 不可以extends Thread。再重复使用thread。start会报java.lang.illegalthreadstateexception错误
	private static int num = 1;
	private final String firstMusic = "music/1.mp3";

	static musicPlayer mp3;
	private static String filename;
	private static Player player;
	private static Thread thread;
	private static volatile boolean flag = false;

	public musicPlayer() {// 初始化创建播放音乐线程
		filename = firstMusic;
		thread = new Thread(this);
		mp3 = this;
	}

	public static void play() {// 加载音乐文件
		try {
			// thread.sleep(100);
			BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
			player = new Player(buffer);
			player.play();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void run() {
		while (!flag) {
			play();
		}
	}

	public static void startMusic() {
		flag = false;
		thread.start();
	}

	public static void stopMusic() {
		player.close();
		flag = true;
		thread.run();
		System.out.println(thread.isInterrupted());
	}

	public static void loop() {
		if (player.isComplete()) {
			next();
		}
	}

	public static void next() {
		stopMusic();

		num = num + 1;
		String str = "music/" + num + ".mp3";
		filename = str;
		// player.close();
		// mp3=new musicPlayer();
		startMusic();
		// thread=null;
	}

	public static void last() {
		if (num == 1) {
			return;
		}
		if (num == 6) {
			num = 1;
		}
		if (num > 1 && num < 6) {
			stopMusic();
			num = num - 1;
			String str = "music/" + num + ".mp3";
			filename = str;
			// player.close();
			// thread=null;
			// flag = false;
			startMusic();
		}
	}
}
