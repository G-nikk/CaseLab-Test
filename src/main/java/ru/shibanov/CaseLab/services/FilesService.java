package ru.shibanov.CaseLab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shibanov.CaseLab.models.File;
import ru.shibanov.CaseLab.repositories.FilesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class FilesService {
    private final FilesRepository filesRepository;

    @Autowired
    public FilesService(FilesRepository filesRepository) {
        this.filesRepository = filesRepository;
    }

    public List<File> findAll() {
        return filesRepository.findAll();
    }

    public File findOne(int id) {
        Optional<File> file = filesRepository.findById(id);
        return file.orElse(null);
    }

    @Transactional
    public void save(File file) {
        filesRepository.save(file);
    }
}
