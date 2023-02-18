package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class JdbcConfig {

    @Bean("dataSource")
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
        ds.setUsername("root");
        ds.setPassword("root1234");
        return ds;
    }
    @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate(){
        JdbcTemplate template=new JdbcTemplate();
        template.setDataSource(getDataSource());
        return template;
    }

//    @Bean("studentDao")
//    public StudentDao getStudentDao(){
//        StudentDaoImpl studentDao=new StudentDaoImpl();
//        studentDao.setJdbcTemplate(getTemplate());
//        return studentDao;
//    }

}
