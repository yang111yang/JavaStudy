package com.liujy.thread;

public class TDownloader extends Thread {
	private String url;
	private String name;
	
	
	public TDownloader(String url, String name) {
		this.url = url;
		this.name = name;
	}


	@Override
	public void run() {
		WebDownloader wd = new WebDownloader();
		wd.download(this.url, this.name);
		System.out.println(name);
	}
	
	public static void main(String[] args) {
		TDownloader td1 = new TDownloader("http://pic41.nipic.com/20140522/13975662_164750011385_2.jpg", "rqq.jpg");
		TDownloader td2 = new TDownloader("http://pic30.nipic.com/20130619/9885883_210838271000_2.jpg", "ly.jpg");
		TDownloader td3 = new TDownloader("http://photocdn.sohu.com/20120708/Img347586981.jpg", "dw.jpg");
		
		td1.start();
		td2.start();
		td3.start();
	}

}
