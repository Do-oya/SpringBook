package toby.springbook.chapter1.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import toby.springbook.chapter1.user.domain.UserDao;

import javax.sql.DataSource;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource());
        return userDao;
    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);  // MySQL 드라이버 최신 버전으로 변경
        dataSource.setUrl("jdbc:mysql://localhost/springbook");
        dataSource.setUsername("root");
        dataSource.setPassword("1441");

        return dataSource;
    }
}