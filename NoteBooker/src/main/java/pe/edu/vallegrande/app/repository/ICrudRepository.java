package pe.edu.vallegrande.app.repository;

import java.util.List;

public interface ICrudRepository <T>{
	public List<T> getAll();

	public int insert(T bean);

	public int update(T Bean);
	
	public List<T> filter(T Bean);

	public List<T> getAllInactives();
	
	public int deleteByStatus(int id);
	
	public int ReactivateByStatus(int id);

}
