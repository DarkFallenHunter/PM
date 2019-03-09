package ivbo02153.demo.controller;

import ivbo02153.demo.dao.StudentJdbc;
import ivbo02153.demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private final StudentJdbc studentJdbc;

    public StudentController(StudentJdbc markJdbc) {
        this.studentJdbc = markJdbc;
    }

    @GetMapping("/student/id={id}")
    public Student getStudent(@PathVariable int id) {
        return studentJdbc.get(id);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentJdbc.getAll();
    }

    @GetMapping("/students/group={group}")
    public List<Student> getStudentsByGroup(@PathVariable String group) {
        return studentJdbc.getByGroup(group);
    }

    @GetMapping("/student/add/id={id}&surname={surname}&name={name}&second_name={second_name}&study_group={study_group}")
    public int addStudent(@PathVariable int id, @PathVariable String surname, @PathVariable String name,
                             @PathVariable String second_name, @PathVariable String study_group
    ) {
        return studentJdbc.add(id, surname, name, second_name, study_group);
    }

    @GetMapping("/student/delete/id={id}")
    public int deleteStudent(@PathVariable int id) {
        return studentJdbc.delete(id);
    }

    @GetMapping("/student/set/id={id}&surname={surname}")
    public int updateSurname(@PathVariable int id, @PathVariable String surname) {
        return studentJdbc.setSurname(id, surname);
    }

    @GetMapping("/student/set/id={id}&name={name}")
    public int updateName(@PathVariable int id, @PathVariable String name) {
        return studentJdbc.setName(id, name);
    }

    @GetMapping("/student/set/id={id}&second_name={secondName}")
    public int updateSecondName(@PathVariable int id, @PathVariable String secondName) {
        return studentJdbc.setSecondName(id, secondName);
    }

    @GetMapping("/student/set/id={id}&study_group_id={studyGroupId}")
    public int updateStudyGroupId(@PathVariable int id, @PathVariable int studyGroupId) {
        return studentJdbc.setStudyGroupId(id, studyGroupId);
    }
}
