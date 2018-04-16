package ua.logic.study;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

public class MyClassTest {
    @Mock
    private MyClass myClass;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test1() {
        // would work fine
        doReturn("test").when(myClass).anotherMethodInClass();
    }

    @Test
    public void test2() {
        // would throw a NullPointerException
//        when(myClass.anotherMethodInClass()).thenReturn("test");
        String a = myClass.anotherMethodInClass();
        System.out.println(a);
    }
}