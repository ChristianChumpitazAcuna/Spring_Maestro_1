package pe.edu.vallegrande.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.vallegrande.app.model.Teacher;
import pe.edu.vallegrande.app.repository.ICrudRepository;

@Service
public class TeacherService implements IService<Teacher>{
	
	@Autowired
	private ICrudRepository<Teacher> iCrudRepository;
	
	@Override
	public List<Teacher> getAll() {
		List<Teacher> list;
		try {
			list = iCrudRepository.getAll();
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}

	@Override
	public int insert(Teacher teacher) {
		int row;
		try {
			row = iCrudRepository.insert(teacher);
		} catch (Exception ex) {
			throw ex;
		}
		return row;
	}

	@Override
	public int update(Teacher teacher) {
		int row;
		try {
			row = iCrudRepository.update(teacher);
		} catch (Exception ex) {
			throw ex;
		}
		return row;
	}

	@Override
	public int deleteByStatus(int id) {
		int row;
		try {
			row = iCrudRepository.deleteByStatus(id);
		} catch (Exception ex) {
			throw ex;
		}
		return row;
	}

	@Override
	public List<Teacher> filter(Teacher Bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> getAllInactives() {
		List<Teacher> list;
		try {
			list = iCrudRepository.getAllInactives();
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}

	@Override
	public int ReactivateByStatus(int id) {
		int row;
		try {
			row = iCrudRepository.ReactivateByStatus(id);
		} catch (Exception ex) {
			throw ex;
		}
		return row;
	}

}
