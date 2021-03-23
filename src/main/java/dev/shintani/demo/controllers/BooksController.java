package dev.shintani.demo.controllers;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import dev.shintani.demo.entities.Book;
import dev.shintani.demo.services.BookService;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    // 書籍情報一覧取得
    // GET /books
    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Book> index() {
      List<Book> bookList = bookService.getBookList();

      return bookList;
    }

    // 書籍情報詳細取得
    // GET /books/{id}
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Book show(@PathVariable("id") Long id) {
      Book book = bookService.getBook(id);

      return book;
    }

    // 書籍情報作成
    // POST /books
    @RequestMapping(method = RequestMethod.POST, value = "")
    public Book create(@RequestBody Book requestBody) {
      String name = requestBody.getName();
      String isbn = requestBody.getIsbn();

      Book book = bookService.createBook(name, isbn);

      return book;
    }

    // 書籍情報更新
    // PUT /books/{id}
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Book update(@PathVariable("id") Long id, @RequestBody Book requestBody) {
      String name = requestBody.getName();
      String isbn = requestBody.getIsbn();

      Book book = bookService.updateBook(id, name, isbn);

      return book;
    }

    // 書籍情報削除
    // DELETE /books/{id}
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
      bookService.deleteBook(id);

      return;
    }
}
