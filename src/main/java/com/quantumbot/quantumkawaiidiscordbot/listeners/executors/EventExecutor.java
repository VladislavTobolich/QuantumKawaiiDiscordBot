package com.quantumbot.quantumkawaiidiscordbot.listeners.executors;

import net.dv8tion.jda.api.events.GenericEvent;

public interface EventExecutor {
    void execute(GenericEvent event);
}
