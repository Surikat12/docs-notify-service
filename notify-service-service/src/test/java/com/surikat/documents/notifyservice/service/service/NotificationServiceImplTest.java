package com.surikat.documents.notifyservice.service.service;

import com.surikat.docs.common.exception.DocsServiceException;
import com.surikat.documents.notifyservice.common.dto.NotificationDto;
import com.surikat.documents.notifyservice.common.model.NotificationModel;
import com.surikat.documents.notifyservice.service.TestData;
import com.surikat.documents.notifyservice.service.repository.NotificationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class NotificationServiceImplTest {

    private final NotificationRepository notificationRepository;
    private final NotificationService underTest;

    NotificationServiceImplTest() {
        this.notificationRepository = Mockito.mock(NotificationRepository.class);
        this.underTest = new NotificationServiceImpl(this.notificationRepository);
    }

    @Test
    void notifyTest() throws DocsServiceException {
        NotificationDto notificationDto = TestData.getTestNotificationDto();

        underTest.notify(notificationDto);

        ArgumentCaptor<NotificationModel> argument = ArgumentCaptor.forClass(NotificationModel.class);
        verify(notificationRepository, times(1)).insert(argument.capture());
        assertNotNull(argument.getValue());
        assertEquals(argument.getValue().getProcessId(), notificationDto.getProcessId());
        assertEquals(argument.getValue().getType(), notificationDto.getType());
        assertEquals(argument.getValue().getMessage(), notificationDto.getMessage());
        assertEquals(argument.getValue().getTime(), notificationDto.getTime());
    }
}