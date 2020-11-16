package com.simbirsoft.springcourse.service.Impl;

import com.simbirsoft.springcourse.dto.LibraryDto;
import com.simbirsoft.springcourse.model.Library;
import com.simbirsoft.springcourse.repository.LibraryRepository;
import com.simbirsoft.springcourse.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public Library getById(Long id) {
        return libraryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(LibraryDto libraryDto) {
        Library library = new Library();
        library.setNameBook(libraryDto.getNameBook());
        library.setAuthor(libraryDto.getAuthor());
        library.setYearOfPublishing(libraryDto.getYearOfPublishing());
        library.setStatus(libraryDto.getStatus());
        libraryRepository.save(library);
    }

    @Override
    public void delete(Long id) {
        libraryRepository.deleteById(id);

    }
}
