package com.crudapplication.sm.DAO;

import java.util.List;

import com.crudapplication.sm.api.Student;

public interface StudentDAO {
	
	List<Student> LoadStudents();
	void SaveStudent(Student student);
	Student getStudentbyID(int id);
	void UpdateStudent(Student student);
	void DeleteStudent(int id);

}
