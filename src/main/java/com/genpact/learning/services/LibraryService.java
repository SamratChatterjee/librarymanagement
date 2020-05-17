package com.genpact.learning.services;

import com.genpact.learning.model.Library;
import com.genpact.learning.repository.LibraryRepository;
import com.genpact.learning.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private static final Logger logger = LogManager.getLogger(LibraryService.class);

    @Autowired
    LibraryRepository libraryRepository;

    public List<Library> getAllLibraries(){
        logger.debug(Constants.ENTER_MESSAGE + "LibraryService.getAllLibraries()");
        try {
            logger.debug(Constants.FETCH_MESSAGE + "LibraryRepository");
            List<Library> libraries = (List<Library>) libraryRepository.findAll();
            if(libraries != null) {
                return libraries;
            }
            else {
                logger.debug(Constants.EXIT_MESSAGE + "LibraryService.getAllLibraries()");
                return null;
            }
        }
        catch(Exception e){
            logger.error(e.getMessage());
            logger.debug(Constants.EXIT_MESSAGE + "LibraryService.getAllLibraries()");
            return null;
        }
    }
}
