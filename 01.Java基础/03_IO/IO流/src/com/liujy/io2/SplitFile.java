package com.liujy.io2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SplitFile {
	
	private File src;
	private String destDir;
	private int blockSize;
	private int size;
	private List<String> destPaths;
	
	public SplitFile() {
	}

	public SplitFile(int blockSize, String srcPath, String destDir) throws IOException {
		super();
		this.src = new File(srcPath);
		this.blockSize = blockSize;
		this.destDir = destDir;
		this.destPaths = new ArrayList<String>();
		
		// 初始化
		init();
		
	}

	private void init() throws IOException {
		long len = (int) src.length();
		this.size = (int) Math.ceil(len*1.0/this.blockSize);
		System.out.println(len);
		for (int i = 0; i < this.size; i++) {
			destPaths.add(this.destDir+"/"+i+src.getName());
		}
	}
	
	public void split() throws IOException {
		long length = this.src.length();
		int beginPos = 0;
		int actualSize = (int) (this.blockSize>length?length:this.blockSize);
		for (int i = 0; i < this.size; i++) {
			beginPos = i* this.blockSize;
			if (i == this.size-1) {
				actualSize = (int) length;
			} else {
				actualSize = this.blockSize;
				length -= this.blockSize;
			}
			System.out.println(beginPos+"-->"+actualSize);
			splitDetail(beginPos, actualSize,i);
		}
		
	}
	private void splitDetail(int beginPos,int actualSize,int i) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(src, "r");
		RandomAccessFile raf1 = new RandomAccessFile(new File(this.destPaths.get(i)), "rw");
		raf.seek(beginPos);
		byte[] flush = new byte[this.blockSize];
		int len;
		while ((len = raf.read(flush))!= -1) {
			if (actualSize > len) {
				raf1.write(flush, 0, len);
			} else {
				raf1.write(flush, 0, actualSize);
				break;
			}
			
		}
		raf1.close();
		raf.close();
	}

	/**
	 * 	文件的合并
	 * @throws IOException 
	 */
	public void merge(String destPath) throws IOException {
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
		Vector<InputStream> ve = new Vector<InputStream>();
		SequenceInputStream sis = null;
		for (int i = 0; i < destPaths.size(); i++) {
			ve.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
		}
		sis = new SequenceInputStream(ve.elements());
		byte[] flush = new byte[this.blockSize];
		int len = -1;
		while ((len = sis.read(flush))!=-1) {
			os.write(flush,0, len);
			os.flush();
		}
		sis.close();
		os.close();
	}
	
	public static void main(String[] args) throws IOException {
		SplitFile sf = new SplitFile(10,"src/com/liujy/io2/Copy.java","dest");
		sf.split();
		sf.merge("aaa.java");
	}
	

}

