/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.quickstart.config;

import java.net.URI;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.postgresql.jdbc3.Jdbc3PoolingDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;

/**
 * Main configuration class for the application.
 * Turns on @Component scanning, loads externalized application.properties, and sets up the database.
 * @author Keith Donald
 */
@Configuration
@ComponentScan(basePackages = "org.springframework.social.quickstart", excludeFilters = { @Filter(Configuration.class) })
@PropertySource("classpath:org/springframework/social/quickstart/config/application.properties")
public class MainConfig {

	@Bean(destroyMethod = "shutdown")
	public DataSource dataSource_original() {
		EmbeddedDatabaseFactory factory = new EmbeddedDatabaseFactory();
		factory.setDatabaseName("spring-social-quickstart");
		factory.setDatabaseType(EmbeddedDatabaseType.H2);
		factory.setDatabasePopulator(databasePopulator());
		return factory.getDatabase();
	}

	@Bean
    public DataSource dataSource() throws Exception {
		String databaseUrl = System.getenv("DATABASE_URL");
		if(databaseUrl == null){
			databaseUrl = System.getenv("LOCAL_BOLIGER_DATABASE_URL");
		}
		if(databaseUrl == null){
			throw new RuntimeErrorException(null, "Missing environment variable DATABASE_URL");
		}
        URI dbUri = new URI(databaseUrl);
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        
        Jdbc3PoolingDataSource source = new Jdbc3PoolingDataSource();
        source.setDataSourceName("PostgreSQL Data Source");
        source.setServerName(dbUri.getHost());
        source.setDatabaseName(dbUri.getPath().replaceFirst("/", ""));
        
        source.setUser(username);
        source.setPassword(password);
        source.setMaxConnections(10);
        return source;
//        
//        DataSource basicDataSource = new DataSource();
//        basicDataSource.setUrl(dbUrl);
//        basicDataSource.setUsername(username);
//        basicDataSource.setPassword(password);        
//        return basicDataSource;
    }

	// internal helpers

	private DatabasePopulator databasePopulator() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("JdbcUsersConnectionRepository.sql", JdbcUsersConnectionRepository.class));
		return populator;
	}
}
