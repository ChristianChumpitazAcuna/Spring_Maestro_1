package pe.edu.vallegrande.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.edu.vallegrande.app.model.Teacher;

@Repository
public class TeacherRepository implements ICrudRepository<Teacher> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Teacher> getAll() {
		String sql = "SELECT * FROM teacher WHERE status='A'";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Teacher.class));
	}

	@Override
	public int insert(Teacher teacher) {
		String sql = "INSERT INTO teacher (name, last_name, document_type, document_number, address, district, birthdate, cell_phone, email) "
				+ "VALUES(?,?,?,?,?,?,TO_DATE(?, 'YYYY-MM-DD'),?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { teacher.getName(), teacher.getLast_name(), teacher.getDocument_type(),
						teacher.getDocument_number(), teacher.getAddress(), teacher.getDistrict(),
						teacher.getBirthdate(), teacher.getCell_phone(), teacher.getEmail() });
	}

	@Override
	public int update(Teacher teacher) {
		String sql = "UPDATE teacher SET name=?, last_name=?, document_type=?, document_number=?, address=?,"
				+ " district=?, birthdate=TO_DATE(?, 'YYYY-MM-DD'), cell_phone=?, email=? WHERE id=?";
		return jdbcTemplate.update(sql,
				new Object[] { teacher.getName(), teacher.getLast_name(), teacher.getDocument_type(),
						teacher.getDocument_number(), teacher.getAddress(), teacher.getDistrict(),
						teacher.getBirthdate(), teacher.getCell_phone(), teacher.getEmail(), teacher.getId() });
	}

	@Override
	public List<Teacher> filter(Teacher Bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> getAllInactives() {
		String sql = "SELECT * FROM teacher WHERE status='I'";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Teacher.class));
	}

	@Override
	public int deleteByStatus(int id) {
		String sql = "UPDATE teacher SET status='I' WHERE id=?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}

	@Override
	public int ReactivateByStatus(int id) {
		String sql = "UPDATE teacher SET status='A' WHERE id=?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}

}
