package spring.scope;

public class StatelessBean {
    public void init() {
        System.out.println("Initialized");
    }

    public void destroy() {
        System.out.println("Destroyed");
    }
}
