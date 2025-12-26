package com.crudapplication.sm.Service;

import java.util.List;

import com.crudapplication.sm.api.Student;

public interface StudentService {
	List<Student> LoadStudents();
	void SaveStudent(Student student);
	Student getStudentbyID(int id);
	void UpdateStudent(Student student);
	void DeleteStudent(int id);

}
