package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.IuserRepo;
import com.example.demo.model.usermodel;


@Repository
public class userRepo implements IuserRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public usermodel insertUser(usermodel user) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_user(" 
			+ "email, "
			+ "nama, "
			+ "password) "
			+ "VALUES(?, ?, ?)";
		jdbcTemplate.update(query, new Object[] {user.getEmail(),
				user.getNama(),
				user.getPassword()});
		return user;
	}

	@Override
	public List<usermodel> getAlluser() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_user ";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(usermodel.class));
	}

	@Override
	public usermodel updateUser(long id, usermodel user) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_user SET " 
				+ "email = ?, "
				+ "nama = ?, "
				+ "password = ? "
				+ "WHERE id = ?";
			jdbcTemplate.update(query, new Object[] {
					user.getEmail(),
					user.getNama(),
					user.getPassword(), id});
			return user;
	}

	@Override
	public usermodel deleteUser(long id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_user WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(usermodel.class), id);
		
		query = "DELETE FROM tb_user WHERE id = ?";
		jdbcTemplate.update(query, id);
		
		return result;
	}

	@Override
	public usermodel login(usermodel user) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_user WHERE email = ? AND password = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(usermodel.class), new Object[] {
				user.getEmail(), user.getPassword()
		});
		return result;
	}
	



}
