package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }

    public StudentDaoImpl() {
        super();
    }

    public int insert(Student student) {
        String query="insert into student(id,name,city) values(?,?,?)";
        int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return r;
    }

    public int change(Student student) {
        String query="update student set name=?, city=? where id=?";
        int r=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return r;
    }

    public int delete(int  id) {
        String query="delete from student where id=?";
        int r=this.jdbcTemplate.update(query,id);
        return r;
    }

    public Student getStudent(int studentId) {
        //selecting single student query
        String query="select * from student where id=?";
        RowMapper<Student> rm=new RowMapperImp();
        Student student=this.jdbcTemplate.queryForObject(query,rm,studentId);
        return student;
    }

    public List<Student> getAllStudents() {
        String query="select * from student";
        List<Student> students=this.jdbcTemplate.query(query,new RowMapperImp());
        return students;
    }

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
