package showcase.methodreference;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Callable;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhiyuan on 2017/2/7.
 */
public class MethodReferenceTest {
    private Foo foo;

    @Before
    public void setUp() throws Exception {
        foo = new Foo();
    }

    @Test
    public void callbackWithoutMR() throws Exception {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return foo.bar();
            }
        };

        assertEquals(foo.bar(), callable.call());
    }

    @Test
    public void callbackWithMR() throws Exception {
        Callable<String> callable = foo::bar;

        assertEquals(foo.bar(), callable.call());
    }
}
