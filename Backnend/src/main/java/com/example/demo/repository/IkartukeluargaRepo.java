package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.kartukeluargamodel;

public interface IkartukeluargaRepo {
	public kartukeluargamodel insertKartukeluarga( kartukeluargamodel kartukeluarga);
	public List<kartukeluargamodel> getAllkartu();
	public kartukeluargamodel updateKartu (long id, kartukeluargamodel kartukeluarga);
	public kartukeluargamodel deleteKartu (long id);
	public kartukeluargamodel getKartuById (long id);
}
