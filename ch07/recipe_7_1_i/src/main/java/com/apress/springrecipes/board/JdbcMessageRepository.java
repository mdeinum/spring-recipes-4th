package com.apress.springrecipes.board;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
class JdbcMessageRepository implements MessageRepository {

    private final JdbcTemplate jdbc;

    public JdbcMessageRepository(DataSource dataSource) {
        this.jdbc=new JdbcTemplate(dataSource);
    }


    @Override
    public List<Message> findAll() {
        return this.jdbc.query("select * from message order by id", BeanPropertyRowMapper.newInstance(Message.class));
    }

    @Override
    public List<Message> findByAuthor(String author) {
        return this.jdbc.query("select * from message where author=? order by id", BeanPropertyRowMapper.newInstance(Message.class), author);
    }

    @Override
    public Message findOne(long id) {
        return this.jdbc.queryForObject("select * from message where id=?", BeanPropertyRowMapper.newInstance(Message.class), id);
    }

    @Override
    public Message save(Message message) {

        final String sql = "insert into message (author, title, body) values (?,?,?)";
        final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        this.jdbc.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[] {"id"});
            ps.setString(1, message.getAuthor());
            ps.setString(2, message.getTitle());
            ps.setString(3, message.getBody());
            return ps;
        }, keyHolder );

        message.setId(keyHolder.getKey().longValue());
        return message;
    }

    @Override
    public void remove(long id) {
        this.jdbc.update("delete from message where id=?", id);
    }
}
