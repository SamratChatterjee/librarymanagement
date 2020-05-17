package com.genpact.learning.repository;

import com.genpact.learning.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>  {
    @Query(value = "select b from Book b where b.bookId = ?1")
    Book findBookById(@Param("id") int id);

    @Modifying
    @Query(value = "delete from Book where bookId = ?1")
    void deleteBookById(@Param("id") int id);
}
