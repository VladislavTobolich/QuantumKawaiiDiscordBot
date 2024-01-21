package com.quantumbot.quantumkawaiidiscordbot.botcommands.buttonsevents;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import org.springframework.stereotype.Component;

@Component
public class PrevButtonEvent implements ButtonEvent{
    @Override
    public void onClick(ButtonInteractionEvent event) {
        event.editMessage("").queue();
    }
}
