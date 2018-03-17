package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {



    private String label;

    @Override
    public void execute(VirtualMachine VM) {
        if(label.equals("ON")) {
            VM.setDumps(true);

        }else if (label.equals("OFF")){
            VM.setDumps(false);
        }
    }

    @Override public void init (ArrayList<String>args) {
        label = args.get(0);
    }

    @Override
    public String toString() {
        return "DUMP" + label;
    }
}
