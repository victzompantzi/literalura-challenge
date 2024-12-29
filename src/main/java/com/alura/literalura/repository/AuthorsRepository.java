package com.alura.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.alura.literalura.model.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorsRepository extends JpaRepository<Author, Integer> {
  Optional<Author> findByName(String name);

  @SuppressWarnings("null")
  List<Author> findAll();

  @Query("SELECT a FROM Author a WHERE a.birthYear <= :year AND a.deathYear >= :year")
  List<Author> getRegisteredAuthorsByYear(int year);

}
