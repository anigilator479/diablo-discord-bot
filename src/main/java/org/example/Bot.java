package org.example;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Bot extends ListenerAdapter {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        scheduler.scheduleAtFixedRate(() -> {
            sendMessageIfScheduledTime(event.getJDA().getTextChannelById("1205540996159373315"), Calendar.TUESDAY, 14, 30, "Ваше сообщение для вторника в 14:30");
            sendMessageIfScheduledTime(event.getJDA().getTextChannelById("1205540996159373315"), Calendar.THURSDAY, 18, 30, "Ваше сообщение для четверга в 18:30");
            sendMessageIfScheduledTime(event.getJDA().getTextChannelById("1205540996159373315"), Calendar.SATURDAY, 22, 30, "Ваше сообщение для субботы в 22:30");
        }, 0, 1, TimeUnit.MINUTES);
    }

    private void sendMessageIfScheduledTime(TextChannel channel, int targetDayOfWeek, int hour, int minute, String message) {
        Calendar now = Calendar.getInstance(TimeZone.getTimeZone("Europe/Kiev"));
        int currentDayOfWeek = now.get(Calendar.DAY_OF_WEEK);

        if (currentDayOfWeek == targetDayOfWeek && now.get(Calendar.HOUR_OF_DAY) == hour && now.get(Calendar.MINUTE) == minute) {
            channel.sendMessage(message).queue();
        }
    }
}
