package com.surikat.documents.notifyservice.service.repository;

import com.surikat.documents.notifyservice.common.model.NotificationModel;

public interface NotificationRepository {

    void insert(NotificationModel notification);
}
