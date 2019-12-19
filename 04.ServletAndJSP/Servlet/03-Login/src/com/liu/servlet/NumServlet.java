package com.liu.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class NumServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		String path = this.getServletContext().getRealPath("/nums/nums.txt");
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String nums = br.readLine();
			System.out.println(nums);
			this.getServletContext().setAttribute("nums", nums);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//��дdestory�������洢���������ļ�
	@Override
	public void destroy() {
		String path = this.getServletContext().getRealPath("/nums/nums.txt");
		//��ȡ������
		String nums = (String) this.getServletContext().getAttribute("nums");
		if (nums != null) {
			BufferedWriter bw = null;
			FileWriter fw = null;
			try {
				fw = new FileWriter(path);
				bw = new BufferedWriter(fw);
				bw.write(nums);
				bw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (fw != null) {
						fw.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if (bw != null) {
						bw.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(nums);
	}
}
