package com.franbarona.notification_service.channel;

import com.franbarona.notification_service.domain.Notification;
import com.franbarona.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InAppChannelHandler implements ChannelHandler {

    private final NotificationRepository notificationRepository;

    @Override
    public void handle(Notification notification) {
        try {
            notification.markAsSent();
            notificationRepository.save(notification);
            log.info("In-app notification sent to recipient: {}", notification.getRecipientId());
        } catch (Exception e) {
            notification.markAsFailed();
            notificationRepository.save(notification);
            log.error("Failed to handle in-app notification: {}", e.getMessage());
        }
    }
}