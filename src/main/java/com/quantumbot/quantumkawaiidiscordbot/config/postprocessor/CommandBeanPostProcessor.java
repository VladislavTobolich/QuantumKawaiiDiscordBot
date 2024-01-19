package com.quantumbot.quantumkawaiidiscordbot.config.postprocessor;

import com.quantumbot.quantumkawaiidiscordbot.botcommands.slashcommands.SlashCommandsDescription;
import net.dv8tion.jda.api.JDA;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class CommandBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof JDA jda){
            jda.updateCommands()
                    .addCommands(Arrays
                            .stream(SlashCommandsDescription.values())
                            .map(SlashCommandsDescription::getCommandData).toList()).queue();
        }
        return bean;
    }
}
