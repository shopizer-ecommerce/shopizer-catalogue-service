package com.shopizer.services.catalogue.config;

import java.util.Optional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@EntityScan({"com.shopizer.db","com.shopizer.catalog.model"})
public class PersistenceJPAConfig {

	/**
	 * Datasource
	 */
	//@Value("${db.driverClass}")
	//private String driverClassName;

	//@Value("${db.jdbcUrl}")
	//private String url;

	//@Value("${db.user}")
	//private String user;

	//@Value("${db.password}")
	//private String password;

	/**
	 * Other connection properties
	 */

	//@Value("${hibernate.ddl-auto}")
	//private String hbm2ddl;

	// @Value("${hibernate.dialect}")
	// private String dialect;

	//@Value("${db.show.sql}")
	//private String showSql;

	// @Value("${db.preferredTestQuery}")
	// private String preferredTestQuery;

	// @Value("${db.schema}")
	// private String schema;

	// @Value("${db.preferredTestQuery}")
	// private String testQuery;

	// @Value("${db.minPoolSize}")
	// private int minPoolSize;

	// @Value("${db.maxPoolSize}")
	// private int maxPoolSize;

	// H2, need to test MySQL and PostGres
	/**
	@Bean
	public DataSource dataSource() {

		// EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		// return builder.setType(EmbeddedDatabaseType.H2).build();

		HikariDataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class)
				.driverClassName(driverClassName).url(url).username(user).password(password).build();

		/** Datasource config **/
		//dataSource.setIdleTimeout(1);
		//dataSource.setMaximumPoolSize(3);
		// dataSource.setConnectionTestQuery(testQuery);

		//eturn dataSource;

		// REPLACE with
		// BasicDataSource dataSource = new BasicDataSource();
		// dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		// dataSource.setUrl(env.getProperty("jdbc.url"));
		// dataSource.setUsername(env.getProperty("jdbc.user"));

	//}


	/**
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.shopizer.model", "com.shopizer.db");
		//factory.setJpaProperties(this.hibernateProperties());
		factory.setDataSource(dataSource());
		return factory;
	}
	**/

	/**
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return transactionManager;
	}
	**/

	/*
	 * Properties hibernateProperties() { return new Properties() { {
	 * setProperty("hibernate.hbm2ddl.auto", hbm2ddl);
	 * setProperty("hibernate.dialect", showSql); } }; }
	 */

	@Bean
	public AuditorAware<String> auditorProvider() {

		/*
		 * if you are using spring security, you can get the currently logged username
		 * with following code segment.
		 * SecurityContextHolder.getContext().getAuthentication().getName()
		 */
		return () -> Optional.ofNullable("catalog");
	}

}
