package com.surikat.documents.notifyservice.service.service;

import com.surikat.docs.common.exception.DataBaseException;
import com.surikat.documents.notifyservice.common.model.NotificationModel;
import com.surikat.documents.notifyservice.common.request.NotificationRequest;

public interface NotificationService {

    NotificationModel notify(NotificationRequest notification) throws DataBaseException;
}
