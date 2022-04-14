package com.dao;

import java.util.ArrayList;

import com.model.Menber;


public interface MenberDao {
	public boolean insert(Menber m);
	public  ArrayList<Menber> selectAll();
	public boolean serichByName(String name);
	public Menber serichByNameAndPWD(String name,String PWd);
	public boolean updateByUserName(Menber m);
}
