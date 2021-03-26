package dev.shintani.demo.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.shintani.demo.controllers.BooksController;
import dev.shintani.demo.entities.Book;
import dev.shintani.demo.services.BookService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookRequestTests {

    private MockMvc mockMvc;

    @Autowired
    private BooksController booksController;

    @Autowired
    private BookService bookService;

    @BeforeAll
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(booksController).build();
    }

    @Test
    public void index() {
        for (int i = 0; i < 5; i++) {
            bookService.createBook("テスト", "テスト");
        }

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/books")).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void show() {
        Book book = bookService.createBook("テスト", "テスト");
        Long bookId = book.getId();

        try {
            mockMvc.perform(MockMvcRequestBuilders.get(String.format("/books/%d", bookId))).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create() {
        Book book = new Book();
        book.setName("テスト");
        book.setIsbn("テスト");

        String bookJson = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            bookJson = objectMapper.writeValueAsString(book);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/books").contentType(MediaType.APPLICATION_JSON).content(bookJson)).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() {
        Book book = bookService.createBook("テスト", "テスト");
        Long bookId = book.getId();

        Book newBook = new Book();
        book.setName("テスト2");
        book.setIsbn("テスト2");

        String bookJson = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            bookJson = objectMapper.writeValueAsString(newBook);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            mockMvc.perform(MockMvcRequestBuilders.put(String.format("/books/%d", bookId)).contentType(MediaType.APPLICATION_JSON).content(bookJson)).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete2() {
        Book book = bookService.createBook("テスト", "テスト");
        Long bookId = book.getId();

        try {
            mockMvc.perform(MockMvcRequestBuilders.delete(String.format("/books/%d", bookId))).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
