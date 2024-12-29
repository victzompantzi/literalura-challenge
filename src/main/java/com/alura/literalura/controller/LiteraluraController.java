package com.alura.literalura.controller;

import java.util.Scanner;
import com.alura.literalura.repository.AuthorsRepository;
import com.alura.literalura.repository.BooksRepository;
import com.alura.literalura.service.Main;

public class LiteraluraController {
  private BooksRepository booksRepository;
  private AuthorsRepository authorsRepository;
  private Scanner input = new Scanner(System.in);
  private Main main = new Main();


  public LiteraluraController(BooksRepository booksRepository,
      AuthorsRepository authorsRepository) {
    this.booksRepository = booksRepository;
    this.authorsRepository = authorsRepository;
  }

  public void displayMenu() {
    while (true) { // Loop to rerun the menu
      Integer optMenu = -1;
      while (optMenu < 0 || optMenu > 5) {
        System.out.println("Seleccione el método de búsqueda:");
        System.out.println("""
            1 - Buscar por título
            2 - Listar libros registrados
            3 - Listar autores registrados
            4 - Listar autores vivos en un determinado año
            5 - Listar libros por idioma

            0 - Salir
            """);
        try {
          optMenu = Integer.parseInt(input.nextLine());
          if (optMenu < 0 || optMenu > 5) {
            System.out.println("Por favor, ingrese una opción válida.");
          }
          if (optMenu == 0) {
            System.out.println("Saliendo del programa...");
            System.exit(0);
          }
        } catch (NumberFormatException e) {
          System.out.println("Por favor, ingrese una opción válida.");
        }
      }

      switch (optMenu) {
        case 1:
          main.getBookByTitle(booksRepository, authorsRepository);
          break;
        case 2:
          main.getRegisteredBooks(booksRepository, authorsRepository);
          break;
        case 3:
          main.getRegisteredAuthors(booksRepository, authorsRepository);
          // ...existing code... Get the BD records
          break;
        case 4:
          main.getRegisteredAuthorsByYear(booksRepository, authorsRepository);
          break;
        case 5:
          main.getRegisteredBooksByLanguage(booksRepository, authorsRepository);
          break;
        default:
          System.out.println("Opción no válida");
          break;
      }
    }
  }
}
