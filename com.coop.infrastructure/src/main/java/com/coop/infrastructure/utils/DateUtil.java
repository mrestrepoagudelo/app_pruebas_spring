package com.coop.infrastructure.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static void main(String[] args) {
//		System.out.println("LocalDateTime: " + LocalDateTime.now());
//		System.out.println("LocalDate: " + LocalDate.now());
//		System.out.println("Date: " + new Date());
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 8);
		cal.set(Calendar.MINUTE, 30);
		cal.set(Calendar.SECOND, 10);
		cal.set(Calendar.MILLISECOND, 010);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.YEAR, 2023);
		cal2.set(Calendar.MONTH, Calendar.FEBRUARY);
		cal2.set(Calendar.DAY_OF_MONTH, 1);
		cal2.set(Calendar.HOUR_OF_DAY, 8);
		cal2.set(Calendar.MINUTE, 30);
		cal2.set(Calendar.SECOND, 10);
		cal2.set(Calendar.MILLISECOND, 010);
		
//		Date date1 = cal.getTime();
//		Date date2 = cal2.getTime();
		
//		LocalDate d1 = convertToLocalDateViaInstant(date1);
//		LocalDate d2 = convertToLocalDateViaInstant(date2);
		
//		LocalDate ref = LocalDate.of(2022, 06, 01);
//		LocalDate ahora = LocalDate.now();
		
//		System.out.println(d1);
//		System.out.println(d2);
		
		LocalDateTime dt1 = LocalDateTime.parse("2023-12-04T12:00:30");
		LocalDateTime dt2 = LocalDateTime.parse("2023-12-05T12:45:30");
		long enAny = ChronoUnit.SECONDS.between(dt1, dt2);
		System.out.println(enAny);
	}
	
	public static Boolean validateDate1IsGreaterDate2(LocalDateTime date1, LocalDateTime date2) {
		return date1.isAfter(date2);
	}
	
	public static Boolean validateDate1IsLessDate2(LocalDateTime date1, LocalDateTime date2) {
		return date1.isBefore(date2);
	}
	
	public static Boolean validateIsDatesAreEquals(LocalDateTime date1, LocalDateTime date2) {
		return date1.isEqual(date2);
	}
	
	public static Boolean validateDate1IsGreaterDate2(LocalDate date1, LocalDate date2) {
		return date1.isAfter(date2);
	}
	
	public static Boolean validateDate1IsLessDate2(LocalDate date1, LocalDate date2) {
		return date1.isBefore(date2);
	}
	
	public static Boolean validateIsDatesAreEquals(LocalDate date1, LocalDate date2) {
		return date1.isEqual(date2);
	}
	
	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
}
