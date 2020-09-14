package com.spring.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.domain.Student;

public class StudentDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void insert(Student student) {
		String sql = "insert into student values('"+student.getName()+"','"+student.getPlace()+"','"+student.getDept()+"')";
		
		jdbcTemplate.update(sql);
		
	}
	public void delete(String name) {
		String sql = "delete from student where name='"+name+"'";
		jdbcTemplate.update(sql);
	}
	public Student getStudentByName(String name) {
		String sql = "select * from student where name=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {name},new BeanPropertyRowMapper<Student>(Student.class));
	}
	public void update(Student student) {
		String sql = "update student set place= ? ,dept= ? where name=?";
		int status = jdbcTemplate.update(sql,student.getPlace(),student.getDept(),student.getName());
		if(status != 0) {
			System.out.println(student.getName()+" details have been updated.");
		}
		else {
			System.out.println("No records found with name "+student.getName());
		}
	}
	public List<Student> getList() {
		return jdbcTemplate.query("select name,place,dept from student",new RowMapper<Student>() {
			public Student mapRow(ResultSet rs,int row) throws SQLException {
				Student s = new Student();
				s.setName(rs.getString(1));
				s.setPlace(rs.getString(2));
				s.setDept(rs.getString(3));
				return s;
			}
		});
	}
	public List<Student> getAttendanceList() {
		return jdbcTemplate.query("select name,D1,D2,D3,D4,D5,D6,D7 from student",new RowMapper<Student>() {
			public Student mapRow(ResultSet rs,int row) throws SQLException {
				Student s = new Student();
				s.setName(rs.getString(1));
				s.setD1(rs.getString(2));
				s.setD2(rs.getString(3));
				s.setD3(rs.getString(4));
				s.setD4(rs.getString(5));
				s.setD5(rs.getString(6));
				s.setD6(rs.getString(7));
				s.setD7(rs.getString(8));
				return s;
			}
		});
	}
	
	public Integer attendanceUpdate(Student student) {
		String sql = "update student set d1=?,d2=?,d3=?,d4=?,d5=?,d6=?,d7=? where name=?";
		Integer rows = jdbcTemplate.update(sql,student.getD1(),student.getD2(),student.getD3(),student.getD4(),student.getD5(),student.getD6(),student.getD7(),student.getName());
		return rows;
		
	}
}
