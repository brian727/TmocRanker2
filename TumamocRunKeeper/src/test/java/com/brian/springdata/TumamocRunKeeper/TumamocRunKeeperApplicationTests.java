package com.brian.springdata.TumamocRunKeeper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
	TmockerRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {
		Tmocker tmocker = new Tmocker();
		tmocker.setId(2);
		tmocker.setName("Tmocker1");
		tmocker.setEmail("tmocker1@aol.com");
		Session session = new Session();
		session.setSessiondate(null);
		session.setSessionstart(null);
		session.setSessionstop(null);
		session.setSessionduration(null);
		repository.save(tmocker);
	}
	
	@Test
	public void testRead() {
		Tmocker tmocker = repository.findById(1).get();
		assertNotNull(tmocker);
		assertEquals("Tmocker1", tmocker.getName());
		System.out.println(">>>>>>>>>>>>>> "+tmocker.getId()+tmocker.getName()+tmocker.getEmail());
	}

	@Test
	public void testUpdate() {
		Tmocker tmocker = repository.findById(1).get();
		tmocker.setName("tmocker2");
		repository.save(tmocker);
	}
	
	@Test
	public void testDelete() {
		if (repository.existsById(1)){
		repository.deleteById(1);
		}
	}
	
	@Test
	public void testCount() {
		System.out.println("TOTAL RECORDS >>>>>>>>  " + repository.count());
	}
}












