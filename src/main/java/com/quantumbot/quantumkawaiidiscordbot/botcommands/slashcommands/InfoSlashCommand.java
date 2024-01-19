package com.quantumbot.quantumkawaiidiscordbot.botcommands.slashcommands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.springframework.stereotype.Component;

@Component
public class InfoSlashCommand implements SlashCommand{
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply(String.format("Hello %s ┬─┬ノ( º _ ºノ)",event.getUser().getName())).queue();
    }
}
