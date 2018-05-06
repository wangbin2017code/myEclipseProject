package com.wangbin.ssh.test;

import org.junit.Test;

import com.wangbin.ssh.domain.Person;
import com.wangbin.ssh.service.PersonService;

public class PersonTest extends BaseSpring{

	@Test
	public void testPerson(){
		PersonService personService =(PersonService)applicationContext.getBean("personService");
		Person person = new Person();
		person.setPname("wangbin1");
		personService.savePerson(person);
	}
}
