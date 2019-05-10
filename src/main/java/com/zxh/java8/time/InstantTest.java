package com.zxh.java8.time;

import java.time.Instant;
import java.util.function.Supplier;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstantTest{
	
	private static Logger log = LoggerFactory.getLogger(InstantTest.class);
	
	/**
	 * 时间戳类:机器语言的日期时间，Local系列的转换可以通过Instant作为中间类做转换
	 */
	@Test
	public void instantTest(){
		
		
		Instant instant = Instant.now();
		
		//1970-01-01 00:00:00到当前时间的秒值
		Long epochSecond = instant.getEpochSecond();
		log.info((epochSecond == System.currentTimeMillis())+"");
		
		//把当前时间戳的秒数转换为纳秒
		int nano = instant.getNano();
		
		Supplier<String> s1 = String::new;
		String str = s1.get();
		
	}

}
