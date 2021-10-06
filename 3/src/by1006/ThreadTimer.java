package by1006;

import java.awt.*;

//��ʱ���߳�
public class ThreadTimer extends Thread{
	private int time = 30;  //ʱ��
	private Graphics g;
	
	public ThreadTimer(Graphics g) {
		this.g = g;
	}
	//����time
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
			//System.out.println("ʣ��ʱ�䣺"+time);
			g.setColor(Color.WHITE);
			g.fillRect(480,60,80,30);
			g.setColor(Color.BLACK);
			g.drawString(time+" ", 500, 80);
		}
	}
}
