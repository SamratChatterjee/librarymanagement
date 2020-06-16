package com.genpact.learning.services;

import com.genpact.learning.model.Book;
import com.genpact.learning.model.Borrower;
import com.genpact.learning.repository.BookRepository;
import com.genpact.learning.repository.BorrowerRepository;
import com.genpact.learning.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    private static final Logger logger = LogManager.getLogger(BookService.class);

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BorrowerRepository borrowerRepository;

    @Transactional
    public void updateBorrower(Borrower borrower){
        int bookId = borrower.getBookId();
        Book book = bookRepository.findBookById(bookId);
        book.setQuantity(book.getQuantity()-1);
        updateBook(book);
        borrowerRepository.save(borrower);

    }

    public List<Book> getAllBooks(){
        logger.debug(Constants.ENTER_MESSAGE + "BookService.getAllBooks()");
        try {
            logger.debug(Constants.FETCH_MESSAGE + "BookRepository");
            List<Book> books = (List<Book>) bookRepository.findAll();
            if(books != null){
                return books;
            }
            else{
                logger.debug(Constants.EXIT_MESSAGE + "BookService.getAllBooks()");
                return null;
            }
        }
        catch(Exception e){
            logger.error(e.getMessage());
            logger.debug(Constants.EXIT_MESSAGE + "BookService.getAllBooks()");
            return null;
        }
    }

    public List<Book> getBookByLibraryId(int id){
        logger.debug(Constants.ENTER_MESSAGE + "BookService.getBookByLibraryId()");
        try {
            logger.debug(Constants.FETCH_MESSAGE + "BookRepository");
            List<Book> books = bookRepository.findBookByLibraryId(id);
            if(books != null){
                return books;
            }
            else{
                logger.debug(Constants.EXIT_MESSAGE + "BookService.getBookByLibraryId()");
                return null;
            }
        }
        catch(Exception e){
            logger.error(e.getMessage());
            logger.debug(Constants.EXIT_MESSAGE + "BookService.getBookByLibraryId()");
            return null;
        }
    }
    public Book getBookById(int id) {
        logger.debug(Constants.ENTER_MESSAGE + "BookService.getBookById()");
        try {
            logger.debug(Constants.FETCH_MESSAGE + "BookRepository");
            Book book = bookRepository.findBookById(id);
            if (book != null) {
                return book;
            } else {
                logger.debug(Constants.EXIT_MESSAGE + "BookService.getBookById()");
                return null;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.debug(Constants.EXIT_MESSAGE + "BookService.getBookById()");
            return null;
        }
    }


    @Transactional
    public boolean addBook(Book book){
        logger.debug(Constants.ENTER_MESSAGE + "BookService.addBook()");
        try{
            logger.debug(Constants.FETCH_MESSAGE + "BookRepository");
            boolean isBookCreated = bookRepository.save(book) != null;
            logger.debug(Constants.EXIT_MESSAGE + "BookService.getBookById()");
            return isBookCreated;
        }
        catch (Exception e){
            logger.error(e.getMessage());
            logger.debug(Constants.EXIT_MESSAGE + "BookService.getBookById()");
            return false;
        }
    }

    @Transactional
    public boolean updateBook(Book book){
        logger.debug(Constants.ENTER_MESSAGE + "BookService.updateBook()");
        try{
            logger.debug(Constants.FETCH_MESSAGE + "BookRepository");
            boolean isBookCreated = bookRepository.save(book) != null;
            logger.debug(Constants.EXIT_MESSAGE + "BookService.updateBook()");
            return isBookCreated;
        }
        catch (Exception e){
            logger.error(e.getMessage());
            logger.debug(Constants.EXIT_MESSAGE + "BookService.updateBook()");
            return false;
        }
    }

    @Transactional
    public void deleteBook(int id){
        logger.debug(Constants.ENTER_MESSAGE + "BookService.deleteBook()");
        try{
            bookRepository.deleteBookById(id);
            logger.debug(Constants.EXIT_MESSAGE + "BookService.deleteBook()");
        }
        catch (Exception e){
            logger.error(e.getMessage());
            logger.debug(Constants.EXIT_MESSAGE + "BookService.deleteBook()");
        }
    }
}
