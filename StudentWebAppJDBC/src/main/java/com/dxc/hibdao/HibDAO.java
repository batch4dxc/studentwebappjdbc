package com.dxc.hibdao;

import java.util.ArrayList;
import java.util.List;

import com.dxc.beans.Student;

public interface HibDAO<E> {
	boolean edit(E e) throws Exception;
	boolean save(E e) throws Exception;
	boolean delete(int id) throws Exception;
	E find(int id) throws Exception;
	List<Student> findAll() throws Exception;

}
