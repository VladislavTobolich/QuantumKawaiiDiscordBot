package com.quantumbot.quantumkawaiidiscordbot.listeners;

import com.quantumbot.quantumkawaiidiscordbot.service.executors.EventExecutor;
import jakarta.validation.constraints.NotNull;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DiscordEventListener implements EventListener {
    private final Map<Class<? extends GenericEvent>, EventExecutor> eventExecutorMap;
    @Value("${bad.event.exception.message}")
    private String exceptionMessage;

    @Autowired
    public DiscordEventListener(Map<Class<? extends GenericEvent>, EventExecutor> eventExecutorMap) {
        this.eventExecutorMap = eventExecutorMap;
    }

    @Override
    public void onEvent(@NotNull GenericEvent event) {
        this.eventExecutorMap.getOrDefault(event.getClass(),
                (anyEvent)->{/*exception*/}).execute(event);
    }
}
