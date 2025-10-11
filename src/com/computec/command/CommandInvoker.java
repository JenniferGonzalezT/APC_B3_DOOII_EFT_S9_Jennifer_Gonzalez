package com.computec.command;

public class CommandInvoker {
    public void run(Command command) {
        command.execute();
    }
}
