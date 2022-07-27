package com.brian.springdata.TumamocRunKeeper;



import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.brian.springdata.TumamocRunKeeper.entities.Session;
import com.brian.springdata.TumamocRunKeeper.entities.Tmocker;
import com.brian.springdata.TumamocRunKeeper.repos.TmockerRepository;




@RunWith(SpringRunner.class)
@SpringBootTest
class TumamocRunKeeperApplicationTests {
	
	@Autowired
	TmockerRepository repo;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {
		Tmocker tmocker = new Tmocker();
		tmocker.setName("Tmocker1");
		tmocker.setEmail("tmocker1@aol.com");
		tmocker.setZip(85701);
		
		Session ses1 = new Session();
		ses1.setSessionduration(60);
		ses1.setTmocker(tmocker);
		tmocker.addSession(ses1);
		
		Session ses2 = new Session();
		ses2.setSessionduration(45);
		ses2.setTmocker(tmocker);
		tmocker.addSession(ses2);
		
		repo.save(tmocker);
		
		Tmocker tmocker2 = new Tmocker();
		tmocker2.setName("Tmocker2");
		tmocker2.setEmail("tmk2@aol.com");
		tmocker2.setZip(85702);
		
		repo.save(tmocker2);
	}
	
	
	@Test 
	public void testAddSessionsToTmocker1() {
		HashSet<Session> Tmocker1Sessions = new HashSet<Session>();
		Tmocker tmocker = new Tmocker();

		Session ses3 = new Session();
		ses3.setSessionduration(90);
		tmocker.addSession(ses3);

		ses3.setTmocker(tmocker);
		Tmocker1Sessions.add(ses3);
		tmocker.addSession(ses3);
		
		Tmocker tmocker2 = new Tmocker();
		Session ses2 = new Session();
		ses2.setSessionduration(45);
		ses2.setTmocker(tmocker2);
		Tmocker1Sessions.add(ses2);
		tmocker2.addSession(ses2);

		
		
	}
	
	@Test public void testAddSessionsToTmocker2() {
		HashSet<Session> Tmocker2Sessions = new HashSet<Session>();
		Tmocker tmocker2 = new Tmocker();
		
		Session ses3 = new Session();
		ses3.setSessionduration(15);
		ses3.setTmocker(tmocker2);
		Tmocker2Sessions.add(ses3);
		repo.save(tmocker2);
		}
}












