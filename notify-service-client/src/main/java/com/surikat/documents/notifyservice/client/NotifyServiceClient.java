package com.surikat.documents.notifyservice.client;

import com.surikat.docs.common.exception.MicroserviceMethodErrorException;
import com.surikat.documents.notifyservice.common.model.NotificationModel;
import com.surikat.documents.notifyservice.common.request.NotificationRequest;

public interface NotifyServiceClient {
    public NotificationModel notify(NotificationRequest notification) throws MicroserviceMethodErrorException;
}
