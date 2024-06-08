package com.surikat.documents.notifyservice.service.service;

import com.surikat.documents.notifyservice.common.dto.NotificationDto;
import com.surikat.documents.notifyservice.common.model.NotificationModel;
import com.surikat.documents.notifyservice.service.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void notify(NotificationDto notificationDto) {
        NotificationModel notificationModel = new NotificationModel()
                .withProcessId(notificationDto.getProcessId())
                .withType(notificationDto.getType())
                .withMessage(notificationDto.getMessage())
                .withTime(notificationDto.getTime());
        notificationRepository.insert(notificationModel);
    }
}
