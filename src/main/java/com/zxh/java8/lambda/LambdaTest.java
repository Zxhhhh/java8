package com.zxh.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

import com.zxh.java8.bean.Student;
import com.zxh.java8.lambda.functionInterface.ITest;

/**
 * Lambda表达式
 * @author zhuxianhao
 *
 */
public class LambdaTest {
	
	public static String name = "zxh";
	
	private static List<Student> students;
	static {
		students = Arrays.asList(new Student("zhangsan",90),
		new Student("lisi",30),
		new Student("wangwu",60),
		new Student("zhaoliu",45));
	}
	
	
	//Lambda表达式
	@Test
	public void lambda1() {
		
		List<String> s1 = new ArrayList<>();
		for(String str:s1) {
			System.out.println(str);
		}
		
		String result = parseName((String str)->str.length()>=5);
		System.out.println(result);
	}
	
	//列表过滤
	@Test
	public void lambda2() {
		List<Student> list = studentFilter(students,(student)->student.getScore()>=50);
		list.forEach((student)->{
			System.out.println(student);
		});
	}
	
	//列表排序
	@Test
	public void lambda3() {
		students.sort((s1,s2)->{return s1.getScore()-s2.getScore();});
		students.forEach((student)->{
			System.out.println(student);
		});
	}
	
	//Lambada表达式与匿名函数对于函数式接口的实现对比
	@Test
	public void lambda4() {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("1");
			}
		};
		
		//Lambda实现函数式接口，因为只有一个接口，所以编译器清楚要实现的接口是哪个。
		Runnable r2 = ()->{System.out.println("2");};
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("1");
			}
		});
		Thread t2 = new Thread(()->{System.out.println("2");});
		
		t1.start();
		t2.start();
	}
	
	public String parseName(ITest<String> test) {
		
		//处理逻辑
		//动作被传到方法中，并调用
		boolean flag = test.parse(name);
		return flag?"yes":"no";
	}
	
	//元素过滤实现
	private List<Student> studentFilter(List<Student> students,Predicate<Student> p){
		List<Student> result = new ArrayList<Student>();
		students.forEach((student)->{
			if(p.test(student)) {
				result.add(student);
			}
		});
		return result;
	}

}
