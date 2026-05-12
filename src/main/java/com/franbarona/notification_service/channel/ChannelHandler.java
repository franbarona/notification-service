package com.franbarona.notification_service.channel;

import com.franbarona.notification_service.domain.Notification;

public interface ChannelHandler {
    void handle(Notification notification);
}