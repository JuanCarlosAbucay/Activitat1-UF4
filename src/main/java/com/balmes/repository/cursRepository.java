package com.balmes.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.balmes.model.Curs;

@Repository
public class cursRepository implements crudRepository<Curs> {
	private final List<Curs> cursos = new ArrayList<Curs>();

	public cursRepository() {
		Curs accesADades = new Curs(1, "Modul 6","Acces a dades",
				"https://ioc.xtec.cat/materials/FP/Recursos/fp_dam_m06_/web/fp_dam_m06_htmlindex/index.html&quot");

		Curs programacioMultimedia = new Curs(2, "Modul 8","Programacio Multimedia",
				"https://ioc.xtec.cat/materials/FP/Recursos/fp_dam_m08_/web/fp_dam_m08_htmlindex/index.html&quot");
		cursos.add(accesADades);
		cursos.add(programacioMultimedia);
	}

	public List<Curs> findAll() {
		return cursos;
	}

	@Override
	public List<Curs> getEstudiantsPerCurs(int CursId) {
		return null;
	}
}