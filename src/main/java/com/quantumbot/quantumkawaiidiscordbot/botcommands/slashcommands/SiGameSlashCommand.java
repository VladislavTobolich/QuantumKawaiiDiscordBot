package com.quantumbot.quantumkawaiidiscordbot.botcommands.slashcommands;

import com.quantumbot.quantumkawaiidiscordbot.botcommands.buttonsevents.buttonstype.DiscordButton;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.springframework.stereotype.Component;

@Component
public class SiGameSlashCommand implements SlashCommand{
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply("Later...")
                .addActionRow(
                        Button.primary(DiscordButton.PREV.getButtonId(), DiscordButton.PREV.getButtonLabel()),
                        Button.primary(DiscordButton.NEXT.getButtonId(), DiscordButton.NEXT.getButtonLabel())) // Button with only an emoji
                .queue();
    }
}
