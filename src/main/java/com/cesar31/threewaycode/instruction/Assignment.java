package com.cesar31.threewaycode.instruction;

import java.util.List;

/**
 *
 * @author cesar31
 */
public class Assignment implements Instruction {

    private String id;
    private Operation operation;

    public Assignment(String id, Operation operation) {
        this.id = id;
        this.operation = operation;
    }

    @Override
    public Object run(List<Integer> list) {
        System.out.println(id + " = " + operation.run(list) + "\n");
        return null;
    }
}
