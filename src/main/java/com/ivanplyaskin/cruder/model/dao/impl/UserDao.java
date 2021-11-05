package com.ivanplyaskin.cruder.model.dao.impl;

import com.ivanplyaskin.cruder.model.dao.AbstractHibernateDao;
import com.ivanplyaskin.cruder.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractHibernateDao<User> {

    public UserDao() {
        super(User.class);
    }
}
