package fc.java.model2;

public class CDriver implements Connection{
    @Override
    public void getConnection(String url, String username, String password) {
        System.out.println("url, username, password 정보를 이용하여 C_DB에 접속시도함");
    }
}
