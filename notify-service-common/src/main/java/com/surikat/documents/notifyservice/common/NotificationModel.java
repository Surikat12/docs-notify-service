package com.surikat.documents.notifyservice.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationModel {
    private Long id;
    @JsonProperty("process_id")
    private UUID processId;
    private NotificationType type;
    private String message;
    private LocalDateTime time;

    public Long getId() {
        return id;
    }

    public NotificationModel withId(Long id) {
        this.id = id;
        return this;
    }

    public UUID getProcessId() {
        return processId;
    }

    public NotificationModel withProcessId(UUID processId) {
        this.processId = processId;
        return this;
    }

    public NotificationType getType() {
        return type;
    }

    public NotificationModel withType(NotificationType type) {
        this.type = type;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public NotificationModel withMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public NotificationModel withTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    @Override
    public String toString() {
        return "NotificationModel{" +
                "id=" + id +
                ", processId=" + processId +
                ", type=" + type +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
