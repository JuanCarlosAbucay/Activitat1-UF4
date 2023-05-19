package com.balmes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.balmes.repository.estudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.balmes.model.Curs;
import com.balmes.repository.cursRepository;
import org.springframework.stereotype.Service;

@Service
public class cursService implements crudService<Curs> {
	@Autowired
	private cursRepository repositori;

	@Autowired
	private estudiantRepository estudiantRepository;


	public cursService(cursRepository cursRepository) {
		repositori = cursRepository;
	}
	
	public List<Curs> list() {
		List<Curs> listaCursos = repositori.findAll();
		for (Curs curs : listaCursos) {
			curs.setEstudiants(estudiantRepository.getEstudiantsPerCurs(curs.getCursId()));
		}
		return listaCursos;
	}
}