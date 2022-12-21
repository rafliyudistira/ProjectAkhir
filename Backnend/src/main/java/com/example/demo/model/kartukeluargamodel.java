package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_kartu_keluarga")
public class kartukeluargamodel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String alamat;
	private String desa_kelurahan;
	private String kabupaten_kota;
	private String kecamatan;
	private long kode_pos;
	private long nomor_kk;
	private String provinsi;
	private long rt;
	private long rw;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getDesa_kelurahan() {
		return desa_kelurahan;
	}
	public void setDesa_kelurahan(String desa_kelurahan) {
		this.desa_kelurahan = desa_kelurahan;
	}
	public String getKabupaten_kota() {
		return kabupaten_kota;
	}
	public void setKabupaten_kota(String kabupaten_kota) {
		this.kabupaten_kota = kabupaten_kota;
	}
	public String getKecamatan() {
		return kecamatan;
	}
	public void setKecamatan(String kecamatan) {
		this.kecamatan = kecamatan;
	}
	public long getKode_pos() {
		return kode_pos;
	}
	public void setKode_pos(long kode_pos) {
		this.kode_pos = kode_pos;
	}
	public long getNomor_kk() {
		return nomor_kk;
	}
	public void setNomor_kk(long nomor_kk) {
		this.nomor_kk = nomor_kk;
	}
	public String getProvinsi() {
		return provinsi;
	}
	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}
	public long getRt() {
		return rt;
	}
	public void setRt(long rt) {
		this.rt = rt;
	}
	public long getRw() {
		return rw;
	}
	public void setRw(long rw) {
		this.rw = rw;
	}
	
	

}
