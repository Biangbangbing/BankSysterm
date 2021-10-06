package by1006;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

//线程类
public class ThreadBall extends Thread{
	private Graphics g;
	private List<Ball>  listBall;
	private ThreadUI threadUI;
	private ButtonListener buttonListener;
	//public Image backgroundImg = new ImageIcon("img/background.jpg").getImage();
	public BufferedImage bf = new BufferedImage(533,380,BufferedImage.TYPE_INT_RGB);
	//初始化属性
	public ThreadBall(Graphics g, List<Ball>  listBall, ButtonListener buttonListener, ThreadUI threadUI) {
		this.g = g;
		this.listBall = listBall;
		this.buttonListener= buttonListener;
		this.threadUI=threadUI;
	}
	
	//重写run方法：启动线程执行的方法
	//run方法执行完，该线程结束(结束的线程不能再次启动)
	public void run() {
		while(true) {
			//延时
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			//画背景效果
//			g.setColor(Color.WHITE);
			//System.out.println(backgroundImg.getGraphics());
//			g.drawImage(threadUI.backgroundImg,0,80,533,380,null);
			bf.getGraphics().drawImage(threadUI.backgroundImg,0,0,533,380,null);
			//g.fillRect(0,100,800,600);
//            g.setColor(Color.BLACK);
			bf.getGraphics().setColor(Color.BLACK);
			
			//画小球
            for(int i=0;i<listBall.size();i++){
//				listBall.get(i).drawBall(g);
				listBall.get(i).drawBall(bf.getGraphics());
			}
			for(int i=0;i<listBall.size();i++){
				if(listBall.get(i).x<=25 || listBall.get(i).x>=575 )
					listBall.get(i).vx=(-listBall.get(i).vx);
				if(listBall.get(i).y<=125 || listBall.get(i).y>=575 )
					listBall.get(i).vy=(-listBall.get(i).vy);
//				if(Math.abs(listBall.get(i).vx)<50)
//					listBall.get(i).vx=listBall.get(i).vx/Math.abs(listBall.get(i).vx)*10;
//				if(Math.abs(listBall.get(i).vy)<50)
//					listBall.get(i).vy=listBall.get(i).vy/Math.abs(listBall.get(i).vy)*10;
				for(int j=0;j<listBall.size() && j!=i;j++){
					if( (listBall.get(i).x-listBall.get(j).x)*(listBall.get(i).x-listBall.get(j).x)+(listBall.get(i).y-listBall.get(j).y)*(listBall.get(i).y-listBall.get(j).y)<= listBall.get(i).size*listBall.get(i).size){
						int tempVx = listBall.get(i).vx;
						int tempVy = listBall.get(i).vy;
						listBall.get(i).vx = listBall.get(j).vx;
						listBall.get(i).vy = listBall.get(j).vy;
						listBall.get(j).vx = tempVx;
						listBall.get(j).vy = tempVy;
					}
				}
				if(buttonListener.flagStop==true){
  					listBall.get(i).move();
				}
			}
			g.drawImage(bf,0,80,533,380,null);

		}
	}



}
