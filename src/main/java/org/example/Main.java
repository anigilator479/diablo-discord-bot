package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    public static void main(String[] args) {
        Bot bot = new Bot();
        //Так делать не надо но мне похуй
        String token = "Поставь свой токен";

        JDABuilder.createLight(token)
                .addEventListeners(bot)
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.watching("Porn with your mom"))
                .build();
    }
}