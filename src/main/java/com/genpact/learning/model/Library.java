package com.genpact.learning.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "library")
public class Library {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "library_id")
   private int libraryId;

   @Column(name = "lib_name")
   private String libraryName;

   @Column(name = "librarian_name")
   private String librarianName;

    public Library() {
    }

    public Library(String libraryName, String librarianName) {
        this.libraryName = libraryName;
        this.librarianName = librarianName;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

}
