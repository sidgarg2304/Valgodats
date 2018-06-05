package com.vishal.java8practice.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeDatePractice {

	public static void main(String[] args) {

		System.out.println(LocalTime.now());
		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd:MMM:yy")));
	}

}
