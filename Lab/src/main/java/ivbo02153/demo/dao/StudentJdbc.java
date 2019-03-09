package ivbo02153.demo.dao;

import ivbo02153.demo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentJdbc {

    private final JdbcTemplate jdbcTemplate;

    public StudentJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Student get(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id = ?", this::mapStudent, id);
    }

    public List<Student> getAll() {
        return jdbcTemplate.query("SELECT * FROM student", this::mapStudent);
    }

    public List<Student> getByGroup(String group) {
        return jdbcTemplate.query("SELECT student.* FROM student INNER JOIN study_group ON student.study_group_id = study_group.id WHERE study_group.name = ?",
                this::mapStudent, group);
    }

    public int add(int id, String surname, String name, String second_name, String study_group_id) {
        return  jdbcTemplate.update("INSERT INTO STUDENT VALUES (?,  ?, ?, ?, ? )", id, surname, name, second_name, study_group_id);
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM STUDENT WHERE ID=?", id);
    }

    public int setSurname(int id, String surname) {
        return jdbcTemplate.update("UPDATE STUDENT SET SURNAME=? WHERE ID=?", surname, id);
    }

    public int setName(int id, String name) {
        return jdbcTemplate.update("UPDATE STUDENT SET NAME=? WHERE ID=?", name, id);
    }

    public int setSecondName(int id, String secondName) {
        return jdbcTemplate.update("UPDATE STUDENT SET SECOND_NAME=? WHERE ID=?", secondName, id);
    }

    public int setStudyGroupId(int id, int studyGroupId) {
        return jdbcTemplate.update("UPDATE STUDENT SET STUDY_GROUP_ID=? WHERE ID=?", studyGroupId, id);
    }

    private Student mapStudent(ResultSet rs, int i ) throws SQLException {
        Student student = new Student(
                rs.getInt("id"),
                rs.getString("surname"),
                rs.getString("name"),
                rs.getString("second_name"),
                rs.getInt("study_group_id")
        );

        return student;
    }
}