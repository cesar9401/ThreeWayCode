package com.cesar31.threewaycode.main;

import com.cesar31.threewaycode.instruction.Instruction;
import com.cesar31.threewaycode.parser.ThreeLex;
import com.cesar31.threewaycode.parser.ThreeParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cesar31
 */
public class Main {

    public static void main(String[] args) {
        String data = "";
        if(args.length > 0) {
            data = readData(args[0]);
        } else {
            System.out.println("Ingrese la asignacion/es que desea: ");
            Scanner tmp = new Scanner(System.in);
            data = tmp.nextLine();
        }
        
        ThreeLex lex = new ThreeLex(new StringReader(data));
        ThreeParser parser = new ThreeParser(lex);
        try {
            List<Instruction> instruction = (List<Instruction>) parser.parse().value;
            List<Integer> list = new ArrayList<>();

            for (Instruction i : instruction) {
                i.run(list);
            }

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static String readData(String path) {
        String string = "";
        File file = new File(path);
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while (line != null) {
                    string += "\n" + line;
                    line = br.readLine();
                }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return string;
    }
}
