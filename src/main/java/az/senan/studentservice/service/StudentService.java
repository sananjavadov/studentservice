package az.senan.studentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import az.senan.studentservice.entity.Student;
import az.senan.studentservice.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	StudentRepository repository;
	
	public Student save(Student s) {
		return repository.save(s);
	}
	
	public Student getId(int id) {
		return repository.findById(id);
	}
	
	public void delete(Student s) {
		repository.delete(s);
	}
	
	public List<Student> getAll(){
		return repository.findAll();
	}
	
	public void deleteByEntity(Student s) {
		repository.delete(s);
	}
	
	
}
