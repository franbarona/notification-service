package com.franbarona.notification_service.service;

import com.franbarona.notification_service.domain.Notification;
import com.franbarona.notification_service.event.NotificationEvent;
import com.franbarona.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final ApplicationEventPublisher eventPublisher;

    public Notification send(String recipientId, String title, String message) {
        Notification notification = Notification.builder()
                .recipientId(recipientId)
                .title(title)
                .message(message)
                .build();

        Notification saved = notificationRepository.save(notification);
        eventPublisher.publishEvent(new NotificationEvent(this, saved));

        return saved;
    }
}