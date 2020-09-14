package com.spring.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.domain.Admin;

public class AdminDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void insert(Admin admin) {
		String sql = "insert into admin values('"+admin.getUserName()+"','"+admin.getPassword()+"')";
		jdbcTemplate.update(sql);
	}
	public Admin checkUserPresent(Admin admin) {
		String sql = "select * from admin where userName=? and password=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{admin.getUserName(),admin.getPassword()},new BeanPropertyRowMapper<Admin>(Admin.class));
	}
}
