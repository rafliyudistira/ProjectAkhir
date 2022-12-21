package com.example.demo.service;

import java.util.List;

import com.example.demo.model.kartukeluargamodel;
public interface IkartukeluargaService {
	public kartukeluargamodel insertKartukeluarga( kartukeluargamodel kartukeluarga);
	public List<kartukeluargamodel> getAllkartu();
	public kartukeluargamodel updateKartu (long id, kartukeluargamodel kartukeluarga);
	public kartukeluargamodel deleteKartu (long id);
	public kartukeluargamodel getKartuById (long id);
}
