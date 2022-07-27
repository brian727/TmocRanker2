package com.brian.springdata.TumamocRunKeeper.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;







@Entity
@Table
public class Tmocker {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long tmockerid;
	private String name;
	private String email;
	private int zip;
	@OneToMany(mappedBy="tmocker", cascade=CascadeType.ALL)
	private Set<Session> sessions;
	
	public long getId() {
		return tmockerid;
	}
	public void setId(long id) {
		this.tmockerid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	public void addSession(Session session) {
		if(session!=null) {
			if(sessions==null) {
				sessions = new HashSet<>();
			}
			session.setTmocker(this);
			sessions.add(session);
		}
	}
}





