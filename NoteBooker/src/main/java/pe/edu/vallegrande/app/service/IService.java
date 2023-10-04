package pe.edu.vallegrande.app.service;

import java.util.List;

public interface IService<T> {
	public List<T> getAll();

	public int insert(T bean);

	public int update(T Bean);

	public List<T> filter(T Bean);

	public List<T> getAllInactives();

	public int deleteByStatus(int id);

	public int ReactivateByStatus(int id);

}
