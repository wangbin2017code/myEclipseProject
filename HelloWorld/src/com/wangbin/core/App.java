package com.wangbin.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangbin.output.OutputHelper;

/**
 * 
 * @author Íõ±ó
 *
 */
public class App {

	public static void main(String[] args) {
		
		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloBean");
		helloWorld.printHello();*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OutputHelper outputHelper =(OutputHelper) context.getBean("outputHelper");
		outputHelper.outputStr();
	}

}
