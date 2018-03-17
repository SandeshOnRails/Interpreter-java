package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {

    private String value;
    public void execute(VirtualMachine VM){

        VM.setPC(VM.popReturnAddrs());
        VM.popFrame();
    }
    public void init (ArrayList<String> args) {
        if(!args.isEmpty()) {
            value = args.get(0);
        }
    }

    public String toString(){
        return "RETURN " + value;
    }
}
