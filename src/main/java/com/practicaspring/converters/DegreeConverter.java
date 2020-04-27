package com.practicaspring.converters;

import org.springframework.stereotype.Component;

import com.practicaspring.entities.Degree;
import com.practicaspring.models.DegreeModel;

//Transforma modelos en entidades y entidades en modelos.

@Component("degreeConverter")
public class DegreeConverter {
	
	public DegreeModel entityToModel(Degree degree) {
		return new DegreeModel(degree.getId(), degree.getName(), degree.getInstitution(), degree.getYear());
	}
	
	public Degree modelToEntity(DegreeModel degreeModel) {
		return new Degree(degreeModel.getId(), degreeModel.getName(), degreeModel.getInstitution(), degreeModel.getYear());
	}
}
