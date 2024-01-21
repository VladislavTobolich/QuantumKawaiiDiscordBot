package com.quantumbot.quantumkawaiidiscordbot.service.executors;

import net.dv8tion.jda.api.events.GenericEvent;

public interface EventExecutor {
    void execute(GenericEvent event);
}
