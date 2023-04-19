package fc.java.poly;

public class Board extends Object{ //toString()
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Board{" +
                "title='" + title + '\'' +
                '}';
    }
}
