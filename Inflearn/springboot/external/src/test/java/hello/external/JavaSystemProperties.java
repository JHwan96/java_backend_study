package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Slf4j
public class JavaSystemProperties {
    public static void main(String[] args){
        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            log.info("prop {}={}", key, System.getProperty(String.valueOf(key)));
        }

        String url = System.getProperty("url");
        String password = System.getProperty("password");
        String username = System.getProperty("username");

        System.out.println("url = " + url);
        System.out.println("password = " + password);
        System.out.println("username = " + username);
    }
}
