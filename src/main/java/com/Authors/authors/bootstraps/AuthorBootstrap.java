package com.Authors.authors.bootstraps;

import com.Authors.authors.beans.Author;
import com.Authors.authors.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AuthorBootstrap implements CommandLineRunner {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
    Author author1 = new Author();
    author1.setName("Jean");
    author1.setAuthorID(1L);
    author1.setBirthDay(LocalDate.parse("1975-01-01"));
     authorRepository.save(author1);

     authorRepository.save(Author.builder().name("christopher").authorID(2L).surname("nolan").birthDay(LocalDate.parse("1960-01-01")).build());
     authorRepository.save(new Author(3l,"bale",LocalDate.parse("1970-01-01"),"awoy"));

    }
}
