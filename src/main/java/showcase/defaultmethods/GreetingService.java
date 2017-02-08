package showcase.defaultmethods;

/**
 * Created by zhiyuan on 2017/1/21.
 */
public interface GreetingService {
    /**
     * a default implementation return "Hello World"
     * @return
     */
    default String greet(){
        return "Hello World!";
    }
}
