package com.site.repository;

import com.site.mapper.ReportMapper;
import com.site.model.Report;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ReportRepository {

	private final SqlSessionFactory sessionFactory;

	public List<Report> findAll() {
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			ReportMapper reportMapper = sqlSession.getMapper(ReportMapper.class);
			return reportMapper.getAll();
		}
	}
}