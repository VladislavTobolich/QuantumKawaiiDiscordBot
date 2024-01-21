package com.quantumbot.quantumkawaiidiscordbot.service.executors;

import com.quantumbot.quantumkawaiidiscordbot.botcommands.slashcommands.SlashCommand;
import jakarta.validation.constraints.NotNull;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OnSlashCommandInteractionExecutor implements EventExecutor{
    private final Map<String, SlashCommand> slashCommandMap;

    @Autowired
    public OnSlashCommandInteractionExecutor(@Qualifier("slashCommandMap") Map<String, SlashCommand> slashCommandMap) {
        this.slashCommandMap = slashCommandMap;
    }

    @Override
    public void execute(@NotNull GenericEvent event) {
        if(event instanceof SlashCommandInteractionEvent slashCommandInteractionEvent){
            this.slashCommandMap.getOrDefault(slashCommandInteractionEvent.getName(),(anyEvent)->{/*will exception*/})
                    .execute(slashCommandInteractionEvent);
        }
    }
}
