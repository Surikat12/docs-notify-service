package com.surikat.documents.notifyservice.service.service;

import com.surikat.docs.common.exception.DocsServiceException;
import com.surikat.documents.notifyservice.common.dto.NotificationDto;
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
    public void notify(NotificationDto notificationDto) throws DocsServiceException {
        LOGGER.debug("notify method started with notification={}", notificationDto.toString());
        NotificationModel notificationModel = new NotificationModel()
                .withProcessId(notificationDto.getProcessId())
                .withType(notificationDto.getType())
                .withMessage(notificationDto.getMessage())
                .withTime(notificationDto.getTime());
        try {
            notificationRepository.insert(notificationModel);
        } catch (Exception ex) {
            throw new DocsServiceException(ex.toString());
        }
    }
}
