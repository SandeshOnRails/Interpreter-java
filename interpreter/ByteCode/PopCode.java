package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode{

    private int val;

    public void init(ArrayList<String> args) {
        val = Integer.parseInt(args.get(0));
    }

    public void execute(VirtualMachine VM) {
        for(int i = 0; i < val; i++) {
            VM.pop();
        }
    }

    public String toString() {
        return "POP " + val;
    }
}
