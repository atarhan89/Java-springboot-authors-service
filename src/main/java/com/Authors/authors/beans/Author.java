package com.Authors.authors.beans;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping
@Builder
@Entity
public class Author {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long authorID;
    @NonNull
    private String name;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate birthDay;
    private String surname;

}
