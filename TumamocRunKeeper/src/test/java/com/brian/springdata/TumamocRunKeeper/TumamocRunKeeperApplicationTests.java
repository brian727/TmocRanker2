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
		HashSet<Session> sessions = new HashSet<Session>();
		
		Session ses1 = new Session();
		ses1.setSessionduration(90);
		ses1.setTmocker(tmocker);
		sessions.add(ses1);
		
		Session ses2 = new Session();
		ses2.setSessionduration(45);
		ses2.setTmocker(tmocker);
		sessions.add(ses2);
		
		tmocker.setSessions(sessions);
	
		repo.save(tmocker);
	}
}












