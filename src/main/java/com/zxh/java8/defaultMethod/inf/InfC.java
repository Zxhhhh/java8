package com.zxh.java8.defaultMethod.inf;

public interface InfC extends InfA  {
	
	default public void method(){
		System.out.println("interfaceC");
	}

}
