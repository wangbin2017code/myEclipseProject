package com.wangbin.core;

/**
 * @author ����
 *
 */
public class HelloWorld {

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void printHello(){
		System.out.println("spring 3: hello! "+name);
	}
}
