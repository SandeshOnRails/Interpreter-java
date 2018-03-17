package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {

    private String literalVal;
    private int val;

    public void init (ArrayList<String> args){
        if (args.size() != 1) {
            val = Integer.parseInt((String)args.get(0));
            literalVal = (String)args.get(args.size() -1);
        }
        else {
            val= Integer.parseInt((String)args.get(0));
        }
    }

    public void execute(VirtualMachine VM) {
        VM.load(val);
    }

    public String toString() {
        return "LOAD " + val + " " + literalVal;
    }
}
