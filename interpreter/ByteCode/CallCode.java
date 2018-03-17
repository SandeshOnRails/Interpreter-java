package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {

    private String label;
    private int addr;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine VM) {
        VM.pushReturnAddrs();
        VM.setPC(addr);
    }

    public String getLabel() {
        return label;
    }

    public void setAddress(Integer x) {
        this.addr = x;
    }

    @Override
    public String toString(){
        return "CALL " + label;
    }
}
