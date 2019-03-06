package az.senan.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.senan.studentservice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findById(int id);
}
