package com.example.tarea3;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tarea3 {

    ArrayList<Float> Stack = new ArrayList<>();


    @RequestMapping("/")
    public ArrayList<Float> print() {
        return printStack();
    }

    @RequestMapping("/push")
    public String add(Float num1) {
        push(num1);
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



    public ArrayList<Float> printStack() {
        return Stack;
    }

    public void push(float element) {
        Stack.add(element);
    }

    public void pop() {
        if (Stack.size() > 0) {
            Stack.remove(0);
        }
    }

    public void clear() {
        Stack.removeAll(Stack);
    }
}
