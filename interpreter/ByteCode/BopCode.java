package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {

    private String oper;


    public void init(ArrayList array) {
        oper = (String) array.get(0);
    }


    public void execute(VirtualMachine VM) {
        int Value1 = VM.pop();
        int Value2 = VM.pop();

        if(oper.equals("+")) {
            VM.push(Value1 + Value2);
        }
        else if (oper.equals("-")) {
            VM.push(Value2 - Value1);
        }
        else if(oper.equals("/")) {
            VM.push(Value2 / Value1);
        }
        else if(oper.equals("*")) {
            VM.push(Value1 * Value2);
        }
        else if(oper.equals("==")) {
            if (Value1 == Value2) {
                VM.push(1);
            }
            else {
                VM.push(0);
            }
        }
        else if(oper.equals("!=")) {
            if (Value1 != Value2) {
                VM.push(1);
            }
            else {
                VM.push(0);
            }
        }
        else if(oper.equals("<=")) {
            if (Value2 <= Value1) {
                VM.push(1);
            }
            else {
                VM.push(0);
            }
        }
        else if(oper.equals(">=")) {
            if (Value2 >= Value1) {
                VM.push(1);
            }
            else {
                VM.push(0);
            }
        }
        else if(oper.equals(">")) {
            if (Value2 > Value1) {
                VM.push(1);
            }
            else {
                VM.push(0);
            }
        }
        else if(oper.equals("<")) {
            if (Value2 < Value1) {
                VM.push(1);
            }
            else {
                VM.push(0);
            }
        }
        else if(oper.equals("|")) {
            if (Value1 == 0 || Value2 == 0) {
                VM.push(0);
            }
            else {
                VM.push(1);
            }
        }
        else if(oper.equals("&")) {
            if (Value1 == 1 && Value2 == 1) {
                VM.push(1);
            }
            else {
                VM.push(0);
            }
        }
    }
    public String toString() {
        return "BOP" + oper;
    }
}
