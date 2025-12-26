package com.crudapplication.sm.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crudapplication.sm.api.Student;
import com.crudapplication.sm.rowmapper.StudentRowMapper;


@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	JdbcTemplate JdbcTemplate;

	@Override
	public List<Student> LoadStudents() {
		String sql="SELECT * FROM college.students";
		 List<Student> studentList=JdbcTemplate.query(sql, new StudentRowMapper());
		return studentList;
	}

	@Override
	public void SaveStudent(Student student) {
		// TODO Auto-generated method stub
		Object[] args= {student.getName(),student.getMobile(),student.getCountry()};
		String sql="insert into students(name,mobile,country) values(?,?,?)";
		JdbcTemplate.update(sql,args);
		System.out.println("1 record is installed...");
		
	}

	@Override
	public Student getStudentbyID(int id) {
		String sql="SELECT * FROM college.students WHERE id=?";
		Student student=JdbcTemplate.queryForObject(sql, new StudentRowMapper(),id);
		return student;
	}

	@Override
	public void UpdateStudent(Student student) {
	
		String sql = "UPDATE STUDENTS SET name=?, mobile=?, country=? WHERE id=?";
		JdbcTemplate.update(sql, student.getName(), student.getMobile(), student.getCountry(),student.getId());
		System.out.println("1 record is Updated...");
		
	}

	@Override
	public void DeleteStudent(int id) {
		String sql = "DELETE FROM STUDENTS WHERE id=?";
		JdbcTemplate.update(sql, id);
		System.out.println("delete in student dao delete");
		
	}

	
	

	
}
