package ru.jarsoft.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jarsoft.test.dao.RequestDAO;
import ru.jarsoft.test.dao.RequestDaoImpl;
import ru.jarsoft.test.model.Request;

import java.util.List;
@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    RequestDAO requestDAO = new RequestDaoImpl();

    @Transactional
    public List<Request> getAll() {
        return requestDAO.getAllCategories();
    }

    @Override
    @Transactional
    public void add(Request request) {
        requestDAO.add(request);
    }

    @Override
    @Transactional
    public void delete(Request request) {
        requestDAO.delete(request);
    }



    @Override
    @Transactional
    public Request getById(int id) {
        return requestDAO.getById(id);
    }



}
