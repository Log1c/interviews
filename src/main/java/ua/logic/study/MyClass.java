package ua.logic.study;

public class MyClass {
    protected String methodToBeTested() {
        return anotherMethodInClass();
    }

    protected String anotherMethodInClass() {
//        throw new NullPointerException();
        return "ss";
    }
}
