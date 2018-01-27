package ua.logic.teamDev;

import org.junit.Assert;
import org.junit.Test;

public class ContextTest {
    @Test
    public void test1() {
        String s = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++" +
                ".>+.+++++++..+++.>++.<<+++++++++++++++.>.+++." +
                "------.--------.>+.>.";

        Context context = new Context(s);
        context.evaluate();
        Assert.assertTrue(context.getResult().equals("Hello World!\n"));
    }

    @Test
    public void test2() {
        String s = "+++++++++++++++++++++++++++++++++++++++++++++" +
                "+++++++++++++++++++++++++++.+++++++++++++++++" +
                "++++++++++++.+++++++..+++.-------------------" +
                "---------------------------------------------" +
                "---------------.+++++++++++++++++++++++++++++" +
                "++++++++++++++++++++++++++.++++++++++++++++++" +
                "++++++.+++.------.--------.------------------" +
                "---------------------------------------------" +
                "----.-----------------------.";

        Context context = new Context(s);
        context.evaluate();
        Assert.assertTrue(context.getResult().equals("Hello World!\n"));
    }

    @Test
    public void emptyTest() {
        String s = "";
        Context context = new Context(s);
        context.evaluate();
        Assert.assertTrue(context.getResult().equals(""));
    }

    @Test
    public void incorrectTest() {
        String s = "";
        Context context = new Context(s);
        context.evaluate();
        Assert.assertTrue(!context.getResult().equals("Hello World!\n"));
    }
}