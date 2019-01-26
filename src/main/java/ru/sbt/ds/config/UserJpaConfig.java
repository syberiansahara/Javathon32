package ru.sbt.ds.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.sbt.ds.entity.User;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;


@Configuration
@EnableJpaRepositories(basePackages = "ru.sbt.ds.entity.repository")
@PropertySource("persistence-user.properties")
@EnableTransactionManagement
public class UserJpaConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));

        return dataSource;
    }

    @Bean
    public HibernateTemplate hibernateTemplate() throws IOException, SQLException {
        return new HibernateTemplate(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory() throws IOException, SQLException {
        return new LocalSessionFactoryBuilder(dataSource())
                .addAnnotatedClasses(User.class)
                .buildSessionFactory();
    }

    // configure entityManagerFactory

    // configure transactionManager

    // configure additional Hibernate Properties
}