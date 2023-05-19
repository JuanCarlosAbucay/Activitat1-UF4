package com.balmes.repository;

import com.balmes.model.Curs;
import com.balmes.model.Estudiant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Repository
public class estudiantRepository implements crudRepository<Estudiant>{
    List<Estudiant> cursos = new ArrayList<Estudiant>();
    List<Estudiant> estudiants = new ArrayList<Estudiant>();

    public estudiantRepository(){

        Curs accesADades = new Curs(1, "Modul 6","Acces a dades",
                "https://ioc.xtec.cat/materials/FP/Recursos/fp_dam_m06_/web/fp_dam_m06_htmlindex/index.html");
        Estudiant juanCarlos = new Estudiant(1, "Juan Carlos", "Abucay", accesADades);

        Estudiant jayZ = new Estudiant(2, "JAY", "Z", accesADades);

        cursos.add(juanCarlos);
        cursos.add(jayZ);
    }
    @Override
    public List<Estudiant> findAll() {
        return cursos;
    }

    @Override
    public List<Estudiant> getEstudiantsPerCurs(int CursId) {
        for (Estudiant estudiant : cursos){
            if (estudiant.getCurs().getCursId() == CursId){
                estudiants.add(estudiant);
            }
        }
        return estudiants;
    }
}
