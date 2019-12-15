package com.liu.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class NumServlet extends HttpServlet {
	/**
	 * 重写init方法，把nums读取出来
	 */
	@Override
	public void init() throws ServletException {
		ServletContext sc = this.getServletContext();
		String path = sc.getRealPath("nums/nums.txt");
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String nums = br.readLine();
			System.out.println(nums);
			sc.setAttribute("nums", nums);
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
	
	/**
	 * 重写destroy，把nums写入到文件中
	 */
	@Override
	public void destroy() {
		ServletContext sc = this.getServletContext();
		if (sc.getAttribute("nums") != null) {
			String path = sc.getRealPath("nums/nums.txt");
			BufferedWriter bw = null;
			FileWriter fw = null;
			try {
				fw = new FileWriter(path);
				bw = new BufferedWriter(fw);
				bw.write((String) sc.getAttribute("nums"));
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
	}
}
