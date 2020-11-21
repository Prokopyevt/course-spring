package com.simbirsoft.springcourse.service.Impl;

import com.simbirsoft.springcourse.dto.LibraryDto;
import com.simbirsoft.springcourse.model.Library;
import com.simbirsoft.springcourse.repository.LibraryRepository;
import com.simbirsoft.springcourse.service.LibraryService;
import com.simbirsoft.springcourse.service.MistakesController.ThereIsNoSuchUserException;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.isEmpty;

@Service
public class LibraryServiceImpl implements LibraryService {


    private final LibraryRepository libraryRepository;

    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public Library getById(Long id) {
        if (isEmpty(id)) {
            throw new NullPointerException("ID не найден");
        }
        Library library = libraryRepository.findById(id).orElse(null);
        if (isEmpty(library)) {
            throw new ThereIsNoSuchUserException("Библиотека не найдена");
        }
        return library;
    }

    @Override
    public Library save(LibraryDto libraryDto) {
        if (isEmpty(libraryDto)) {
            throw new NullPointerException("Пустое значение");
        }
        Library library = new Library();
        library.setNameBook(libraryDto.getNameBook());
        library.setAuthor(libraryDto.getAuthor());
        library.setYearOfPublishing(libraryDto.getYearOfPublishing());
        library.setStatus(libraryDto.getStatus());
        return libraryRepository.save(library);
    }

    @Override
    public void delete(Long id) {
        libraryRepository.deleteById(id);
    }
}
