package com.surikat.documents.notifyservice.service.service;

import com.surikat.docs.common.exception.DataBaseException;
import com.surikat.documents.notifyservice.common.request.NotificationRequest;
import com.surikat.documents.notifyservice.common.model.NotificationModel;
import com.surikat.documents.notifyservice.service.repository.NotificationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Logger LOGGER = LogManager.getLogger();
    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public NotificationModel notify(NotificationRequest notificationRequest) throws DataBaseException {
        LOGGER.debug("notify method started with notification={}", notificationRequest.toString());
        try {
            NotificationModel notificationModel = new NotificationModel()
                .withProcessId(notificationRequest.getProcessId())
                .withType(notificationRequest.getType())
                .withMessage(notificationRequest.getMessage())
                .withTime(notificationRequest.getTime());

            return notificationRepository.insert(notificationModel);
        } catch (Exception e) {
            throw new DataBaseException(e.toString());
        }
    }
}
