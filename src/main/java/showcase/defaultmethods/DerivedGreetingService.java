package showcase.defaultmethods;

/**
 * Created by zhiyuan on 2017/2/6.
 */
public class DerivedGreetingService extends AbstractGreetingService {
    @Override
    public String greet() {
        return "你好!";
    }
}
