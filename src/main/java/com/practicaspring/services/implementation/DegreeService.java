package com.practicaspring.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.practicaspring.converters.DegreeConverter;
import com.practicaspring.entities.Degree;
import com.practicaspring.models.DegreeModel;
import com.practicaspring.repositories.IDegreeRepository;
import com.practicaspring.services.IDegreeService;

//Implementacion IDegreeService
//Conectar Repository con Controllers

@Service("degreeService")
public class DegreeService implements IDegreeService {
	
	//Autowired y qualifier se usan para inyectar un obj en una clase.
	@Autowired
	@Qualifier("degreeRepository")
	private IDegreeRepository degreeRepository;
	
	@Autowired
	@Qualifier("degreeConverter")
	private DegreeConverter degreeConverter;
	
	@Override
	public List<Degree> getAll() {
		return degreeRepository.findAll();
	}
	
	@Override
	public DegreeModel insertOrUpdate(DegreeModel degreeModel) {
		Degree degree = degreeRepository.save(degreeConverter.modelToEntity(degreeModel));
		return degreeConverter.entityToModel(degree);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			degreeRepository.deleteById(id); //delete(id)
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	
}











