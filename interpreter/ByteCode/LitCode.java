package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {


    private String LITVALUE = "";
    private int VALUES;

    @Override
    public void init(ArrayList array) {
        VALUES = Integer.parseInt((String) array.get(0));
        if(array.size() > 1) {
            LITVALUE = (String) array.get(array.size() - 1);
        }
    }

    @Override
    public void execute(VirtualMachine VM) {
        if(LITVALUE.equals("")) {
            VM.push(VALUES);
        }
        else {
            VM.push(0);
        }
    }


    @Override
    public String toString() {
        return "LIT " + VALUES + " " + LITVALUE;
    }
}
