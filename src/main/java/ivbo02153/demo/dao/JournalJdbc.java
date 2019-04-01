package ivbo02153.demo.dao;

import ivbo02153.demo.model.Journal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JournalJdbc {

    private final JdbcTemplate jdbcTemplate;

    public JournalJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Journal> getAll() {
        return jdbcTemplate.query("SELECT * FROM JOURNAL", this::mapJournal);
    }

    public List<Journal> getAllByStudentId(int studentId) {
        return jdbcTemplate.query("SELECT * FROM JOURNAL WHERE STUDENT_ID = ?", this::mapJournal, studentId);
    }

    public List<Journal> getAllByGroup(String group) {
        return jdbcTemplate.query("SELECT JOURNAL.* FROM JOURNAL INNER JOIN STUDENT ON JOURNAL.STUDENT_ID = STUDENT.ID " +
                "INNER JOIN STUDY_GROUP ON STUDENT.STUDY_GROUP_ID = STUDY_GROUP.ID WHERE STUDY_GROUP.NAME=?", this::mapJournal, group);
    }

    public int add(int id, int studentId, int studyPlanId, boolean inTime, int count, int markId) {
        return jdbcTemplate.update("INSERT INTO JOURNAL VALUES ( ?, ?, ?, ?, ?, ? )", id, studentId, studyPlanId, inTime, count, markId);
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM JOURNAL WHERE ID=?", id);
    }

    public int setStudentId(int id, int studentId) {
        return jdbcTemplate.update("UPDATE JOURNAL SET STUDENT_ID=? WHERE ID=?", studentId, id);
    }

    public int setStudyPlanId(int id, int studyPlanId) {
        return jdbcTemplate.update("UPDATE JOURNAL SET STUDY_PLAN_ID=? WHERE ID=?", studyPlanId, id);
    }

    public int setInTime(int id, boolean inTime) {
        return jdbcTemplate.update("UPDATE JOURNAL SET IN_TIME=? WHERE ID=?", inTime, id);
    }

    public int setCount(int id, int count) {
        return jdbcTemplate.update("UPDATE JOURNAL SET COUNT=? WHERE ID=?", count, id);
    }

    public int setMarkId(int id, int markId) {
        return jdbcTemplate.update("UPDATE JOURNAL SET MARK_ID=? WHERE ID=?", markId, id);
    }

    private Journal mapJournal(ResultSet rs, int i ) throws SQLException {
        Journal group = new Journal(
                rs.getInt("id"),
                rs.getInt("student_id"),
                rs.getInt("study_plan_id"),
                rs.getBoolean("in_time"),
                rs.getInt("count"),
                rs.getInt("mark_id")
        );

        return group;
    }
}
