package ua.logic.betinvest;

public class Sum {
    final int arg1;
    final int arg2;
    Double result;

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
        if (arg2 != sum.arg2) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return arg1 + arg2;
    }

    public double getResult() {
        if (result != null) {
            return result;
        }

//                try {
//                    Thread.sleep(3000);
//                }catch(InterruptedException e){}
        result = Double.valueOf(arg1 + arg2);

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