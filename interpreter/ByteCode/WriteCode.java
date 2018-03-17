package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {


    public void execute(VirtualMachine VM) {
        System.out.println(VM.peek());
    }

    public void init (ArrayList<String> args) {

    }
    public String toString() {
        return "WRITE";
    }
}
