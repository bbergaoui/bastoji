package us.onesquare.bastoji.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
 
@Table
public class Users {
 
	@PrimaryKey
	private UUID id;
 
	private String name;
	private int age;
	private String mail;
	private String lastName;
 
	public Users() {
	}
 
	
 
	public Users(UUID id, String name, int age, String mail, String lastName) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mail = mail;
		this.lastName = lastName;
	}



	public UUID getId() {
		return id;
	}
 
	public void setId(UUID id) {
		this.id = id;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getName() {
		return this.name;
	}
 
	public void setAge(int age) {
		this.age = age;
	}
 
	public int getAge() {
		return this.age;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", age=" + age + ", mail=" + mail + ", lastName=" + lastName
				+ "]";
	}
 
	
 
	
}
