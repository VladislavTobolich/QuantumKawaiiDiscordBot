package com.quantumbot.quantumkawaiidiscordbot.botcommands.tildacommands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface TildaCommand {
    void execute(MessageReceivedEvent messageReceivedEvent);
}
