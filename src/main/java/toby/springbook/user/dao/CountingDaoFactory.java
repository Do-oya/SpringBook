package toby.springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toby.springbook.user.domain.ConnectionMaker;
import toby.springbook.user.domain.CountingConnectionMarker;
import toby.springbook.user.domain.DConnectionMaker;
import toby.springbook.user.domain.UserDao;

@Configuration
public class CountingDaoFactory {
    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new CountingConnectionMarker(realConnectionMarker());
    }

    @Bean
    public ConnectionMaker realConnectionMarker() {
        return new DConnectionMaker();
    }
}
