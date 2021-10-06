package by1006;

import javax.swing.*;
import java.awt.*;

/**
 * 练习：1.设计小球类，完成对小球的控制
 *     2.相互碰撞
 *     3.线程(暂停/恢复)
 * @author chen
 *
 */
public class ThreadUI {
	public static final Image backgroundImg = new ImageIcon("img/bg.jpg").getImage();
	public static void main(String[] args) {
		ThreadUI ui = new ThreadUI();
		ui.showUI();
	}

	public void showUI() {
		JFrame jf = new JFrame();
		jf.setSize(533, 380);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
		jf.setLayout(new FlowLayout());
		
		JButton jbu = new JButton("add");
		jf.add(jbu);

		JButton jbuStop = new JButton("stopBegin");
		jf.add(jbuStop);

		jf.setVisible(true);	
		ButtonListener listener = new ButtonListener(jf.getGraphics(),jf,this);
//		jf.getGraphics().drawImage(backgroundImg,0,0,60,520,null);
		jbu.addActionListener(listener);
		jbuStop.addActionListener(listener);

		jf.addKeyListener(listener);
		jf.requestFocus();
		
	}
}
