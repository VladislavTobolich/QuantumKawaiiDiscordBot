package com.quantumbot.quantumkawaiidiscordbot.botcommands.tildacommands;

public enum TildaCommandsDescription {
    HELLO("~hello");

    private final String commandName;

    TildaCommandsDescription(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
