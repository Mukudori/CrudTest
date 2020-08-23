package ru.jarsoft.test.service;

import ru.jarsoft.test.model.Request;

import java.util.List;

public interface RequestService {
    List<Request> getAll();
    void add(Request request);
    void delete(Request request);

    Request getById(int id);
}
