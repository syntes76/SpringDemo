package com.syntes;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/student")

public class StudentService {
		@RequestMapping(value = "/add", method ={RequestMethod.GET, RequestMethod.POST})
		public Student addStudent(@RequestParam(value ="name") String name, @RequestParam(value ="subject") String subject) {
		Student student = new Student(name, subject);
		
		Application.hmStudent.put(new Long(student.getId()), student);
		return student;
	}

	
	 @RequestMapping(value = "/", method =RequestMethod.GET)
	 public HashMap<Long,Student> getAllStudents(){ return
	 Application.hmStudent; }
	 
	 @RequestMapping(value="/update",method = {RequestMethod.GET,RequestMethod.PUT})
	 	
	 	public Student updateStudent(@RequestBody Student student) throws Exception {

	    if(Application.hmStudent.containsKey(new Long(student.getId()))){
	       Application.hmStudent.put(new Long(student.getId()),student);
	    }else{
	       throw new Exception("Student "+student.getId()+" does not exists");
	    }

	    return student;
	 }
	 

}
