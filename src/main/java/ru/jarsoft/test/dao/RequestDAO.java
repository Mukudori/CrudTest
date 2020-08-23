package ru.jarsoft.test.dao;

import ru.jarsoft.test.model.Category;
import ru.jarsoft.test.model.Request;

import java.util.List;

public interface RequestDAO {
    List<Request> getAllCategories();
    void add(Request request);
    void delete(Request request);

    Request getById(int id);
}
