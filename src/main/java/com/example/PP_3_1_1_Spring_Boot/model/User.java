package com.example.PP_3_1_1_Spring_Boot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Введите имя")
    @Size(max = 50, message = "Слишком длинное имя")
    private String name;

    @NotBlank(message = "Введите фамилию")
    @Size(max = 50, message = "Слишком длинная фамилия")
    private String lastName;

    @NotNull(message = "Введите возраст")
    @Min(value = 0, message = "Возраст не может быть отрицательным")
    private Byte age;
}
