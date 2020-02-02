package com.example.tarea3;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tarea3 {

    int size = 5;
    String[] stack = new String[size];

    @RequestMapping("/")
    public String[] print() {
        return printStack();
    }

    @RequestMapping("/push")
    public String add(String var) {
        push(var);
        return "Added Successfully";
    }

    @RequestMapping("/pop")
    public String del() {
        pop();
        return "Removed Successfully";
    }

    @RequestMapping("/clear")
    public String erase() {
        clear();
        return "Cleared Stack";
    }



    public String[] printStack() {
        return stack;
    }

    public void push(String element) {
        if (stack[stack.length - 1] == null) {
            int n = 0;
            while (stack[n] != null) {
                n++;
            }
            stack[n] = element;
        }
        else {
            incrSize();
            push(element);
        }
    }

    public void pop() {
        if (stack.length > 0) {
            int n = 0;
            while (stack[n] != null) {
                n++;
            }
            stack[n - 1] = null;
        }
    }

    public void clear() {
        if(stack.length > 5) {
            resetSize();
        }
        for (int i = 0; i < stack.length; i++) {
            stack[i] = null;
        }
    }

    public void incrSize() {
        size = size + 3;
        String[] stack_copy = new String[size];
        for (int i = 0; i < stack.length; i++)
            stack_copy[i] = stack[i];
        stack = stack_copy;
    }

    public void resetSize() {
        size = 5;
        String[] stack_copy = new String[size];
        stack = stack_copy;
    }
}
