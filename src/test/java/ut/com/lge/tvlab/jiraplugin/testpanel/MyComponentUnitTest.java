package ut.com.lge.tvlab.jiraplugin.testpanel;

import org.junit.Test;
import com.lge.tvlab.jiraplugin.testpanel.MyPluginComponent;
import com.lge.tvlab.jiraplugin.testpanel.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}