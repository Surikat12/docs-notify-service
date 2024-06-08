package com.surikat.documents.notifyservice.service;

import com.surikat.documents.notifyservice.common.NotificationType;
import com.surikat.documents.notifyservice.common.dto.NotificationDto;
import com.surikat.documents.notifyservice.common.model.NotificationModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class TestData {

    public static NotificationModel getTestNotificationModel() {
        return new NotificationModel()
                .withProcessId(UUID.fromString("67e86325-3826-4ccb-886d-356e71b5edb3"))
                .withType(NotificationType.INFO)
                .withMessage("Test message")
                .withTime(LocalDateTime.parse("2024-06-04T12:30"));
    }

    public static NotificationDto getTestNotificationDto() {
        return new NotificationDto()
                .withProcessId(UUID.fromString("67e86325-3826-4ccb-886d-356e71b5edb3"))
                .withType(NotificationType.INFO)
                .withMessage("Test message")
                .withTime(LocalDateTime.parse("2024-06-04T12:30"));
    }
}
