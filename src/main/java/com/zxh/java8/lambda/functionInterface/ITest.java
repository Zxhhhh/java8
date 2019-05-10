package com.zxh.java8.lambda.functionInterface;

/**
 * 函数式接口
 * @author zhuxianhao
 *
 */
@FunctionalInterface
public interface ITest<T> {
	
	//入口方法，模拟接口Predicate<T>
	boolean parse(T t);
	
	//默认方法
	default void test1() {
		System.out.println("test1");
	}

}
