package github.javaguide;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class TestEnumeration {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = TestEnumeration.class.getClassLoader();
        Enumeration<URL> resources = classLoader.getResources("github/javaguide/compress");


        while (resources.hasMoreElements()) {
            System.out.println(resources.nextElement());
        }
    }
}
