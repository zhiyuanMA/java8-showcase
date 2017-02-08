package showcase.defaultmethods;

/**
 * Created by Administrator on 2017/2/6.
 */
public class CombGreetingService implements GreetingService, AnotherGreetingService {
    /**
     * a default implementation return "Hello World"
     *
     * @return
     */
    @Override
    public String greet() {
        return GreetingService.super.greet();
    }
}
