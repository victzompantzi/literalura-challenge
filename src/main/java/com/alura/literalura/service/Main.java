package com.alura.literalura.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.alura.literalura.model.Author;
import com.alura.literalura.model.Book;
import com.alura.literalura.model.Data;
import com.alura.literalura.model.DataBooks;
import com.alura.literalura.repository.AuthorsRepository;
import com.alura.literalura.repository.BooksRepository;
import java.time.Year;

public class Main {
  private static final String URL_BASE = "http://gutendex.com/books/";
  private ApiConsumption request = new ApiConsumption();
  private JsonConverter converter = new JsonConverter();
  private Scanner input = new Scanner(System.in);

  private DataBooks getDataBook() {
    System.out.println("Título del libro:");
    var bookTitle = input.nextLine();
    var json = request.getData(URL_BASE + "?search=" + bookTitle.replace(" ", "+"));
    try {
      Data data = converter.getData(json, Data.class);
      if (data.results() != null && !data.results().isEmpty()) {
        DataBooks dataBook = data.results().get(0); // Get only the first object
        return dataBook;
      } else {
        System.out.println("No se encontraron resultados.");
        return null;
      }
    } catch (Exception e) {
      System.out.println("Error converting JSON to DataBooks: " + e.getMessage());
      e.printStackTrace();
      return null;
    }
  }

  private void printBook(Book newBook) {
    String bookDetails = String.format("""
        ---------- LIBRO ----------
        Título: %s
        Autor: %s
        Idiomas: %s
        Número de descargas: %d
        ---------------------------
        """, newBook.getTitle(), newBook.getAuthor().getName(),
        String.join(", ", newBook.getLanguages()), newBook.getNumDownloads());
    System.out.println(bookDetails);
  }

  private void printAuthor(Author author, String bookTitles) {
    String authorsDetails = String.format("""
        ---------- AUTOR ----------
        Autor: %s
        Fecha de nacimiento: %s
        Fecha de fallecimiento: %s
        Libros: %s
        ---------------------------
        """, author.getName(), author.getBirthYear(), author.getDeathYear(), bookTitles);
    System.out.println(authorsDetails);
  }

  public void getBookByTitle(BooksRepository booksRepository, AuthorsRepository authorsRepository) {
    DataBooks dataNewBook = getDataBook();
    if (dataNewBook != null) {
      // Save authors first
      List<Author> authors = dataNewBook.authors();
      for (Author author : authors) {
        if (authorsRepository.findByName(author.getName()).isEmpty()) {
          authorsRepository.save(author);
        }
      }
      if (!booksRepository.findByTitleBoolean(dataNewBook.title())) {
        // Retrieve the saved authors to ensure they are managed entities
        List<Author> savedAuthors = authors.stream()
            .map(author -> authorsRepository.findByName(author.getName()).orElse(null))
            .collect(Collectors.toList());
        Book newBook = new Book(dataNewBook);
        if (!savedAuthors.isEmpty()) {
          newBook.setAuthor(savedAuthors.get(0)); // Assuming the first author is the main author
        }

        // Convert languages to array of strings
        String[] languagesArray = dataNewBook.languages().toArray(new String[0]);
        newBook.setLanguages(languagesArray);
        booksRepository.save(newBook); // Save the book with the author
        printBook(newBook); // Print the found book
      } else {
        System.out.println("Ya registrado en la base");
        List<Book> getBookFromDB = booksRepository.findByTitle(dataNewBook.title());
        printBook(getBookFromDB.get(0));
      }
    }
  }

  public void getRegisteredBooks(BooksRepository booksRepository,
      AuthorsRepository authorsRepository) {
    // Retrieve all the registered books and save them in the list
    List<Book> books = booksRepository.findAll();
    if (books.isEmpty()) {
      System.out.println("No hay libros registrados.");
      System.exit(0);
    } else {
      for (Book book : books) {
        printBook(book);
      }
    }
  }

  public void getRegisteredAuthors(BooksRepository booksRepository,
      AuthorsRepository authorsRepository) {
    List<Author> authors = authorsRepository.findAll();
    if (authors.isEmpty()) {
      System.out.println("No hay autores registrados");
      System.exit(0);
    } else {
      for (Author author : authors) {
        List<Book> books = booksRepository.findByAuthorId(author.getId());
        String bookTitles = books.stream().map(Book::getTitle).collect(Collectors.joining(", "));
        printAuthor(author, bookTitles);
      }
    }
  }

  public void getRegisteredAuthorsByYear(BooksRepository booksRepository,
      AuthorsRepository authorsRepository) {
    int year = 0;
    while (year == 0 || year > Year.now().getValue()) {
      System.out.println("Año:");
      try {
        year = Integer.parseInt(input.nextLine());
        if (year > Year.now().getValue()) {
          System.out
              .println("El año no puede estar en el futuro. Por favor, ingrese un año válido.");
          year = 0; // Reset year to 0 to continue the loop
        }
      } catch (NumberFormatException e) {
        System.out.println("Por favor, ingrese un año válido.");
        year = 0; // Reset year to 0 to continue the loop
      }
    }

    List<Author> livingAuthors = authorsRepository.getRegisteredAuthorsByYear(year);
    if (livingAuthors.isEmpty()) {
      System.out.println("No hay autores registrados");
      System.exit(0);
    } else {
      for (Author author : livingAuthors) {
        List<Book> books = booksRepository.findByAuthorId(author.getId());
        String bookTitles = books.stream().map(Book::getTitle).collect(Collectors.joining(", "));
        printAuthor(author, bookTitles);
      }
    }
  }

  public void getRegisteredBooksByLanguage(BooksRepository booksRepository,
      AuthorsRepository authorsRepository) {
    // Gets the list of registered languages from the DB
    List<String> registeredLangs = booksRepository.selectAllLanguages();
    if (registeredLangs.isEmpty()) {
      System.out.println("No hay idiomas registrados");
      System.exit(0);
    } else {
      for (int i = 0; i < registeredLangs.size(); i++) {
        String lang = registeredLangs.get(i);
        System.out.printf("%d - %s%n", i + 1, lang);
      }
    }
    int lengthOfRegisteredLangs = registeredLangs.size();
    int userLang = 0;
    while (userLang == 0) {
      System.out.println("Seleccione un número:");
      try {
        userLang = input.nextInt();
        if (userLang > lengthOfRegisteredLangs || userLang < 1) {
          System.out.println("Opción no válida. Por favor, seleccione un número entre 1 y "
              + lengthOfRegisteredLangs);
          userLang = input.nextInt();
        }
      } catch (InputMismatchException ime) {
        System.out.println("Entrada no válida. Por favor, ingrese un número.");
        input.next(); // Clear the invalid input
        userLang = 0;
      }
    }

    // Query the database and print the results
    String selectedLanguage = registeredLangs.get(userLang - 1);
    List<Book> books = booksRepository.findByLanguages(new String[] {selectedLanguage});
    if (books.isEmpty()) {
      System.out.println("No hay libros registrados en " + selectedLanguage);
    } else {
      for (Book book : books) {
        printBook(book);
      }
    }
  }
}
