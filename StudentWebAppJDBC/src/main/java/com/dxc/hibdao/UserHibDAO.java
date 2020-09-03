package com.dxc.hibdao;

import java.util.List;

import org.hibernate.Session;

import com.dxc.beans.Student;
import com.dxc.beans.User;
import com.dxc.sessionfactory.SessionFactoryrRsource;

public class UserHibDAO extends SessionFactoryrRsource implements HibDAO<User>{
	static Session session;
	

	@Override
	public boolean edit(User e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(User e) throws Exception {
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
		return false;
	}

	@Override
	public User find(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public static boolean validate(String un,String pw) throws Exception {
		boolean res=false;
		User u=null;
		User p=null;
		session=getSessionFactory().openSession();
		session.beginTransaction();
		u= (User) session.get(User.class,un);
		p=(User) session.get(User.class, pw);
		session.getTransaction().commit();
		session.close();
		if(u.equals(u)&&p.equals(p))
		{
			res=true;
		}else {
			res=false;
		}
		return res;
		
	}
	

}
