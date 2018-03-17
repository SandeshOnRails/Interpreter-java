package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {

    private String literalVal;
    private int val;

    @Override
    public void execute (VirtualMachine VM) {
        VM.store(val);
    }
    @Override
    public void init(ArrayList<String> args) {
        if(args.size() != 1) {
            String temp = (String)args.get(0);
            val = Integer.parseInt(temp);
            literalVal = (args.get(args.size() -1));
        }else {
            val= Integer.parseInt(args.get(0));
        }
    }
    @Override
    public String toString() {
        return "STORE "+ val + " " + literalVal;
    }
}
