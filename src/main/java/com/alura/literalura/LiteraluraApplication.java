package com.alura.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alura.literalura.repository.BooksRepository;
import com.alura.literalura.controller.LiteraluraController;
import com.alura.literalura.repository.AuthorsRepository;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private BooksRepository booksRepository;

	@Autowired
	private AuthorsRepository authorsRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LiteraluraController start = new LiteraluraController(booksRepository, authorsRepository);
		start.displayMenu();
	}
}
