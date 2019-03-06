package az.senan.studentservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity(name="student")
@Table(name="student_details")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int id;
	
	@Column(name="student_name")
	@NotNull
	private String name;
	
	@Column(name="student_surname")
	@NotNull
	private String surname;
	
	@Column(name="student_mail")
	@NotNull
	@Email
	private String mail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Student(String name, String surname, String mail) {
		this.name = name;
		this.surname = surname;
		this.mail = mail;
	}

	public Student() {
		
	}
	
	
	
}
