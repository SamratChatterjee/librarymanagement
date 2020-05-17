package com.genpact.learning.services;

import com.genpact.learning.model.Library;
import com.genpact.learning.repository.LibraryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Class For LibraryService")
@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {

    @Mock
    LibraryRepository libraryRepository;

    @InjectMocks
    LibraryService libraryService = new LibraryService();

    List<Library> libraryList = new ArrayList<>();

    @Nested
    @DisplayName("Test Suite for getAllLibraries")
    class GetAllLibrariesTest{

        @Test
        @DisplayName("getAllLibraries-positive-Test")
        void getAllLibrariesPositive() {
            Mockito.when(libraryRepository.findAll())
                    .thenReturn(libraryList);
            assertEquals(libraryList , libraryService.getAllLibraries());
        }

        @Test
        @DisplayName("getAllLibraries-negative-Test")
        void getAllLibrariesNegative() {
            Mockito.when(libraryRepository.findAll())
                    .thenReturn(null);
            assertNull(libraryService.getAllLibraries());
        }
    }
}