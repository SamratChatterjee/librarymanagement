package com.genpact.learning.controller;

import com.genpact.learning.model.Library;
import com.genpact.learning.services.LibraryService;
import com.genpact.learning.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/learning")
@CrossOrigin(origins = "*")
public class LibraryController {

    private static final Logger logger = LogManager.getLogger(LibraryController.class);

    @Autowired
    LibraryService libraryService;

    @GetMapping(value = "/libraries")
    public List<Library> getAllLibraries(){
        logger.debug(Constants.ENTER_MESSAGE + "LibraryController.getAllLibraries()");
        List<Library> libraryResponse = libraryService.getAllLibraries();
        logger.debug(Constants.EXIT_MESSAGE + "LibraryController.getAllLibraries()");
        return libraryResponse;
    }
}
