package dev.shintani.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.shintani.demo.entities.Book;

// 書籍リポジトリ
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}
