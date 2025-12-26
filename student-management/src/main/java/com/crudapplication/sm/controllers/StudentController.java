package com.crudapplication.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crudapplication.sm.DAO.StudentDAO;

import javax.sql.DataSource;
import com.crudapplication.sm.Service.StudentService;
import com.crudapplication.sm.api.Student;
import com.crudapplication.sm.api.StudentDto;

@Controller
public class StudentController {

    private final DataSource dataSource;
	
	
	@Autowired
	private StudentService StudentServiceImpl;

    StudentController(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	
	@GetMapping("/showStudent")
	public String showStudent(Model model)
	{
		List<Student> student_list=StudentServiceImpl.LoadStudents();
		
		model.addAttribute("Student", student_list);
		
		return "student-list";
	}
	
	@GetMapping("/showAddStudent")
	public String showAddStudent(Model model )
	{
		Student student=new Student();
		model.addAttribute("student",student);
		return "add-student";
	}
	
	
	@PostMapping("/SaveStudent")
	public String SaveStudent(Student student)
	{
		System.out.println("Inside the saveStudent"+student);
		if(student.getId()==0) {
			StudentServiceImpl.SaveStudent(student);
		}
		else
		{
			StudentServiceImpl.UpdateStudent(student);
		}
		
		//System.out.println(student);
		
		return "redirect:/showStudent";
	}
	
	
	@GetMapping("/UpdateStudent")
	public String UpdateStudent(@RequestParam("Userid")int id,Model model)
	{
		Student student=StudentServiceImpl.getStudentbyID(id);
		model.addAttribute("student",student);
		return "add-student";
	}
	
	@GetMapping("/DeleteStudent")
	public String DeleteStudent(@RequestParam("Userid")int id)
	{
		StudentServiceImpl.DeleteStudent(id);
		
		return "redirect:/showStudent";
	}
	
	

}
