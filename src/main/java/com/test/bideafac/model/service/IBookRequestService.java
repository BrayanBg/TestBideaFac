package com.test.bideafac.model.service;


import com.test.bideafac.exception.Errorstatus;
import com.test.bideafac.model.entity.BookRequest;

public interface IBookRequestService {
    String reservaCasa(BookRequest bookRequest) throws Errorstatus;
}
