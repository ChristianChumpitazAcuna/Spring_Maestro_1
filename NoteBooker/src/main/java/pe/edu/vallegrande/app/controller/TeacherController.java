package pe.edu.vallegrande.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.vallegrande.app.model.ServiceResponse;
import pe.edu.vallegrande.app.model.Teacher;
import pe.edu.vallegrande.app.service.IService;

@RestController
@RequestMapping("NoteBooker")
@CrossOrigin("*")
public class TeacherController {
	
	@Autowired
	private IService<Teacher> iService;
	
	@GetMapping("/listActive")
	public ResponseEntity<List<Teacher>> listActive(){
		var result = iService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}	
	
	@PostMapping("/insert")
	public ResponseEntity<ServiceResponse> insert(@RequestBody Teacher teacher){
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iService.insert(teacher);
		if (result == 1) {
			serviceResponse.setMesssage("Registro Insertado");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ServiceResponse> update(@RequestBody Teacher teacher){
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iService.update(teacher);
		if (result == 1) {
			serviceResponse.setMesssage("Registro Actualizado");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iService.deleteByStatus(id);
		if (result == 1) {
			serviceResponse.setMesssage("Registro Eliminado");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@GetMapping("/listInactives")
	public ResponseEntity<List<Teacher>> listInactive(){
		var result = iService.getAllInactives();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/reactivate/{id}")
	public ResponseEntity<ServiceResponse> reactivate(@PathVariable int id){
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iService.ReactivateByStatus(id);
		if (result == 1) {
			serviceResponse.setMesssage("Registro Reactivado");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}

}
