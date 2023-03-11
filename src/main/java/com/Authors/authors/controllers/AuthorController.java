package com.Authors.authors.controllers;

import com.Authors.authors.beans.Author;
import com.Authors.authors.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping
    public List<Author>  getAllAuthor(){return authorRepository.findAll();}

    @GetMapping("/{id}")
    public Author getKitapById(@PathVariable Long id){return authorRepository.findById(id).get();}

    @PostMapping(consumes = "application/json")
    public List<Author> addAuthor (@RequestBody Author author){
        authorRepository.save(author);
        return authorRepository.findAll();
    }

    @PutMapping(consumes = "application/json")
    public List<Author> replaceKitapList(@RequestBody List<Author> authorList){
        authorRepository.deleteAll();
        authorRepository.saveAll(authorList);
        return authorRepository.findAll();
    }

    @PutMapping(value="/{id}", consumes = "application/json" )
    public List<Author> replaceAuthor(@PathVariable Long id, @RequestBody Author author)
    {
        authorRepository.deleteById(id);
        authorRepository.save(author);
        return authorRepository.findAll();
    }


    @PatchMapping(value="/{id}", consumes = "application/json" )
    public List<Author> updateAuthor(@PathVariable Long id, @RequestBody Author newAuthor)
    {
        Author aktifKitap = authorRepository.findById(id).get();

        aktifKitap.setAuthorID(newAuthor.getAuthorID());
        aktifKitap.setName(newAuthor.getName());
        aktifKitap.setBirthDay(newAuthor.getBirthDay());

        authorRepository.save(aktifKitap);
        return authorRepository.findAll();
    }

        @DeleteMapping (value="/{id}")
        public List<Author> deleteAuthor(@PathVariable Long id){
        authorRepository.deleteById(id);
        return authorRepository.findAll();

        }


        @DeleteMapping()
        public List<Author> deleteAllAuthor(){
        authorRepository.deleteAll();
        return authorRepository.findAll();



    }


}
