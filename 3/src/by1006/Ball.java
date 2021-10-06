package by1006;

import java.awt.*;

//小球类
public class Ball {
	//小球的属性
	public int x,y,vx,vy,size=50;
	
	//初始小球的位置
	public Ball(int x,int y,int vx,int vy) {
		this.x = x;
		this.y = y;
		this.vx=vx;
		this.vy=vy;
	}
	
	//画小球
	public void drawBall(Graphics g) {
		g.fillOval(x-size/2, y-size/2, size, size);
		//move();
	}
	//移动
	public void move() {
		if(y+vy>=575 || y+vy<=125)
			vy=-vy;
		if(x+vx>=575 || x+vx<25)
			vx=-vx;
		x+=vx;
		y+=vy;
//		判断小球当前位置

	}
	
}
