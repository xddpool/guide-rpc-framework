package github.javaguide;

public class TestTrim {
    public static void main(String[] args) {
        String line = "  qwerty  uio";
        int u = line.indexOf("u");
        String substring = line.substring(0, u);
        System.out.println(substring);
        String trim = substring.trim();
        System.out.println(trim);
    }
}
