package com.site.config;

import lombok.AllArgsConstructor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.Reader;

@Configuration
@AllArgsConstructor
public class PersistenceConfig {

	@Bean
	public SqlSessionFactory sessionFactory() {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
		} catch (IOException ex) {
			throw new IllegalStateException("Error reading MyBatis configuration", ex);
		}
		return new SqlSessionFactoryBuilder().build(reader);
	}
}
