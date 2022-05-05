package github.javaguide;

import github.javaguide.remoting.transport.netty.client.NettyRpcClient;

public class TestLoadClass {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = TestLoadClass.class.getClassLoader();

        Class<?> aClass = classLoader.loadClass("github.javaguide.remoting.transport.netty.client.NettyRpcClient");
        System.out.println(aClass);

        System.out.println(NettyRpcClient.class);
    }
}
