package com.quantumbot.quantumkawaiidiscordbot.service.executors;

import com.quantumbot.quantumkawaiidiscordbot.botcommands.buttonsevents.ButtonEvent;
import jakarta.validation.constraints.NotNull;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OnButtonEventExecute implements EventExecutor {

    private Map<String, ButtonEvent> buttonEventMap;

    @Autowired
    public OnButtonEventExecute(@Qualifier("buttonEventMap") Map<String, ButtonEvent> buttonEventMap) {
        this.buttonEventMap = buttonEventMap;
    }

    @Override
    public void execute(@NotNull GenericEvent event) {
        if(event instanceof ButtonInteractionEvent buttonInteractionEvent){
            this.buttonEventMap.getOrDefault(buttonInteractionEvent.getComponentId(),
                    (anyEvent)->{/*will exception*/}).onClick(buttonInteractionEvent);
        }
    }
}
