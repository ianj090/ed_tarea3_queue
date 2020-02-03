package com.example.tarea3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tarea3 {

    int size = 6;
    String[] queue = new String[size];

    @RequestMapping("/")
    public String[] print() {
        return printQueue();
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



    public String[] printQueue() {
        return queue;
    }

    public void push(String person, String money) {
        if (queue[queue.length - 2] == null) {
            int n = 0;
            while (queue[n] != null) {
                n++;
            }
            queue[n] = person;
            queue[n+1] = money;
        }
        else {
            incrSize();
            push(person, money);
        }
    }

    public void pop() {
        if (queue.length > 0) {
            int n = 0;
            for (int i = 0; i < queue.length; i+=2) {
                if (queue[i] != null) {
                    n+=2;
                }
            }
            if (n > 0) {
                queue[n - 1] = null;
                queue[n - 2] = null;
            }
        }
    }

    public void clear() {
        if(queue.length > 6) {
            resetSize();
        }
        for (int i = 0; i < queue.length; i++) {
            queue[i] = null;
        }
    }

    public void incrSize() {
        size = size + 4;
        String[] stack_copy = new String[size];
        for (int i = 0; i < queue.length; i++)
            stack_copy[i] = queue[i];
        queue = stack_copy;
    }

    public void resetSize() {
        size = 6;
        queue = new String[size];
    }
}
