package com.config;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBDD {
	@Bean
	public static Connection getConnection() {
		String jdbcdriver="org.h2.Driver";
		String user="sa";
		String password="";
		String sqlUrl="jdbc:h2:tcp://localhost/~/test";
		Connection connection = null;
			try {
				Class.forName(jdbcdriver);
				connection = DriverManager.getConnection("" + sqlUrl, user, password);	
				System.out.println("connecter");
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("erreur de connection");
			}
		return connection;
	}
	
}
