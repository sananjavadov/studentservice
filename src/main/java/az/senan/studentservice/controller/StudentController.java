package az.senan.studentservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.senan.studentservice.entity.Student;
import az.senan.studentservice.exception.ExceptionResponse;
import az.senan.studentservice.exception.StudentException;
import az.senan.studentservice.service.StudentService;

@RestController
@RequestMapping(path="/student")
public class StudentController {

	@Autowired
	StudentService service;
	
	@GetMapping
	public ResponseEntity<List<Student>> getAll() throws StudentException {
		List<Student> all=service.getAll();
		if (all.size()>0) {
			return new ResponseEntity<List<Student>>(all,HttpStatus.OK);
		}
		throw new StudentException("Students not found");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getId(@PathVariable("id") int id) throws StudentException {
		Student student=service.getId(id);
		if (student!=null) {
			return new ResponseEntity<Student>(student,HttpStatus.OK);			
		}
		throw new StudentException("Student not found");
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<Student> save(@RequestBody @Valid Student student, BindingResult b) throws StudentException {
		if(!b.hasErrors()) {
			return new ResponseEntity<Student>(service.save(student), HttpStatus.CREATED);
		}		
		throw new StudentException("Unsupported data!");
	}
	
	@PostMapping(path="/{id}", consumes="application/json")
	public ResponseEntity<Student> update(@RequestBody Student s, @PathVariable("id") int id) throws StudentException {			
		Student student=service.getId(id);		
		if(student!=null) {			
			if (s.getName()!=null) {
				student.setName(s.getName());
			}
			if (s.getSurname()!=null) {
				student.setSurname(s.getSurname());
			}
			if (s.getMail()!=null) {
				student.setMail(s.getMail());
			}			
			return new ResponseEntity<Student>(service.save(student),HttpStatus.ACCEPTED);
		}
		throw new StudentException("Student not found");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") int id) throws StudentException {
		Student student=service.getId(id);
		if (student!=null) {
			service.delete(student);
			return new ResponseEntity<Object>(new ExceptionResponse("Deleted!"),HttpStatus.OK);
		}
		throw new StudentException("Student not found");
	}
			
}
