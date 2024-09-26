//package toby.springbook.user.domain;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import toby.springbook.user.dao.CountingDaoFactory;
//
//import java.sql.SQLException;
//
//public class UserDaoConnectionCountingTest {
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
//        UserDao dao = context.getBean("userDao", UserDao.class);
//
//        User user = new User();
//        user.setId("adfa");
//        user.setName("정현");
//        user.setPassword("1234");
//
//        dao.add(user);
//
//        System.out.println(user.getId() + "등록 성공");
//
//        User user2 = dao.get(user.getId());
//        System.out.println(user2.getName());
//        System.out.println(user2.getPassword());
//
//        System.out.println(user2.getId() + "조회 성공");
//
//        CountingConnectionMarker ccm = context.getBean("connectionMaker", CountingConnectionMarker.class);
//        System.out.println("Connection counter : " + ccm.getCounter());
//    }
//}
