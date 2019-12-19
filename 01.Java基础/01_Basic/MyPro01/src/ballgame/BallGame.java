package ballgame;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class BallGame extends JFrame {
	
	// 加载图片
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	
	double x = 100; // 小球的横坐标
	double y = 100; // 小球的纵坐标
	// 小球是否向右移动
	boolean right = true; 
	
	public void paint(Graphics g) {
		System.out.println("画了一次桌面");
		
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int)x, (int)y, null);
		
		
	}
	
	// 加载窗口
	void lanchFrame() {
		setSize(856,500);
		setLocation(50, 50);
		setVisible(true);
		while (true) {
			repaint();
			if (x > 786) {
				right = false;
			} else if (x < 40) {
				right = true;
			}
			
			if (right) {
				x += 10;
			} else {
				x -= 10;
			}
			
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		BallGame game = new BallGame();
		game.lanchFrame();
		
	}

}
