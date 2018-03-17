package interpreter.ByteCode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class HaltCode extends ByteCode {


    public void execute (VirtualMachine VM) {
        VM.halt();
    }

    public void init(ArrayList<String> args) {

    }
    public String toString() {
        return "HALT";
    }


}
