package ru.team32.javathon.config;

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
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.team32.javathon.entity.User;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;


@Configuration
@EnableJpaRepositories(basePackages = "ru.team32.javathon.entity.repository")
@PropertySource("persistence-user.properties")
@EnableTransactionManagement
public class JpaConfig {

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
}