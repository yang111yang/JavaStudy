package ballgame;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class BallGame2 extends JFrame {
	
	// ����ͼƬ
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	
	double x = 100; // С��ĺ�����
	double y = 100; // С���������
	
	double degree = 3.14/3; // ����
	
	int speed = 10;
	
	public void paint(Graphics g) {
		
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int)x, (int)y, null);
		
		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);
		
		// ���±߿���ײ
		if (y > 430 || y < 80) {
			degree = - degree;
			speed--;
		}
		
		// ���ұ߿����ײ
		if (x < 40 || x > 786) {
			degree = 3.14 - degree;
			speed--;
		}
		
		
	}
	
	// ���ش���
	void lanchFrame() {
		setSize(856,500);
		setLocation(50, 50);
		setVisible(true);
		while (true) {
			repaint();
			
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (speed <= 0) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		
		BallGame2 game = new BallGame2();
		game.lanchFrame();
		
	}

}
