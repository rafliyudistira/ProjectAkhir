package com.example.demo.repository.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.kartukeluargamodel;
import com.example.demo.repository.IkartukeluargaRepo;

@Repository
public class kartukeluargaRepo implements IkartukeluargaRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public kartukeluargamodel insertKartukeluarga(kartukeluargamodel kartukeluarga) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_kartu_keluarga(" 
				+ "alamat, "
				+ "desa_kelurahan, "
				+ "kabupaten_kota, "
				+ "kecamatan, "
				+ "kode_pos, "
				+ "nomor_kk, "
				+ "provinsi, "
				+ "rt, "
				+ "rw) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, new Object[] {
			kartukeluarga.getAlamat(),
			kartukeluarga.getDesa_kelurahan(),
			kartukeluarga.getKabupaten_kota(),
			kartukeluarga.getKecamatan(),
			kartukeluarga.getKode_pos(),
			kartukeluarga.getNomor_kk(),
			kartukeluarga.getProvinsi(),
			kartukeluarga.getRt(),
			kartukeluarga.getRw(),
		});
		return kartukeluarga;
	}


	@Override
	public List<kartukeluargamodel> getAllkartu() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_kartu_keluarga";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(kartukeluargamodel.class));
	}


	@Override
	public kartukeluargamodel updateKartu(long id, kartukeluargamodel kartukeluarga) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_kartu_keluarga SET " 
				+ "alamat = ? , "
				+ "desa_kelurahan = ?, "
				+ "kabupaten_kota = ?, "
				+ "kecamatan = ?, "
				+ "kode_pos = ?, "
				+ "nomor_kk = ?, "
				+ "provinsi = ?, "
				+ "rt = ?, "
				+ "rw = ? "
				+ "WHERE id = ?";
		jdbcTemplate.update(query, new Object[] {
			kartukeluarga.getAlamat(),
			kartukeluarga.getDesa_kelurahan(),
			kartukeluarga.getKabupaten_kota(),
			kartukeluarga.getKecamatan(),
			kartukeluarga.getKode_pos(),
			kartukeluarga.getNomor_kk(),
			kartukeluarga.getProvinsi(),
			kartukeluarga.getRt(),
			kartukeluarga.getRw(), id});
		return kartukeluarga;
	}


	@Override
	public kartukeluargamodel deleteKartu(long id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(kartukeluargamodel.class), id);
		
		query = "DELETE FROM tb_kartu_keluarga WHERE id = ?";
		jdbcTemplate.update(query, id);
		return result;
	}


	@Override
	public kartukeluargamodel getKartuById(long id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(kartukeluargamodel.class), id);
	}

}
