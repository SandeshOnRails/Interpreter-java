package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {




    private String label;
    private int addr;

    public void execute(VirtualMachine VM) {
        int Values = VM.pop();
        if(Values == 0) {
            VM.setPC(addr);
        }
    }

    public void init(ArrayList<String> args) {
        label =  args.get(0);
    }

    public String getLabel(){
        return label;
    }

    public void setAddress(Integer x){
        this.addr = x;
    }

    public String toString() {
        return "FALSEBRANCH " + label;
    }

}
