package fc.java.part3;

import fc.java.model.MyUtil;

public class NonStaticAccess {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        //MyUtil
        MyUtil z = new MyUtil();
        int sum = z.hap2(a,b);
        System.out.println(sum);
    }
}
