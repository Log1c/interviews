package ua.logic.betinvest;

public class Sum {
    private final int arg1;
    private final int arg2;
    private Double result;

    public Sum(int arg1, int arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sum sum = (Sum) o;

        if (arg1 != sum.arg1) return false;

        return arg2 == sum.arg2;
    }

    @Override
    public int hashCode() {
        return arg1 + arg2;
    }

    public double getResult() {
        if (result != null) {
            return result;
        }

        try {
            Thread.sleep(1000);
        }catch(InterruptedException e){}
        result = (double) (arg1 + arg2);

        return result;
    }

    @Override
    public String toString() {
        return "Sum{" +
                "arg1=" + arg1 +
                ", arg2=" + arg2 +
                ", result=" + result +
                '}';
    }
}