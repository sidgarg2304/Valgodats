package com.vishal.design.facebook;

import java.util.*;

public class Person {

	String name;
	String id;
	String phoneNo;

	List<Person> friends;

	public Person() {
		friends = new ArrayList<>();
	}
}
