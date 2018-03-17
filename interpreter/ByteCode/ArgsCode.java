package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {

    int value;

    public void init(ArrayList<String> args){
        this.value = Integer.parseInt(args.get(0));

    }

    public void execute(VirtualMachine VM){

        VM.newFrameAt(value);

    }
    public String toString() {
        return "ARGS" + value;
    }

}
