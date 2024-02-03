package com.klef.jfsd.CRUDOperations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student 
{
	@Id //primary key = unique + not null
	private int id;
	@Column(name = "sname", length = 30, nullable = false)
	private String name;
	@Column(name = "sgender", length = 30, nullable = false)
	private String gender;
	@Column(name = "sdob", length = 30, nullable = false)
	private String dateofbirth;
	@Column(name = "scollege", length = 30, nullable = false)
	private String college;
	@Column(name = "sdepartment", length = 30, nullable = false)
	private String department;
	@Column(name = "scgpa", nullable = false,precision = 4,scale = 2)
	private double cgpa;
	@Column(name = "sbacklogs", nullable = false)
	private int backlogs;
	@Column(name = "scontact", length = 20, nullable = false,unique = true)
	private String contact;

	
	public int getId() 
	{
		return id;
	}
	public String getName() 
	{
		return name;
	}
	public String getGender() 
	{
		return gender;
	}
	public String getDateofbirth() 
	{
		return dateofbirth;
	}
	public String getCollege() 
	{
		return college;
	}
	public String getDepartment() 
	{
		return department;
	}
	public double getCgpa() 
	{
		return cgpa;
	}
	public int getBacklogs() 
	{
		return backlogs;
	}
	public String getContact() 
	{
		return contact;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	public void setDateofbirth(String dateofbirth) 
	{
		this.dateofbirth = dateofbirth;
	}
	public void setCollege(String college) 
	{
		this.college = college;
	}
	public void setDepartment(String department) 
	{
		this.department = department;
	}
	public void setCgpa(double cgpa) 
	{
		this.cgpa = cgpa;
	}
	public void setBacklogs(int backlogs) 
	{
		this.backlogs = backlogs;
	}
	public void setContact(String contact) 
	{
		this.contact = contact;
	}
	
}
