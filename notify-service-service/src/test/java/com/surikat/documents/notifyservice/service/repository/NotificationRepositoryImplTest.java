package com.surikat.documents.notifyservice.service.repository;

import com.surikat.documents.notifyservice.common.model.NotificationModel;
import com.surikat.documents.notifyservice.common.NotificationType;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.surikat.documents.notifyservice.service.codegen.jooq.tables.Notification.NOTIFICATION;
import static org.mockito.Mockito.*;

class NotificationRepositoryImplTest {

    private final NotificationRepository underTest;
    private final DSLContext jooqContext;

    NotificationRepositoryImplTest() {
        this.jooqContext = Mockito.mock(DSLContext.class, Answers.RETURNS_DEEP_STUBS);
        this.underTest = new NotificationRepositoryImpl(this.jooqContext);
    }

    @Test
    void insertNotificationTest() {
        NotificationModel notification = new NotificationModel()
                .withProcessId(UUID.fromString("67e86325-3826-4ccb-886d-356e71b5edb3"))
                .withType(NotificationType.INFO)
                .withMessage("Test message")
                .withTime(LocalDateTime.parse("2024-06-04T12:30"));

        underTest.insert(notification);

        verify(jooqContext.insertInto(NOTIFICATION)
                .set(NOTIFICATION.PROCESS_ID, notification.getProcessId())
                .set(NOTIFICATION.TYPE, notification.getType().toString())
                .set(NOTIFICATION.MESSAGE, notification.getMessage())
                .set(NOTIFICATION.TIME, notification.getTime())
                , times(1)).execute();
    }
}