package com.cbry.threadPool;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test {
public static void main(String[] args) {
	List list = new ArrayList<>();
	add(list);add(list);add(list);add(list);add(list);add(list);
	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		Object object = (Object) iterator.next();
		System.out.println(object);
	}
}
static void add(List<String> list) {
	list.add("10");
}
}
