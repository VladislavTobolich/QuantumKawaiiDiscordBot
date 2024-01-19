package com.quantumbot.quantumkawaiidiscordbot.botcommands.slashcommands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.springframework.stereotype.Component;

@Component
public class SiGameSlashCommand implements SlashCommand{
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply("Later...")
                .addActionRow(
                        Button.primary("prev", "Prev"),
                        Button.primary("next", "Next")) // Button with only an emoji
                .queue();
    }
}
