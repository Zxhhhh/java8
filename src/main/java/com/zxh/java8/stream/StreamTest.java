package com.zxh.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

import com.zxh.java8.bean.dishes.Dish;
import com.zxh.java8.bean.dishes.Type;

public class StreamTest {
	
	private static List<Dish> menu = Arrays.asList(
				new Dish("pork",false,800,Type.MEAT),
				new Dish("beef",false,700,Type.MEAT),
				new Dish("chicken",false,400,Type.MEAT),
				new Dish("french fries",true,530,Type.OTHER),
				new Dish("rice",true,350,Type.OTHER),
				new Dish("season fruit",true,120,Type.OTHER),
				new Dish("pizza",true,550,Type.OTHER),
				new Dish("prawns fruit",false,300,Type.FISH),
				new Dish("salmon",false,450,Type.FISH)
			);
	
	
	@Test
	public void streamTest() {
		List<String> lowCaloricDishName = 
					menu.stream() //Stream<Dish>
						.filter((Dish d)->d.getCalories()<400) //筛选
						.sorted(Comparator.comparing(Dish::getCalories)) //排序
						.map(Dish::getName) //映射
						.collect(Collectors.toList()); //收集
		System.out.println(lowCaloricDishName);
	}
	
	
	/*
	 * 主题：集合与流的区别
	 * 		1.创建方式:集合-急切创建(集合中的每个元素都要计算出来才能添加到集合中并使用)
	 * 				 流-延迟创建(按需要提取的值按需生成元素)
	 */
	@Test
	public void streamTest2() {
		List<String> names = menu.stream()
				.filter((Dish d)->{
					System.out.println("filtering "+d.getName());
					return d.getCalories()>500;
				})
				.sorted((Dish d1,Dish d2)->{
					System.out.println("sorting "+d1.getName()+"-"+d2.getName());
					return d1.getCalories()-d2.getCalories();
				})
				.map((Dish d)->{
					System.out.println("mapping "+d.getName());
					return d.getName();
				})
				.limit(3) //限制拿3个元素
				.collect(Collectors.toList());
		System.out.println(names);
	}
	
	

}
