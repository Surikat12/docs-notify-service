package com.surikat.documents.notifyservice.service.service;

import com.surikat.docs.common.exception.DataBaseException;
import com.surikat.documents.notifyservice.common.request.NotificationRequest;
import com.surikat.documents.notifyservice.common.model.NotificationModel;
import com.surikat.documents.notifyservice.service.TestData;
import com.surikat.documents.notifyservice.service.repository.NotificationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class NotificationServiceImplTest {

    private final NotificationRepository notificationRepository;
    private final NotificationService underTest;

    NotificationServiceImplTest() {
        this.notificationRepository = Mockito.mock(NotificationRepository.class);
        this.underTest = new NotificationServiceImpl(this.notificationRepository);
    }

    @Test
    void notifyTest() throws DataBaseException {
        Long testId = 1L;
        NotificationRequest notificationRequest = TestData.getTestNotificationRequest();
        when(notificationRepository.insert(any(NotificationModel.class)))
                .thenReturn(TestData.getTestNotificationModelWithId(testId));

        NotificationModel returnedModel = underTest.notify(notificationRequest);

        ArgumentCaptor<NotificationModel> argument = ArgumentCaptor.forClass(NotificationModel.class);
        verify(notificationRepository, times(1)).insert(argument.capture());
        assertNotNull(argument.getValue());
        assertEquals(argument.getValue().getProcessId(), notificationRequest.getProcessId());
        assertEquals(argument.getValue().getType(), notificationRequest.getType());
        assertEquals(argument.getValue().getMessage(), notificationRequest.getMessage());
        assertEquals(argument.getValue().getTime(), notificationRequest.getTime());

        assertNotNull(returnedModel);
        assertEquals(returnedModel.getId(), testId);
        assertEquals(returnedModel.getProcessId(), notificationRequest.getProcessId());
        assertEquals(returnedModel.getType(), notificationRequest.getType());
        assertEquals(returnedModel.getMessage(), notificationRequest.getMessage());
        assertEquals(returnedModel.getTime(), notificationRequest.getTime());
    }
}