package showcase.defaultmethods;

/**
 * Created by zhiyuan on 2017/2/6.
 */
public interface AnotherGreetingService {
    default String greet() {
        return "Hello!";
    }
}
