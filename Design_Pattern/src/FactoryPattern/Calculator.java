package FactoryPattern;

import java.util.Scanner;


public class Calculator {

    public static void main(String[] args) {
        String strNumberA = null;
        String strNumberB = null;
        String strOperate = null;
        try{
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入数字A：");
            strNumberA = scan.nextLine();
            System.out.println("请选择运算符号（+、-、*、/）：");
            strOperate = scan.nextLine();
            System.out.println("请输入数字B：");
            strNumberB = scan.nextLine();

            double Result;

            Operation oper;
            oper = OperationFactory.createOperate(strOperate);
            oper.setNumberA(Double.parseDouble(strNumberA));
            oper.setNumberB(Double.parseDouble(strNumberB));

            Result = oper.GetResult();

//            strResult = String.valueOf(GetResult(Double.parseDouble(strNumberA),Double.parseDouble(strNumberB),strOperate));

            System.out.println(Result);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
