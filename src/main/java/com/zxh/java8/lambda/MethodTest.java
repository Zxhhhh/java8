package com.zxh.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Test;
import org.springframework.util.StringUtils;

import com.zxh.java8.bean.Student;
import com.zxh.java8.bean.StudentComparator;

/**
 * 方法引用
 * @author zhuxianhao
 *
 */
public class MethodTest {
	
	private static List<Student> students;
	
	static {
		students = Arrays.asList(new Student("zhangsan",90),
		new Student("lisi",30),
		new Student("wangwu",60),
		new Student("zhaoliu",45));
	}
	private String value;
	
	public MethodTest() {
		super();
	}
	public MethodTest(String value) {
		super();
		this.value = value;
	}
	
	
	//方法引用1:静态方法引用
	@Test
	public void staticMethodInvoke() {
		//案例 1
		Function<String,Integer> f1 = Integer::parseInt;
		Function<String,Integer> f2 = String::length;
		methodInvoke1Parse("12345",f1);
		methodInvoke1Parse("12345",f2);
		
		//案例 2
		students.sort(StudentComparator::compareStudentByScoreStatic);
		students.forEach((student)->{
			System.out.println(student);
		});
	}
	
	//方法引用2:任意类型类型方法的方法引用
	@Test
	public void innerMethodInvoke() {
		//案例 1
		new MethodTest("zxh").methodInvoke2Parse(MethodTest::showValue);
		
		//案例 2
		students.sort(Student::compareStudentByScore);
		//也是非静态，但这里会报错
		//students.sort(StudentComparator::compareStudentByScore);
		students.forEach((student)->{
			System.out.println(student);
		});
	}
	
	//方法引用3:现有对象的实例方法
	@Test
	public void outerMethodInvoke() {
		StudentComparator comparator = new StudentComparator(5);
		//这里调用的方法时实例化this
		students.sort(comparator::compareStudentByScore);
		students.forEach((student)->{
			System.out.println(student);
		});
	}
	
	//最终的列表排序
	@Test
	public void finalListSort() {
		students.sort(Comparator.comparing(Student::getScore));
	}
	
	
	public  void methodInvoke1Parse(String str,Function<String,Integer> function) {
		if(!StringUtils.isEmpty(str)) {
			System.out.println("str:"+str);
			Integer i = function.apply(str);
			System.out.println("parse complete,i="+i);
		}
	}
	
	public void methodInvoke2Parse(Consumer<MethodTest> c) {
		//执行methodTest的执行逻辑
		c.accept(this);
	}
	
	public static void methodInvoke3Parse(String str,Function<String,String> f) {
		String newStr = f.apply(str);
		System.out.println("newStr:"+newStr);
	}
	
	public void showValue() {
		System.out.println("my value:"+value);
	}
	
}
