package model;

import java.io.Serializable;

public class User implements Serializable{
	private String id, pass, name, mail;

	public User() {
		
	}
	public User(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	public User(String id, String pass, String name, String mail) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.mail = mail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
