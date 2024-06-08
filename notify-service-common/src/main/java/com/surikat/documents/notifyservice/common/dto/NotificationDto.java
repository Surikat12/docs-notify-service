package com.surikat.documents.notifyservice.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.surikat.documents.notifyservice.common.NotificationType;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationDto {

    @JsonProperty("process_id")
    private UUID processId;
    private NotificationType type;
    private String message;
    private LocalDateTime time;

    public UUID getProcessId() {
        return processId;
    }

    public NotificationDto withProcessId(UUID processId) {
        this.processId = processId;
        return this;
    }

    public NotificationType getType() {
        return type;
    }

    public NotificationDto withType(NotificationType type) {
        this.type = type;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public NotificationDto withMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public NotificationDto withTime(LocalDateTime time) {
        this.time = time;
        return this;
    }
}
