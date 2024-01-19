package com.quantumbot.quantumkawaiidiscordbot.listeners.executors;

import jakarta.validation.constraints.NotNull;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import org.springframework.stereotype.Component;

@Component
public class OnButtonEventExecute implements EventExecutor {
    @Override
    public void execute(@NotNull GenericEvent event) {
        if(event instanceof ButtonInteractionEvent buttonInteractionEvent){
            if (buttonInteractionEvent.getComponentId().equals("next")) {
                buttonInteractionEvent.editMessage("").queue();// send a message in the channel
            } else if (buttonInteractionEvent.getComponentId().equals("prev")) {
                buttonInteractionEvent.editMessage("").queue();// update the message
            }
        }
    }
}
