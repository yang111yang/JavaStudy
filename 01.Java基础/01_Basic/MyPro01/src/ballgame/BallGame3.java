package ballgame;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BallGame3 extends JFrame {
	
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	
	double x = 100; // 球的横坐标
	double y = 100; // 球的纵坐标
	
	int speed = 10; // 小球移动的速度
	double degree = 3.14/3; // 弧度
	
	// 画图片
	public void paint(Graphics g) {
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int)x, (int)y, null);
		
		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);
		
		// 上下边框的碰撞
		if (y > 420 || y < 80) {
			degree = -degree;
		}
		
		// 左右边框的碰撞
		if (x > 786 || x < 40) {
			degree = 3.14 - degree;
		}
		
	}
	
	// 加载界面
	void lanchFrame() {
		setSize(856,500);
		setLocation(100,100);
		setVisible(true);
		
		while (true) {
			repaint();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		BallGame3 game = new BallGame3();
		game.lanchFrame();
	}

}
