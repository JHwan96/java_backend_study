package fc.java.part4;

import fc.java.poly.A;
import fc.java.poly.B;

public class ObjectPolyTest {
    public static void main(String[] args) {
        Object a = new A();
        display(a);
        Object b = new B();
        display(b);
    }
    public static void display(Object o){
        if (o instanceof A){
            ((A)o).printGo();
        }
        else{
            ((B)o).printGo();
        }
    }
}
