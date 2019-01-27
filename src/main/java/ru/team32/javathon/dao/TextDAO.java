package ru.team32.javathon.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import ru.team32.javathon.entity.User;

import javax.transaction.Transactional;

@Transactional
@Repository
public class TextDAO implements ITextDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void getSomething() {
        System.out.println(hibernateTemplate.get(User.class, 1L).toString());
    }
}
