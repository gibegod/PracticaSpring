package com.practicaspring.services;

import java.util.List;

import com.practicaspring.entities.Degree;
import com.practicaspring.models.DegreeModel;

//Firma de los metodos que interactuan con el repositorio.

public interface IDegreeService {
	
	public List<Degree> getAll();
	
	public DegreeModel insertOrUpdate(DegreeModel degreeModel);
	
	public boolean remove(int id);
}
