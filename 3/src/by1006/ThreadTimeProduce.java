package by1006;

import java.util.List;
import java.util.Random;

public class ThreadTimeProduce implements Runnable{
    public int time = 1000;

    private List<Ball> listBall;
    public ThreadTimeProduce(List<Ball> listBall){
        this.listBall = listBall;
    }
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我调用了画球");
            int x = 25 + ((int) (Math.random() * 1000)) % 600;
            int y = 125 + ((int) (Math.random() * 1000)) % 600;
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
    }
}
