package com.alura.literalura.model;

import java.util.List;
import java.util.Arrays;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true) // Specify the length here
  private String title;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "author_id")
  private Author author;
  private String[] languages;
  private Integer numDownloads;

  public Book() {}

  public Book(DataBooks dataBooks) {
    this.title = dataBooks.title();
    this.author = dataBooks.authors().get(0); // Assuming the first author is the main author
    this.languages = dataBooks.languages().toArray(new String[0]);
    this.numDownloads = dataBooks.numDownloads();
  }

  @Override
  public String toString() {
    return "Book [title=" + title + ", author=" + author + ", languages="
        + String.join(", ", languages) + ", numDownloads=" + numDownloads + "]";
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public String[] getLanguages() {
    return languages;
  }

  public void setLanguages(String[] languages) {
    // Ensure no unwanted characters are included
    this.languages = Arrays.stream(languages).map(String::trim).toArray(String[]::new);
  }

  public Integer getNumDownloads() {
    return numDownloads;
  }

  public void setNumDownloads(Integer numDownloads) {
    this.numDownloads = numDownloads;
  }
}
