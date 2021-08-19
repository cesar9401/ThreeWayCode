package com.cesar31.threewaycode.instruction;

import java.util.List;

/**
 *
 * @author cesar31
 */
public class Operation implements Instruction {

    private String type;
    private String value;
    private Operation left;
    private Operation right;
    
    private int i;
    private String l, r;

    // Para integer y id
    public Operation(String type, String value) {
        this.type = type;
        this.value = value;
    }

    // Operaciones unarias
    public Operation(String type, Operation left) {
        this.type = type;
        this.left = left;
    }

    public Operation(String type, Operation left, Operation right) {
        this.type = type;
        this.left = left;
        this.right = right;
    }

    private void checkValues(List<Integer> list) {
        l = left.run(list);
        r = right.run(list);
        i = list.size() + 1;
        list.add(i);
    }
    
    @Override
    public String run(List<Integer> list) {
        switch (type) {
            case "integer":
                return value;
            case "id":
                return value;
            case "uminus":
                l = left.run(list);
                i = list.size() + 1;
                System.out.println("t" + i + " = -" + l);
                list.add(i);
                return "t" + i;
            case "plus":
                checkValues(list);
                System.out.println("t" + i + " = " + l + " + " + r);
                return "t" + i;
            case "minus":
                checkValues(list);
                System.out.println("t" + i + " = " + l + " - " + r);
                return "t" + i;
            case "times":
                checkValues(list);
                System.out.println("t" + i + " = " + l + " * " + r);
                return "t" + i;
            case "divide":
                checkValues(list);
                System.out.println("t" + i + " = " + l + " / " + r);
                return "t" + i;
        }

        return null;
    }

}
