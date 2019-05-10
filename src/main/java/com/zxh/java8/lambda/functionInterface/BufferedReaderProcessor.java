package com.zxh.java8.lambda.functionInterface;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 处理读取对象的接口
 * @author zhuxianhao
 *
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
	String process(BufferedReader b) throws IOException;
}
