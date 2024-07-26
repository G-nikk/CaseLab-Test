package ru.shibanov.CaseLab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "files")
public class File {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    @NotEmpty(message = "Имя не должно быть пустым!")
    @Size(min = 2, max = 20, message = "Имя должно иметь от 2 до 20 символов!")
    private String title;

    @Column(name = "description")
    @Size(min = 2, max = 20, message = "Описание должно иметь от 2 до 200 символов!")
    private String description;

    @Column(name = "creation_date", updatable = false, insertable = false)
    private LocalDateTime creation_date;

    @Column(name = "base64")
    @NotEmpty(message = "Кодировка base64 не может быть пустой!")
    private String base64;

    public File() {}

    public File(String title, String description, String base64) {
        this.title = title;
        this.description = description;
        this.base64 = base64;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotEmpty(message = "Имя не должно быть пустым!") @Size(min = 2, max = 20, message = "Имя должно иметь от 2 до 20 символов!") String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "Имя не должно быть пустым!") @Size(min = 2, max = 20, message = "Имя должно иметь от 2 до 20 символов!") String name) {
        this.title = name;
    }

    public @Size(min = 2, max = 20, message = "Описание должно иметь от 2 до 200 символов!") String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 2, max = 20, message = "Описание должно иметь от 2 до 200 символов!") String description) {
        this.description = description;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public @NotEmpty(message = "Кодировка base64 не может быть пустой!") String getBase64() {
        return base64;
    }

    public void setBase64(@NotEmpty(message = "Кодировка base64 не может быть пустой!") String base64) {
        this.base64 = base64;
    }
}
