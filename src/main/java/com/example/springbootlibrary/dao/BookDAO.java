package com.example.springbootlibrary.dao;

import com.example.springbootlibrary.model.Book;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooks() {
        return this.jdbcTemplate.query("select* from book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book getBookById(int id) {
        return this.jdbcTemplate.query(
                        "select* from book where id = ?",
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }


    public void updateBookById(Book book){
        this.jdbcTemplate.update("UPDATE book SET name = ?, author = ?, year = ? WHERE id = ?",
                book.getName(),book.getAuthor(), book.getYear(), book.getId());
    }
}
