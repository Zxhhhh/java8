package com.zxh.java8.jvm;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JvmTest {
	
	public static void main(String[] args) {
        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        try {
            url = new File("C:\\Users\\lenovo\\Desktop\\blok").toURI().toURL();
            URL[] urls = { url };
            while (true) {
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("com.zxh.java8.jvm.JvmTest");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	
	}
	
	@Test
	public void test1(){
		String base = "12345678";
		while(true){
			String s = base+base;
			base = s;
		}
	}
}
