package com.surikat.documents.notifyservice.service.controller;

import com.surikat.docs.common.controller.AbstractApiController;
import com.surikat.documents.notifyservice.common.dto.NotificationDto;
import com.surikat.documents.notifyservice.service.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.surikat.documents.notifyservice.common.MethodConst.*;

@RestController
@RequestMapping("/v1")
public class NotificationV1Controller extends AbstractApiController {

    private final NotificationService notificationService;

    public NotificationV1Controller(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping(value = POST_NOTIFICATION, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void notify(@RequestBody NotificationDto notification) {
        notificationService.notify(notification);
    }
}
