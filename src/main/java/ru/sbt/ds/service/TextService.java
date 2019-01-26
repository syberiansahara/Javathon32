package ru.sbt.ds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbt.ds.dao.ITextDAO;

@Service
public class TextService implements ITextService {
    @Autowired
    private ITextDAO textDAO;

    public void parseText(String rawText) {

    }
}
