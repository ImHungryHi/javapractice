package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.scope.StatelessBean;

public class LifecycleApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lifecycleAppContext.xml");
        StatelessBean bean = context.getBean("statelessBean", StatelessBean.class);

        context.close();
    }
}
