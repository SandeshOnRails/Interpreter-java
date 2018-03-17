package interpreter.ByteCode;


import interpreter.VirtualMachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class ReadCode extends ByteCode {

    public void init (ArrayList<String> array){
    }

    public void execute(VirtualMachine VM){

        try {
            BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a Integer: ");
            String line = file.readLine();
            VM.push(Integer.parseInt(line));

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    @Override
    public String toString() {
        return "READ";
    }
}
