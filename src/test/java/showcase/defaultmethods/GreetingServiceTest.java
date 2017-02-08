package showcase.defaultmethods;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhiyuan on 2017/2/7.
 */
public class GreetingServiceTest {

    @Test
    public void greetFromDefault() throws Exception {
        assertEquals("Hello World!", new DefaultGreetingService().greet());
    }

    @Test
    public void greetFromExtended() throws Exception {
        assertEquals("Hello Mark!", new ExtendedGreetingService("Mark").greet());
    }

    @Test
    public void greetFromDerived() throws Exception {
        assertEquals("你好!", new DerivedGreetingService().greet());
    }

    @Test
    public void testName() throws Exception {
        assertEquals("Hello World!", new CombGreetingService().greet());
    }
}
