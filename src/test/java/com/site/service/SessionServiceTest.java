package com.site.service;


import com.site.model.domain.Session;
import com.site.service.domain.SessionService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SessionServiceTest {

	@Autowired
	private SessionService service;

	@Test
	public void test_1_findAll() {
		List<Session> sessions = service.findAll();
		assertEquals(sessions.size(), 300);
	}

	@Test
	public void test_2_crud() {
		Session session = new Session();
		session.setUserId(5);
		session.setDateOpened(LocalDateTime.now().minusHours(1L));
		session.setDateClosed(LocalDateTime.now());
		service.create(session);

		assertNotNull(session.getId());

		Session created = service.findById(session.getId());
		assertEquals(session.getUserId(), created.getUserId());
		assertEquals(session.getDateOpened(), created.getDateOpened());
		assertEquals(session.getDateClosed(), created.getDateClosed());

		created.setUserId(6);
		created.setDateOpened(LocalDateTime.now().minusDays(1L).minusHours(1L));
		created.setDateClosed(LocalDateTime.now().minusDays(1L));

		service.update(created);

		Session updated = service.findById(created.getId());
		assertEquals(created.getUserId(), updated.getUserId());
		assertEquals(created.getDateOpened(), updated.getDateOpened());
		assertEquals(created.getDateClosed(), updated.getDateClosed());

		service.delete(updated.getId());

		Session deleted = service.findById(updated.getId());
		assertEquals(null, deleted);
	}
}
