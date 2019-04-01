package ivbo02153.demo.dao;

import ivbo02153.demo.model.Mark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MarkJdbc {

    private final JdbcTemplate jdbcTemplate;

    public MarkJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Mark get(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM mark WHERE id = ?", this::mapMark, id);
    }

    private Mark mapMark(ResultSet rs, int i ) throws SQLException {
        Mark mark = new Mark(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("value")
        );

        return mark;
    }

    public Mark search(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM MARK WHERE NAME = ?", this::mapMark, name);
    }
}
