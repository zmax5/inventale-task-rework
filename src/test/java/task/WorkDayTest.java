package task;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkDayTest {

    @Test
    public void playWorkDayExample1() {
        String actual = new WorkDay().playWorkDay("AA4AA",0);
        Assert.assertEquals("4342", actual);
    }

    @Test
    public void playWorkDayExample2() {
        String actual = new WorkDay().playWorkDay("AAAAA",0);
        Assert.assertEquals("43214", actual);
    }
}