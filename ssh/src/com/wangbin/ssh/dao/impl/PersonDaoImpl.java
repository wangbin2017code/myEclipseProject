package com.wangbin.ssh.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wangbin.ssh.dao.PersonDao;
import com.wangbin.ssh.domain.Person;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao{

	@Override
	public void savePersion(Person person) {
		this.getHibernateTemplate().save(person);
	}

}
