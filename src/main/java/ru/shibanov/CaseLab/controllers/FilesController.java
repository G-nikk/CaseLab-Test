package ru.shibanov.CaseLab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shibanov.CaseLab.models.File;
import ru.shibanov.CaseLab.services.FilesService;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FilesController {
    private final FilesService filesService;

    @Autowired
    public FilesController(FilesService filesService) {
        this.filesService = filesService;
    }

    @GetMapping
    public List<File> getFiles() {
        return filesService.findAll();
    }
    @GetMapping("/{id}")
    public File getFile(@PathVariable int id) {
        return filesService.findOne(id);
    }
    @PostMapping
    public ResponseEntity<Integer> createFile(@RequestBody File file) {
        filesService.save(file);
        return ResponseEntity.ok(file.getId());
    }
}
