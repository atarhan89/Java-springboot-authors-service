package com.Authors.authors.repositories;

import com.Authors.authors.beans.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
