package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.scope.Person;
import spring.scope.StatelessBean;

public class ScopeApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("scopeAppContext.xml");
        StatelessBean statelessBean = context.getBean("statelessBean", StatelessBean.class);
        // The below will call the same object instance - since spring loads every bean once into a singleton
        StatelessBean otherBean = context.getBean("statelessBean", StatelessBean.class);
        System.out.println(statelessBean);
        System.out.println(otherBean);

        Person bob = context.getBean("person", Person.class);
        bob.setName("Bob");
        Person alice = context.getBean("person", Person.class);
        alice.setName("Alice");

        // Without scope="prototype" in the context, this would print Alice
        System.out.println(bob.getName());
        System.out.println(bob);
        System.out.println(alice);

        context.close();
    }
}
