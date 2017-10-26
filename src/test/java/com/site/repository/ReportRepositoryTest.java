package com.site.repository;

import com.site.model.Report;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportRepositoryTest {

	@Autowired
	private ReportRepository repository;

	@Test
	public void findAllTest() {
		List<Report> reports = repository.findAll();
		assertEquals(reports.size(), 9030);
	}
}