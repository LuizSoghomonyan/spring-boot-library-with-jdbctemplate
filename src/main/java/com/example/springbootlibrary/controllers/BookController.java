package com.example.springbootlibrary.controllers;

import com.example.springbootlibrary.dao.BookDAO;
import com.example.springbootlibrary.model.Book;
import com.example.springbootlibrary.model.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@Component
@RequestMapping("/books")
public class BookController {
    private final BookDAO bookDAO;
    @Autowired
    public BookController(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String getBooks(Model model){
        model.addAttribute("books", this.bookDAO.getBooks());
        return "book/all-books";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookDAO.getBookById(id));
        return "book/book-by-id";
    }
    @GetMapping("/{id}/edit")
    public String getEditBookById(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookDAO.getBookById(id));
        return "book/book-edit";
    }
    @PutMapping("/{id}/edit")
    public String updateBookById(@ModelAttribute("book") @Valid Book book,
                                 BindingResult bindingResult,
                                 Model model){
        if(bindingResult.hasErrors())
            return "book/book-edit";
        this.bookDAO.updateBookById(book);
        return "redirect:/books";
    }
}
