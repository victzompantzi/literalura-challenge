package com.alura.literalura.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@Table(name = "authors")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(unique = true)
  private String name;
  @JsonAlias("birth_year")
  private Integer birthYear;
  @JsonAlias("death_year")
  private Integer deathYear;

  @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
  private List<Book> books;

  public Author() {}

  public Author(DataAuthors dataAuthors) {
    this.name = dataAuthors.name();
    this.birthYear = dataAuthors.birthYear();
    this.deathYear = dataAuthors.deathYear();
  }

  @Override
  public String toString() {
    return "Author [name=" + name + ", birthYear=" + birthYear + ", deathYear=" + deathYear + "]";
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(Integer birthYear) {
    this.birthYear = birthYear;
  }

  public Integer getDeathYear() {
    return deathYear;
  }

  public void setDeathYear(Integer deathYear) {
    this.deathYear = deathYear;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
