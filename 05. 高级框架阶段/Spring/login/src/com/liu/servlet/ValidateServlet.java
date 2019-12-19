package com.liu.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/validcode")
public class ValidateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����һ��ͼƬ
		BufferedImage image = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
		//���û���
		Graphics2D graphics = image.createGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, 100, 40);
		
		List<Integer> randList = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			randList.add(random.nextInt(10));
		}
		//��������
		graphics.setFont(new Font("����",Font.ITALIC|Font.BOLD,30));
		//��ɫ����
		Color[] colors = new Color[] {Color.BLACK,Color.BLUE,Color.RED,Color.PINK,Color.GREEN,Color.GRAY};
		for (int i = 0; i < randList.size(); i++) {
			graphics.setColor(colors[random.nextInt(colors.length)]);
			graphics.drawString(randList.get(i)+"", i*20, 30+(random.nextInt(11)-5));
		}
		
		//������
		for (int i = 0; i < 2; i++) {
			graphics.setColor(colors[random.nextInt(colors.length)]);
			graphics.drawLine(0, random.nextInt(40), 100, random.nextInt(40));
		}
		
		ServletOutputStream os = resp.getOutputStream();
		//ʹ��ImageIO������
		ImageIO.write(image, "jpg", os);
		
		//����֤�����session��
		HttpSession session = req.getSession();
		session.setAttribute("code", ""+randList.get(0)+randList.get(1)+randList.get(2)+randList.get(3));
	}
}
