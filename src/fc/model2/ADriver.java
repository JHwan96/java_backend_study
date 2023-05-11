package fc.java.model2;
// ADriver는 DB 회사에서 만들어서 제공하면 됨 (Driver)
public class ADriver implements Connection{
    @Override
    public void getConnection(String url, String username, String password) {
        System.out.println("url, username, password 정보를 이용하여 A_DB에 접속시도함");
    }
}
