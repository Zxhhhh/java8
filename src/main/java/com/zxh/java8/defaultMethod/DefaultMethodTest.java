package com.zxh.java8.defaultMethod;

import org.junit.Test;

import com.zxh.java8.defaultMethod.inf.InfA;
import com.zxh.java8.defaultMethod.inf.InfB;

public class DefaultMethodTest extends ClassA implements InfA { //普通继承问题 第一条：父类最优先

	@Test
	public void test1(){
		this.method();
	}
	
	@Test
	public void test2(){
		new ClassA().method();
	}
	
}
