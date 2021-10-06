package by1006;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//事件处理类
public class ButtonListener implements ActionListener, KeyListener {
	private Graphics g;
	public JFrame jf;
	ThreadUI threadUI;
	//保存小球对象
	private List<Ball>  listBall = new ArrayList<>();
	Boolean flagStop = true;
	public int[] KeyList={0,0};
	//初始化属性
	public ButtonListener(Graphics g, JFrame jf, ThreadUI threadUI) {
		this.g = g;
		this.jf = jf;
		this.threadUI= threadUI;
		//创建线程对象
		//启动线程：每个线程对象只能调用一次
		ThreadBall tb = new ThreadBall(this.g,listBall,this,threadUI);
		tb.start();
		//计时器线程
		ThreadTimer tt = new ThreadTimer(g);
		tt.start();

		//ThreadTimeProduce ttp = new ThreadTimeProduce(listBall);
		//new Thread(ttp).start();
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("开始");

		this.jf.requestFocus();
		String btnStr = e.getActionCommand();
		if("add".equals(btnStr)) {
			int x = 25 + ((int) (Math.random() * 100)) % 600;
			int y = 125 + ((int) (Math.random() * 100)) % 600;
			Random generator = new Random();
			//		int vx = generator.nextInt(3)-1;
			//		int vy = generator.nextInt(3)-1;

			int vx = (int) (Math.random() * 50) - 25;
			int vy = (int) (Math.random() * 50) - 25;
			//创建小球对象
			Ball ball = new Ball(x, y, vx, vy);
			//添加到链表中
			listBall.add(ball);
		}
		else if("stopBegin".equals(btnStr)){
			if(flagStop==true){
				flagStop = false;
			}
			else
				flagStop = true;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println("按下按键"+key);
		if(key == 44 && KeyList[0]==17){
			listBall.get(0).size*=2;
		}
		else if(key == 46 && KeyList[0]==17){
			listBall.get(0).size/=2;
		}
		else if(key == 17){
			KeyList[0]=17;
		}
		else
			KeyList[0]=0;
		switch(key) {
			case 37: {
				listBall.get(0).vx = (-1) * Math.abs(listBall.get(0).vx);
				listBall.get(0).x+=2*listBall.get(0).vx;
				break;
			}
			case 39: {
				listBall.get(0).vx=Math.abs(listBall.get(0).vx);
				listBall.get(0).x+=2*listBall.get(0).vx;
				break;
			}
			case 38: {
				listBall.get(0).vy = Math.abs(listBall.get(0).vy);
				listBall.get(0).y += 2*listBall.get(0).vy;
				break;
			}
			case 40: {
				listBall.get(0).vy = (-1) * Math.abs(listBall.get(0).vy);
				listBall.get(0).y += 2*listBall.get(0).vy;
				break;
			}
			default:  break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
