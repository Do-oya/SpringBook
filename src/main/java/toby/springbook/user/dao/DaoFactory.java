package toby.springbook.user.dao;

import toby.springbook.user.domain.ConnectionMaker;
import toby.springbook.user.domain.DConnectionMaker;
import toby.springbook.user.domain.UserDao;

public class DaoFactory {
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
