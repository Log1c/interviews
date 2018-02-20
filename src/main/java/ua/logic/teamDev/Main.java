package ua.logic.teamDev;

//will write interpretator of "Brainfuck" language
public class Main {
    public static void main(String[] args) {
        String s = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++" +
                ".>+.+++++++..+++.>++.<<+++++++++++++++.>.+++." +
                "------.--------.>+.>.";

        Context context = new Context(s);
        context.evaluate();
        System.out.println(context.getResult());
    }
}
