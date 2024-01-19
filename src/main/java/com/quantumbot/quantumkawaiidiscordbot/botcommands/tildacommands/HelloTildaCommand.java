package com.quantumbot.quantumkawaiidiscordbot.botcommands.tildacommands;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;

@Component
public class HelloTildaCommand implements TildaCommand{
    @Override
    public void execute(MessageReceivedEvent messageReceivedEvent) {
        MessageChannel messageChannel = messageReceivedEvent.getChannel();
        messageChannel.sendMessage("Meow ^_^").queue();
    }
}
