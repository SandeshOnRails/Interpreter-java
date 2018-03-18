
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

        String line;
        ArrayList<String> argsArr = new ArrayList<>();

        program = new Program();

        try {

            line = byteSource.readLine();

            while (line != null) {

                StringTokenizer tokens = new StringTokenizer(line);
                argsArr.clear();
                String ByteNextClass = CodeTable.getClassName(tokens.nextToken());
                ByteCode bytecode = (ByteCode) (Class.forName("interpreter.ByteCode." + ByteNextClass).newInstance());

                while (tokens.hasMoreTokens()) {
                    argsArr.add(tokens.nextToken());
                }


                bytecode.init(argsArr);
                program.addByteCode(bytecode);
                line = byteSource.readLine();

            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        program.resolveAddrs(program);
        return program;
    }
}
