package com.quantumbot.quantumkawaiidiscordbot.botcommands.buttonsevents;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public interface ButtonEvent {
    void onClick(ButtonInteractionEvent event);
}
