package dev.shintani.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.shintani.demo.entities.Book;
import dev.shintani.demo.repositories.BookRepository;

// 書籍サービス
@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  public List<Book> getBookList() {
    List<Book> bookList = bookRepository.findAll();

    return bookList;
  }

  public Book getBook(Long id) {
    Optional<Book> optional = bookRepository.findById(id);
    Book book = optional.orElseThrow();

    return book;
  }

  public Book createBook(String name, String isbn) {
    Book book = new Book();

    book.setName(name);
    book.setIsbn(isbn);

    bookRepository.save(book);

    return book;
  }

  public Book updateBook(Long id, String name, String isbn) {
    Optional<Book> optional = bookRepository.findById(id);
    Book book = optional.orElseThrow();

    book.setName(name);
    book.setIsbn(isbn);

    bookRepository.save(book);

    return book;
  }

  public void deleteBook(Long id) {
    Optional<Book> optional = bookRepository.findById(id);
    Book book = optional.orElseThrow();

    bookRepository.delete(book);

    return;
  }

}
