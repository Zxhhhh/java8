package com.zxh.java8.optional;

import java.util.Optional;

public class OptionalTest {
	
	public void optionalTest() {
		String s1 = "123";
		Optional<String> o1 = Optional.of(s1);
		o1.isPresent();
	}

}
