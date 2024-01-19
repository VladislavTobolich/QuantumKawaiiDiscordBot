package com.quantumbot.quantumkawaiidiscordbot.config;


import com.quantumbot.quantumkawaiidiscordbot.botcommands.slashcommands.InfoSlashCommand;
import com.quantumbot.quantumkawaiidiscordbot.botcommands.slashcommands.SiGameSlashCommand;
import com.quantumbot.quantumkawaiidiscordbot.botcommands.slashcommands.SlashCommand;
import com.quantumbot.quantumkawaiidiscordbot.botcommands.slashcommands.SlashCommandsDescription;
import com.quantumbot.quantumkawaiidiscordbot.botcommands.tildacommands.HelloTildaCommand;
import com.quantumbot.quantumkawaiidiscordbot.botcommands.tildacommands.TildaCommand;
import com.quantumbot.quantumkawaiidiscordbot.botcommands.tildacommands.TildaCommandsDescription;
import com.quantumbot.quantumkawaiidiscordbot.listeners.DiscordEventListener;
import com.quantumbot.quantumkawaiidiscordbot.listeners.executors.EventExecutor;
import com.quantumbot.quantumkawaiidiscordbot.listeners.executors.OnButtonEventExecute;
import com.quantumbot.quantumkawaiidiscordbot.listeners.executors.OnMessageListenerExecute;
import com.quantumbot.quantumkawaiidiscordbot.listeners.executors.OnSlashCommandInteractionExecutor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySources({
        @PropertySource("classpath:exception.properties")
})
public class BotApplicationConfig {

    @Value("${bot.token}")
    private String botToken;

    @Bean
    public Map<Class<? extends GenericEvent>, EventExecutor>
        eventExecutorMap(OnButtonEventExecute onButtonEventExecute,
                         OnMessageListenerExecute onMessageListenerExecute,
                         OnSlashCommandInteractionExecutor onSlashCommandInteractionExecutor){
        Map<Class<? extends GenericEvent>, EventExecutor> eventExecutorMap = new HashMap<>();
        eventExecutorMap.put(MessageReceivedEvent.class,onMessageListenerExecute);
        eventExecutorMap.put(ButtonInteractionEvent.class,onButtonEventExecute);
        eventExecutorMap.put(SlashCommandInteractionEvent.class,onSlashCommandInteractionExecutor);
        return eventExecutorMap;
    }


    @Bean
    public Map<String, SlashCommand> slashCommandMap(SiGameSlashCommand siGameSlashCommand,
                                                     InfoSlashCommand infoSlashCommand){
        Map<String, SlashCommand> slashCommandMap = new HashMap<>(SlashCommandsDescription.values().length);
        slashCommandMap.put(SlashCommandsDescription.FIND_SIGAME_PACK.getCommandData().getName(),siGameSlashCommand);
        slashCommandMap.put(SlashCommandsDescription.INFO.getCommandData().getName(),infoSlashCommand);
        return slashCommandMap;
    }

    @Bean
    public Map<String, TildaCommand> tildaCommandMap(HelloTildaCommand helloTildaCommand){
        Map<String, TildaCommand> tildaCommandMap = new HashMap<>(TildaCommandsDescription.values().length);
        tildaCommandMap.put(TildaCommandsDescription.HELLO.getCommandName(), helloTildaCommand);
        return tildaCommandMap;
    }


    @Bean
    public JDA createJDABean(DiscordEventListener discordEventListener){
        return JDABuilder.createLight(botToken, Arrays.asList(GatewayIntent.values()))
                .addEventListeners(discordEventListener)
                .build();
    }

}
