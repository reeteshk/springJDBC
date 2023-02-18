package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class test {
    public static void main(String[] args) {

        System.out.println("My program stated......");
       // ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext context1=new AnnotationConfigApplicationContext(JdbcConfig.class);
//        JdbcTemplate template=context.getBean("jdbcTemplate", JdbcTemplate.class);
//
//        String query="insert into student(id,name,city) values(?,?,?)";
//
//        int result=template.update(query,123,"Raushan","Bihar");
//        System.out.println(result);

       StudentDao studentdao = context1.getBean("studentDao", StudentDao.class);
//       Student student =new Student();
//       student.setName("Rishabh");
//       student.setId(89);
//       student.setCity("Mathura");
//       int result = studentdao.insert(student) ;
//       System.out.println(result);



//        int r=studentdao.delete(89);
//        System.out.println("the value got deleted "+r);
        Student student=studentdao.getStudent(111);
        System.out.println(student);

        List<Student> lists=studentdao.getAllStudents();
        for(int i=0;i< lists.size();i++)
        {
            System.out.println(lists.get(i));
        }
        }
    }

