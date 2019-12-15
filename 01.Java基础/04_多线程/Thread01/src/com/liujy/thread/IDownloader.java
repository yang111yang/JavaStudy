package com.liujy.thread;

public class IDownloader implements Runnable {
	private String url;
	private String name;
	
	
	public IDownloader(String url, String name) {
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
		IDownloader td1 = new IDownloader("http://pic41.nipic.com/20140522/13975662_164750011385_2.jpg", "rqq.jpg");
		IDownloader td2 = new IDownloader("http://pic30.nipic.com/20130619/9885883_210838271000_2.jpg", "ly.jpg");
		IDownloader td3 = new IDownloader("http://photocdn.sohu.com/20120708/Img347586981.jpg", "dw.jpg");
		
		new Thread(td1).start();
		new Thread(td2).start();
		new Thread(td3).start();
	}

}
