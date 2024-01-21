package com.quantumbot.quantumkawaiidiscordbot.service.executors;

import com.quantumbot.quantumkawaiidiscordbot.botcommands.tildacommands.TildaCommand;
import jakarta.validation.constraints.NotNull;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OnMessageListenerExecute implements EventExecutor {

    private final Map<String, TildaCommand> tildaCommandMap;

    @Autowired
    public OnMessageListenerExecute(@Qualifier("tildaCommandMap") Map<String, TildaCommand> tildaCommandMap) {
        this.tildaCommandMap = tildaCommandMap;
    }

    @Override
    public void execute(@NotNull GenericEvent event) {
        if(event instanceof MessageReceivedEvent messageReceivedEvent){
            if(messageReceivedEvent.getAuthor().isBot()){
                return;
            }
            Message message = messageReceivedEvent.getMessage();
            tildaCommandMap.getOrDefault(message.getContentDisplay(),
                    (anyEvent)->{/*will exception*/}).execute(messageReceivedEvent);
        }
    }
}
