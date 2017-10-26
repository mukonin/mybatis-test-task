package com.site;

import lombok.AllArgsConstructor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@AllArgsConstructor
public class TestConfig {

	private final SqlSessionFactory sqlSessionFactory;

	private static final List<String> INIT_SCRIPT_NAMES = new ArrayList<>();

	static {
		INIT_SCRIPT_NAMES.add("sql/schema.sql");
		INIT_SCRIPT_NAMES.add("sql/country_data.sql");
		INIT_SCRIPT_NAMES.add("sql/location_data.sql");
		INIT_SCRIPT_NAMES.add("sql/user_group_data.sql");
		INIT_SCRIPT_NAMES.add("sql/user_data.sql");
		INIT_SCRIPT_NAMES.add("sql/session_data.sql");
		INIT_SCRIPT_NAMES.add("sql/request_data_test.sql");
	}

	@PostConstruct
	public void initDatabase() throws IOException, SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		ScriptRunner runner = new ScriptRunner(conn);

		for (String scriptName : INIT_SCRIPT_NAMES) {
			Reader reader = Resources.getResourceAsReader(scriptName);
			runner.runScript(reader);
			reader.close();
		}
		conn.close();
		session.close();
	}
}