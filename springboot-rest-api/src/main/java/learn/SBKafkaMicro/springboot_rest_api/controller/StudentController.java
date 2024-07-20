package learn.SBKafkaMicro.springboot_rest_api.controller;

import learn.SBKafkaMicro.springboot_rest_api.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){

        Student student = new Student();
        student.setLastName("Babu");
        student.setId(3);
        student.setFirstName("Ramesh");
        return student;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Ramesh", "Babu"));
        students.add(new Student(2, "Rahul", "Babu"));
        students.add(new Student(3, "Raju", "Babu"));
        students.add(new Student(4, "Rani", "Babu"));
        students.add(new Student(5, "Raj", "Babu"));

        return students;
    }

    @GetMapping("/student/{id}")
    public Student studentPathVariable(@PathVariable int id){
        return new Student(id, "Ramesh", "Babu");
    }
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getFirstName());
        System.out.println(student.getId());
        System.out.println(student.getLastName());
        return student;
    }

//    @PutMapping("/student/{id}/update")
//    public Student updateStudent(@RequestBody Student student,@PathVariable int id){
//    ////
//    }

}
