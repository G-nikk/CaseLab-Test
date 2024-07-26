package ru.shibanov.CaseLab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shibanov.CaseLab.models.File;

@Repository
public interface FilesRepository extends JpaRepository<File, Integer> {

}
