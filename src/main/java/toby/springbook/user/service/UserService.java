package toby.springbook.user.service;

import toby.springbook.user.domain.UserDao;

public class UserService {
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
