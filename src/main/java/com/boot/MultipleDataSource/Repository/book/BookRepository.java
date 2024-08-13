package com.boot.MultipleDataSource.Repository.book;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.MultipleDataSource.domain.book.BookDetails;

public interface BookRepository extends JpaRepository<BookDetails, Integer> {

}
