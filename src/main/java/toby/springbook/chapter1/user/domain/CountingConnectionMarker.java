package toby.springbook.chapter1.user.domain;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingConnectionMarker implements ConnectionMaker {
    int counter = 0;
    private ConnectionMaker realConnectionMarker;

    public CountingConnectionMarker(ConnectionMaker realConnectionMarker) {
        this.realConnectionMarker = realConnectionMarker;
    }

    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        this.counter++;
        return realConnectionMarker.makeConnection();
    }

    public int getCounter() {
        return this.counter;
    }
}
