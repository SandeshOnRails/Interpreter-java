
package interpreter;

import interpreter.ByteCode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {

        String ByteNextLine;
        ArrayList<String> tokArray = new ArrayList<>();

        program = new Program();

        try {

            ByteNextLine = byteSource.readLine();

            while (ByteNextLine != null) {

                StringTokenizer numtok = new StringTokenizer(ByteNextLine);
                tokArray.clear();
                String ByteNextClass = CodeTable.getClassName(numtok.nextToken());
                ByteCode byteVal = (ByteCode) (Class.forName("interpreter.ByteCode." + ByteNextClass).newInstance());

                while (numtok.hasMoreTokens()) {
                    tokArray.add(numtok.nextToken());
                }


                byteVal.init(tokArray);
                program.addByteCode(byteVal);
                ByteNextLine = byteSource.readLine();

            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        program.resolveAddrs(program);
        return program;
    }
}
