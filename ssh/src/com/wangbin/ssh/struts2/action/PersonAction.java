package com.wangbin.ssh.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wangbin.ssh.domain.Person;
import com.wangbin.ssh.service.PersonService;

public class PersonAction extends ActionSupport{
	
	private PersonService personService;
	
	public String savePerson(){
		Person person = new Person();
		person.setPname("test");
		this.personService.savePerson(person);
		return null;
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}
