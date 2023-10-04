package pe.edu.vallegrande.app.model;

import lombok.Data;

@Data
public class Teacher {
	int id;
	String name;
	String last_name;
	String document_type;
	String document_number;
	String address;
	String district;
	String birthdate;
	String cell_phone;
	String email;
	String status;
}
