package com.genpact.learning.services;

import com.genpact.learning.model.Book;
import com.genpact.learning.repository.BookRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Class For BookService")
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService = new BookService();

    List<Book> bookList = new ArrayList<>();
    Book book = new Book();

    @Nested
    @DisplayName("Test Suite for getAllBooks")
    class GetAllBooksTest{
        @Test
        @DisplayName("getAllBooks-positive-Test")
        void getAllBooksPositive() {
            Mockito.when(bookRepository.findAll())
                    .thenReturn(bookList);
            assertEquals(bookList , bookService.getAllBooks());
        }
        @Test
        @DisplayName("getAllBooks-negative-Test")
        void getAllBooksNegative() {
            Mockito.when(bookRepository.findAll())
                    .thenReturn(null);
            assertNull(bookService.getAllBooks());
        }
    }

    @Nested
    @DisplayName("Test Suite for getBookById")
    class GetBookByIdTest{
        @Test
        @DisplayName("findBookById-Positive-Test")
        void getBookByIdPositive() {
            Mockito.when(bookRepository.findBookById(1))
                    .thenReturn(bookList);
            assertEquals(bookList, bookService.getBookById(1));
        }

        @Test
        @DisplayName("findBookById-Negative-Test")
        void getBookByIdNegative() {
            Mockito.when(bookRepository.findBookById(100))
                    .thenReturn(null);
            assertNull(bookService.getBookById(100));
        }
    }

    @Nested
    @DisplayName("Test Suite for add Book")
    class AddBook{
        @Test
        @DisplayName("addBook-Positive-Test")
        void addBookPositive(){
            Mockito.when(bookRepository.save(book))
                    .thenReturn(book);
            assertTrue(bookService.addBook(book));
        }

        @Test
        @DisplayName("addBook-Negative-Test")
        void addBookNegative(){
            Mockito.when(bookRepository.save(book) != null)
                    .thenReturn(null);
            assertFalse(bookService.addBook(book));
        }
    }

    @Nested
    @DisplayName("Test Suite for update Book")
    class UpdateBook{
        @Test
        @DisplayName("updateBook-Positive-Test")
        void updateBookPositive(){
            Mockito.when(bookRepository.save(book))
                    .thenReturn(book);
            assertTrue(bookService.updateBook(book));
        }

        @Test
        @DisplayName("updateBook-Negative-Test")
        void updateBookNegative(){
            Mockito.when(bookRepository.save(book) != null)
                    .thenReturn(null);
            assertFalse(bookService.updateBook(book));
        }
    }

}