package com.franbarona.notification_service.repository;

import com.franbarona.notification_service.domain.Notification;
import com.franbarona.notification_service.domain.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, String> {

    List<Notification> findByRecipientIdOrderByCreatedAtDesc(String recipientId);

    List<Notification> findByRecipientIdAndStatusOrderByCreatedAtDesc(String recipientId, NotificationStatus status);
}