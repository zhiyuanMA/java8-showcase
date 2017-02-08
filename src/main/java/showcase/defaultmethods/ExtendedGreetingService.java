package showcase.defaultmethods;

/**
 * Created by Administrator on 2017/2/6.
 */
public class ExtendedGreetingService implements GreetingService {
    private final String name;

    public ExtendedGreetingService(String name) {
        this.name = name;
    }

    @Override
    public String greet() {
        return "Hello " + name + "!";
    }
}
