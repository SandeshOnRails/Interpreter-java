package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {


    private String label;


    public void init(ArrayList<String> array) {
        label =  array.get(0);
    }


    public void execute(VirtualMachine VM) {
    }

    public String getLabel() {
        return label;
    }


    public String toString() {
        return "LABEL " + label;
    }
}
