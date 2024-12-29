package com.alura.literalura.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.alura.literalura.model.Book;

public interface BooksRepository extends JpaRepository<Book, Integer> {
  @SuppressWarnings("null")
  List<Book> findAll();

  List<Book> findByAuthorId(Integer id);

  @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Book b WHERE b.title = :title")
  boolean findByTitleBoolean(String title);

  @Query("SELECT DISTINCT b.languages FROM Book b")
  List<String> selectAllLanguages();

  List<Book> findByLanguages(String[] languages);

  @Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
  List<Book> findByTitle(String title);
}
