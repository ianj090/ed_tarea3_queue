package com.example.tarea3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tarea3 {

    int size = 6;
    String[] stack = new String[size];

    @RequestMapping("/")
    public String[] print() {
        return printStack();
    }

    @RequestMapping("/push")
    public String add(String name, String amount) {
        if (name != null) {
            if (amount != null) {
                push(name, amount);
                return "Added Successfully";
            }
        }
        return "Please add a name and amount";
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

    public void push(String person, String money) {
        if (stack[stack.length - 2] == null) {
            int n = 0;
            while (stack[n] != null) {
                n++;
            }
            stack[n] = person;
            stack[n+1] = money;
        }
        else {
            incrSize();
            push(person, money);
        }
    }

    public void pop() {
        if (stack.length > 0) {
            int n = 0;
            for (int i = 0; i < stack.length; i+=2) {
                if (stack[i] != null) {
                    n+=2;
                }
            }
            if (n > 0) {
                stack[n - 1] = null;
                stack[n - 2] = null;
            }
        }
    }

    public void clear() {
        if(stack.length > 6) {
            resetSize();
        }
        for (int i = 0; i < stack.length; i++) {
            stack[i] = null;
        }
    }

    public void incrSize() {
        size = size + 4;
        String[] stack_copy = new String[size];
        for (int i = 0; i < stack.length; i++)
            stack_copy[i] = stack[i];
        stack = stack_copy;
    }

    public void resetSize() {
        size = 6;
        stack = new String[size];
    }
}
