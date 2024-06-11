package com.surikat.documents.notifyservice.service.service;

import com.surikat.docs.common.exception.DocsServiceException;
import com.surikat.documents.notifyservice.common.request.NotificationRequest;
import com.surikat.documents.notifyservice.common.model.NotificationModel;
import com.surikat.documents.notifyservice.service.repository.NotificationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Logger LOGGER = LogManager.getLogger();
    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationModel notify(NotificationRequest notificationRequest) throws DocsServiceException {
        LOGGER.debug("notify method started with notification={}", notificationRequest.toString());
        try {
            NotificationModel notificationModel = new NotificationModel()
                .withProcessId(notificationRequest.getProcessId())
                .withType(notificationRequest.getType())
                .withMessage(notificationRequest.getMessage())
                .withTime(notificationRequest.getTime());

            return notificationRepository.insert(notificationModel);
        } catch (Exception ex) {
            throw new DocsServiceException(ex.toString());
        }
    }
}
