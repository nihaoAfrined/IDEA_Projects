package FactoryPattern;

import static java.lang.System.exit;

public abstract class Operation {

    private double NumberA = 0;
    private double NumberB = 0;

    public double getNumberA() {
        return NumberA;
    }

    public void setNumberA(double numberA) {
        NumberA = numberA;
    }

    public double getNumberB() {
        return NumberB;
    }

    public void setNumberB(double numberB) {
        NumberB = numberB;
    }

    public abstract double GetResult() throws Exception;
}

class OperationAdd extends Operation
{

    private double NumberA;
    private double NumberB;

    @Override
    public double GetResult() {
        double result = 0;
        NumberA = getNumberA();
        NumberB = getNumberB();
        result = NumberA + NumberB;
        return result;

    }
}

class OperationSub extends Operation
{
    private double NumberA;
    private double NumberB;

    @Override
    public double GetResult() {
        double result = 0;
        NumberA = getNumberA();
        NumberB = getNumberB();
        result = NumberA - NumberB;
        return result;

    }
}

class OperationMul extends Operation
{
    private double NumberA;
    private double NumberB;

    @Override
    public double GetResult() {
        double result = 0;
        NumberA = getNumberA();
        NumberB = getNumberB();
        result = NumberA * NumberB;
        return result;

    }
}

class OperationDiv extends Operation
{
    private double NumberA;
    private double NumberB;

    @Override
    public double GetResult() throws Exception {
        double result = 0;
        NumberA = getNumberA();
        NumberB = getNumberB();
        if(NumberB==0){
            throw new Exception("两数相除，除数不能为0！！");
        }
        result = NumberA / NumberB;
        return result;

    }
}
