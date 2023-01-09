package com.example.lab_example.web.controller;

import com.example.lab_example.service.AuthorService;
import com.example.lab_example.service.BookService;
import com.example.lab_example.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public BookController(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @GetMapping
    public String getPage(Model model){
        model.addAttribute("books", this.bookService.listAll());
        model.addAttribute("authors", this.authorService.listAll());
        model.addAttribute("countries", this.countryService.listAll());
        return "template";
    }
}
