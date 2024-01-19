package com.quantumbot.quantumkawaiidiscordbot.botcommands.slashcommands;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public enum SlashCommandsDescription {
    FIND_SIGAME_PACK(Commands.slash("sigame", "Find SiGame pack")
            .addOption(OptionType.STRING,"pack_name","Topic for a pack")),
    INFO(Commands.slash("info", "Hello ┬─┬ノ( º _ ºノ)"));
    private final CommandData commandData;

    SlashCommandsDescription(CommandData commandData) {
        this.commandData = commandData;
    }

    public CommandData getCommandData() {
        return commandData;
    }
}
