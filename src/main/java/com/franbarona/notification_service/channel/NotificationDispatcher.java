package com.franbarona.notification_service.channel;

import com.franbarona.notification_service.event.NotificationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NotificationDispatcher {

    private final List<ChannelHandler> handlers;

    @EventListener
    public void onNotificationEvent(NotificationEvent event) {
        handlers.forEach(handler -> handler.handle(event.getNotification()));
    }
}