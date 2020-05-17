package com.genpact.learning.controller;

import com.genpact.learning.model.Book;
import com.genpact.learning.services.BookService;
import com.genpact.learning.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learning")
public class BookController {

    private static final Logger logger = LogManager.getLogger(LibraryController.class);

    @Autowired
    BookService bookService;

    @GetMapping(value = "/books")
    public List<Book> getAllBooks(){
        logger.debug(Constants.ENTER_MESSAGE + "BookController.getAllBooks()");
        List<Book> response = bookService.getAllBooks();
        logger.debug(Constants.EXIT_MESSAGE + "BookController.getAllBooks()");
        return response;
    }

    @GetMapping(value = "/book/{id}")
    public Book getBookById(@PathVariable int id){
        logger.debug(Constants.ENTER_MESSAGE + "BookController.getBookById()");
        Book response = bookService.getBookById(id);
        logger.debug(Constants.EXIT_MESSAGE + "BookController.getBookById()");
        return response;
    }

    @PostMapping(value = "/book/add")
    public HttpStatus insertBook(@RequestBody Book book){
        logger.debug(Constants.ENTER_MESSAGE + "BookController.insertBook()");
        boolean isInsertSuccess = bookService.addBook(book);
        if(isInsertSuccess){
            logger.debug(Constants.EXIT_MESSAGE + "BookController.insertBook()");
            return HttpStatus.CREATED;
        }
        else{
            logger.debug(Constants.EXIT_MESSAGE + "BookController.insertBook()");
            return HttpStatus.BAD_REQUEST;
        }
    }

    @PutMapping(value = "/book/update")
    public HttpStatus updateBook(@RequestBody Book book){
        logger.debug(Constants.ENTER_MESSAGE + "BookController.updateBook()");
        boolean isInsertSuccess = bookService.updateBook(book);
        if(isInsertSuccess){
            logger.debug(Constants.EXIT_MESSAGE + "BookController.updateBook()");
            return HttpStatus.ACCEPTED;
        }
        else{
            logger.debug(Constants.EXIT_MESSAGE + "BookController.updateBook()");
            return HttpStatus.BAD_REQUEST;
        }
    }

    @DeleteMapping(value = "/book/delete/{id}")
    public HttpStatus deleteBook(@PathVariable int id){
        logger.debug(Constants.ENTER_MESSAGE + "BookController.deleteBook()");
        bookService.deleteBook(id);
        logger.debug(Constants.EXIT_MESSAGE + "BookController.deleteBook()");
        return HttpStatus.NO_CONTENT;
    }
}
