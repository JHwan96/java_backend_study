package hello.proxy.pureproxy.proxy.code;

import java.lang.reflect.Proxy;

public class ProxyPatternClient {
    private final Subject subject;
    public ProxyPatternClient(Subject subject){
        this.subject = subject;
    }

    public void execute(){
        subject.operation();
    }

}
