package com.test.bideafac.model.repository;

import com.test.bideafac.model.entity.BookRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRequestDAO extends CrudRepository<BookRequest,String> {

}
