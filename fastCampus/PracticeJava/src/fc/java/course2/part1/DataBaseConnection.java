package fc.java.course2.part1;

import fc.java.model2.ADriver;
import fc.java.model2.BDriver;
import fc.java.model2.CDriver;
import fc.java.model2.Connection;

public class DataBaseConnection {
    public static void main(String[] args) {
        // A_DB 접속
        Connection conn = new ADriver();
        conn.getConnection("url", "username", "password");

        // B_DB 접속
        Connection conn1 = new BDriver();
        conn1.getConnection("url","username", "password");

        Connection conn2 = new CDriver();
        conn2.getConnection("url","username", "password");
    }
}
