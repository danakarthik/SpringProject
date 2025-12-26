package com.crudapplication.sm.Service;

import java.util.ArrayList;
import java.util.List;
import com.crudapplication.sm.config.StudentAppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapplication.sm.DAO.StudentDAO;

import javax.sql.DataSource;
import com.crudapplication.sm.api.Student;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentAppConfig studentAppConfig;

    private final DataSource dataSource;

	@Autowired
	private StudentDAO studentDAOImpl;

    StudentServiceImpl(DataSource dataSource, StudentAppConfig studentAppConfig) {
        this.dataSource = dataSource;
        this.studentAppConfig = studentAppConfig;
    }
	@Override
	public List<Student> LoadStudents() {
		List<Student> student=studentDAOImpl.LoadStudents();
		
		return student;
	}

	@Override
	public void SaveStudent(Student student) {
		System.out.println("inside the service layer");
		
		if(student.getCountry()=="UK")
		{
			System.out.println("sending welcomne email to.."+student.getName());
		}
		// TODO Auto-generated method stub
		studentDAOImpl.SaveStudent(student);

	}
	@Override
	public Student getStudentbyID(int id) {
	
		return studentDAOImpl.getStudentbyID(id);
	}
	@Override
	public void UpdateStudent(Student student) {
		studentDAOImpl.UpdateStudent(student);
		
	}
	@Override
	public void DeleteStudent(int id) {
		// TODO Auto-generated method stub
		studentDAOImpl.DeleteStudent(id);
		
	}
	
	

}
