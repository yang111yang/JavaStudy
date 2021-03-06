package com.liu.dynamiccomplie;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * 动态编译
 * @author liujy
 *
 */
public class Demo01 {
	
	public static void main(String[] args) throws IOException {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, "e:/myjava/HelloWorld.java");
		System.out.println(result == 0?"编译成功":"编译失败");
		
		// 执行编译成功的文件
		// 通过Runtime.getRuntime()运行启动新的进程运行
//		Runtime runtime = Runtime.getRuntime();
//		Process process = runtime.exec("java -cp e:/myjava HelloWorld");
//		InputStream is = process.getInputStream();
//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
//		String info = "";
//		while ((info = br.readLine())!=null) {
//			System.out.println(info);
//		}
		
		//通过反射运行编译好的类
		try {
			URL[] urls = new URL[] {new URL("file:/"+"e:/myjava/")};
			URLClassLoader loader = new URLClassLoader(urls);
			Class c = loader.loadClass("HelloWorld");
			//调用加载类的main方法
			c.getMethod("main",String[].class).invoke(null, (Object)new String[]{});
			 //由于可变参数是JDK5.0之后才有。
            //m.invoke(null, (Object)new String[]{});会编译成:m.invoke(null,"aa","bb"),就发生了参数个数不匹配的问题。
            //因此，必须要加上(Object)转型，避免这个问题。

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
