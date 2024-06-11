package com.surikat.documents.notifyservice.common.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.surikat.documents.notifyservice.common.NotificationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationRequest {

    @NotNull
    @JsonProperty("process_id")
    private UUID processId;
    @NotNull
    private NotificationType type;
    @NotBlank
    private String message;
    @NotNull
    private LocalDateTime time;

    public UUID getProcessId() {
        return processId;
    }

    public NotificationRequest withProcessId(UUID processId) {
        this.processId = processId;
        return this;
    }

    public NotificationType getType() {
        return type;
    }

    public NotificationRequest withType(NotificationType type) {
        this.type = type;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public NotificationRequest withMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public NotificationRequest withTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    @Override
    public String toString() {
        return "NotificationRequest{" +
                "processId=" + processId +
                ", type=" + type +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
