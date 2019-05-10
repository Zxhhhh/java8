package com.zxh.java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalTest {
	
	private static Logger log = LoggerFactory.getLogger(LocalTest.class);
	
	/**
	 * LocalDate:纯日期，不包含时间和时区信息
	 */
	@Test
	public void localDateTest(){
		//当前日期
		LocalDate currentDate = LocalDate.now();
		currentDate = LocalDate.parse("2019-04-22");
		//currentDate = LocalDate.of(2019,4,22);
		
		//dayOfMonth,dayOfWeek,dayOfYear
		int dayOfMonth = currentDate.getDayOfMonth();
		dayOfMonth = currentDate.get(ChronoField.DAY_OF_MONTH);
		
		int month = currentDate.getMonth().getValue();
		month = currentDate.get(ChronoField.MONTH_OF_YEAR);
		
		int year = currentDate.getYear();
		year = currentDate.get(ChronoField.YEAR);
		
		//是否闰年
		boolean leap = currentDate.isLeapYear();
		
		log.info("dayOfMonth:{},month:{},year:{},isLeap:{}",dayOfMonth,month,year,leap);
	}
	
	/**
	 * LocalTime:纯时间，不包含日期
	 */
	@Test
	public void localTimeTest() {
		LocalTime currentTime = LocalTime.now();
		currentTime = LocalTime.parse("13:45:20");
		//currentTime = LocalTime.of(13,45,20); //13:45:20
		
		int hour = currentTime.getHour();
		hour = currentTime.get(ChronoField.HOUR_OF_DAY);
		int minute = currentTime.getMinute();
		minute = currentTime.get(ChronoField.MINUTE_OF_HOUR);
		int second = currentTime.get(ChronoField.SECOND_OF_MINUTE);
		
		log.info("hour:{},minute:{},second:{}",hour,minute,second);
	}
	
	/**
	 * LocalDateTime:复合类，包含了日期和时间，LocalDate和LocalTime的复合体
	 */
	@Test
	public void localDateTimeTest() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		//currentDateTime = LocalDateTime.of(2019,4,22,13,45,20);
		currentDateTime = LocalDateTime.parse("2019-04-22 13:45:20");
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		
		//LocalDate -> LocalDateTime
		LocalDateTime dateTrans = date.atTime(time); //date.atTime("13:45:20")
		dateTrans = date.atStartOfDay();
		//LocalDateTime -> LocalDate
		date = dateTrans.toLocalDate();
		
		//LocalTime -> LocalDateTime
		LocalDateTime timeTrans = time.atDate(date); //time.atDate("2019-04-22")
		//LocalDateTime -> LocalTime
		time = timeTrans.toLocalTime();
		
		//LocalDateTime 拥有LocalDate和LocalTime的方法
		
	}

}
