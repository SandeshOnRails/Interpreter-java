package interpreter;

import interpreter.ByteCode.ByteCode;
import interpreter.ByteCode.DumpCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean isDumping;


    protected VirtualMachine(Program program) {

        this.program = program;
    }
    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            System.out.println(code.toString());
            this.dumping(code);
            pc++;

        }
    }



    public void newFrameAt(int off) {
        runStack.newFrameAt(off);
    }

    public int pop() {
        return runStack.pop();
    }

    public int push(int i) {
        return runStack.push(i);
    }

    public void pushReturnAddrs() {
        returnAddrs.push(pc);
    }

    public void setPC(int address) {
        pc = address;
    }

    public void halt() {
        isRunning = false;
    }

    public int load(int xVal) {
        return runStack.load(xVal);
    }

    public int store(int xVal) {
        return runStack.store(xVal);
    }

    public int popReturnAddrs() {
        return returnAddrs.pop();
    }

    public void popFrame() {
        runStack.popFrame();
    }

    public int peek() {
        return runStack.peek();
    }

    public void setDumps(boolean b) {
        this.isDumping = b;
    }

    private void dumping(ByteCode code) {
        if(isDumping && !(code instanceof DumpCode)) {
            runStack.dump();
        }
    }

}


