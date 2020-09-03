package com.dxc.hibdao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dxc.beans.Student;
import com.dxc.sessionfactory.SessionFactoryrRsource;

public class StudentHibDAO extends SessionFactoryrRsource implements HibDAO<Student> {
	
	Session session;


	@Override
	public boolean edit(Student e) throws Exception {
		// TODO Auto-generated method stub
		session=getSessionFactory().openSession();
		session.beginTransaction();
		session.update(e);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean save(Student e) throws Exception {
		// TODO Auto-generated method stub
		session=getSessionFactory().openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean delete(int id) throws Exception {
		// TODO Auto-generated method stub
		session=getSessionFactory().openSession();
		session.beginTransaction();
		Student s= (Student) session.get(Student.class,id);
		session.delete(s);
		session.getTransaction().commit();
		session.close();

		return true;
	}

	@Override
	public Student find(int id) throws Exception {
		session=getSessionFactory().openSession();
		session.beginTransaction();
		Student s= (Student) session.get(Student.class,id);
		session.getTransaction().commit();
		session.close();
		return s;
	}

	@Override
	public List<Student> findAll() throws Exception {
		
		session=getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Student");
		List<Student> e = query.list();
		session.getTransaction().commit();
		session.close();

		return  e;
	} 

}
