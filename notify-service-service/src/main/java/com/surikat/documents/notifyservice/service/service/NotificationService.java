package com.surikat.documents.notifyservice.service.service;

import com.surikat.docs.common.exception.DocsServiceException;
import com.surikat.documents.notifyservice.common.dto.NotificationDto;

public interface NotificationService {

    void notify(NotificationDto notification) throws DocsServiceException;
}
