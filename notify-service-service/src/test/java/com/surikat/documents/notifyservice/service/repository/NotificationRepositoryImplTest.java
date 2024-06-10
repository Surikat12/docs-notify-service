package com.surikat.documents.notifyservice.service.repository;

import com.surikat.documents.notifyservice.common.model.NotificationModel;
import com.surikat.documents.notifyservice.service.TestData;
import com.surikat.documents.notifyservice.service.mapper.NotificationMapper;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import static com.surikat.documents.notifyservice.service.codegen.jooq.tables.Notification.NOTIFICATION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        Long testId = 1L;
        NotificationModel notification = TestData.getTestNotificationModel();
        when(jooqContext.insertInto(NOTIFICATION)
                .set(NOTIFICATION.PROCESS_ID, notification.getProcessId())
                .set(NOTIFICATION.TYPE, notification.getType().toString())
                .set(NOTIFICATION.MESSAGE, notification.getMessage())
                .set(NOTIFICATION.TIME, notification.getTime())
                .returningResult(NOTIFICATION.ID, NOTIFICATION.PROCESS_ID, NOTIFICATION.TYPE, NOTIFICATION.MESSAGE, NOTIFICATION.TIME)
                .fetchOne(any(NotificationMapper.class)))
                .thenReturn(TestData.getTestNotificationModelWithId(testId));

        NotificationModel returnedModel = underTest.insert(notification);

        assertNotNull(returnedModel);
        assertEquals(returnedModel.getId(), testId);
        assertEquals(returnedModel.getProcessId(), notification.getProcessId());
        assertEquals(returnedModel.getType(), notification.getType());
        assertEquals(returnedModel.getMessage(), notification.getMessage());
        assertEquals(returnedModel.getTime(), notification.getTime());
    }
}