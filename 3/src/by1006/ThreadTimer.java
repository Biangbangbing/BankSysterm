package by1006;

import java.awt.*;

//计时器线程
public class ThreadTimer extends Thread{
	private int time = 30;  //时间
	private Graphics g;
	
	public ThreadTimer(Graphics g) {
		this.g = g;
	}
	//更新time
	public void setTime(int time) {
		this.time = time;
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			time--;
			//System.out.println("剩余时间："+time);
			g.setColor(Color.WHITE);
			g.fillRect(480,60,80,30);
			g.setColor(Color.BLACK);
			g.drawString(time+" ", 500, 80);
		}
	}
}
