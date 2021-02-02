package com.jt.details;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Table(name = "gcEmployees")
@Entity
public class Details {
@Column(name = "id", updatable=false)
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column
private String fullName;
@Column
private String Email;
@Column
private String userName;
@Column
private String password;
	 
	 public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	public String getUserName() {
	 return userName;
	 }
	 public void setUserName(String userName) {
	 this.userName = userName;
	 }
	 public String getPassword() {
	 return password;
	 }
	 public void setPassword(String password) {
	 this.password = password;
	 }
	 public void setFullName(String fullName) {
	 this.fullName = fullName;
	 }
	 public String getFullName() {
	 return fullName;
	 }
	 public void setEmail(String Email) {
	 this.Email = Email;
	 }
	 public String getEmail() {
	 return Email;
	 }
	 public static int compareByName(Details a, Details b) {
	        return a.userName.compareTo(b.userName);
	        
	    }


	@Override
	public String toString() {
		return "RegRequirements [id=" + id + ", fullName=" + fullName + ", email=" + Email + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	
}
