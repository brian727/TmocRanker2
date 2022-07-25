package com.brian.springdata.TumamocRunKeeper.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Session {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long sessionid;
	private long sessionduration;
	
	@ManyToOne
	@JoinColumn(name="tmocker_id")
	private Tmocker tmocker;
	
	public long getId() {
		return sessionid;
	}
	public void setId(long id) {
		this.sessionid = id;
	}
	public long getSessionduration() {
		return sessionduration;
	}
	public void setSessionduration(long sessionduration) {
		this.sessionduration = sessionduration;
	}
	public long getSessionid() {
		return sessionid;
	}
	public void setSessionid(long sessionid) {
		this.sessionid = sessionid;
	}
	public Tmocker getTmocker() {
		return tmocker;
	}
	public void setTmocker(Tmocker tmocker) {
		this.tmocker = tmocker;
	}
	

}
