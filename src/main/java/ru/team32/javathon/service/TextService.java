package ru.team32.javathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.team32.javathon.dao.ITextDAO;

@Service
public class TextService implements ITextService {
    @Autowired
    private ITextDAO textDAO;

    public void parseText(String rawText) {

    }

    @Override
    public void selectTheme() {
        textDAO.getSomething();
    }
}
