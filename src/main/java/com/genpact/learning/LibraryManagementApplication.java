package com.genpact.learning;

import com.genpact.learning.model.Book;
import com.genpact.learning.model.Library;
import com.genpact.learning.repository.BookRepository;
import com.genpact.learning.repository.LibraryRepository;
import com.genpact.learning.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class LibraryManagementApplication implements CommandLineRunner {

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookRepository bookRepository;

    private static final Logger logger = LogManager.getLogger(LibraryManagementApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }


    /**
     * Overriding the run method to feed in some data into the h2 db at startup
     * @param args
     * @throws Exception
     */

    @Override
    public void run(String... args) throws Exception {

        logger.debug(Constants.ENTER_MESSAGE + "LibraryManagementApplication.run()");

        Book book1 = new Book("Atlas", "Liz McKay", "World Geography", 5, 500,1);
        Book book2 = new Book("Malgudi Days", "R K Narayan", "Adventure", 7, 150, 1);
        Book book3 = new Book("Let us C", "Yashavant Kanetkar", "Programming", 3, 200, 2);
        Book book4 = new Book("Design Patterns", "Head First", "Programming", 4, 250, 2);
        List<Book> bookList = Arrays.asList(book1,book2,book3,book4);
        logger.debug(Constants.PERSIST_MESSAGE + "BookRepository");
        Iterable<Book> persistedBooks = bookRepository.saveAll(bookList);

        Library juniorLibrary = new Library("Junior Library","Mr. Ross Geller");
        Library seniorLibrary = new Library("Senior Library", "Mrs Rachel Green");
        List<Library> libraryList = Arrays.asList(juniorLibrary,seniorLibrary);
        logger.debug(Constants.PERSIST_MESSAGE + "LibraryRepository");
        Iterable<Library> persistedLibrary = libraryRepository.saveAll(libraryList);

        logger.debug(Constants.EXIT_MESSAGE + "LibraryManagementApplication.run()");
    }
}
