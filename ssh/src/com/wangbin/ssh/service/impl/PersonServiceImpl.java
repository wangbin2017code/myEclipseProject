package com.wangbin.ssh.service.impl;

import com.wangbin.ssh.dao.PersonDao;
import com.wangbin.ssh.domain.Person;
import com.wangbin.ssh.service.PersonService;

public class PersonServiceImpl implements PersonService{

	private PersonDao personDao;
	
	@Override
	public void savePerson(Person person) {
		this.personDao.savePersion(person);
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

}
