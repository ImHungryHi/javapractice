package spring.scope;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// Starting a lifecycle:
//   Method 1 is via xml and an initializing method, method 2 is via the InitializingBean interface, method 3 is with PostConstruct annotation
// Quitting a lifecycle:
//   Exactly the same, only with destroying method, DisposableBean interface and PreDestruct annotation
public class StatelessBean implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Set after properties");
        // Comes before all
    }

    @PostConstruct
    public void brandNewBean() {
        System.out.println("It's alive!");
        // Comes after an object is constructed; PostConstruct needs "<context:annotation-config />" in spring
        // Second
    }

    public void init() {
        System.out.println("Initialized");
        // Comes during the initialization of the spring context - final step
    }

    public void cleanup() {
        System.out.println("Cleanup on aisle six...");
        // Final destruction process
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Don't make me destroy you...");
        // This comes second in the destruction - final warning
    }

    @PreDestroy
    public void dyingBreath() {
        System.out.println("Tell my wife... I love my pillowcase... [Croaks]");
        // First one to execute when destroying
    }
}
