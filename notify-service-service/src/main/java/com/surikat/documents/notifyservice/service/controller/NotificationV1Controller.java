package com.surikat.documents.notifyservice.service.controller;

import com.surikat.docs.common.controller.AbstractApiController;
import com.surikat.docs.common.exception.DocsServiceException;
import com.surikat.documents.notifyservice.common.model.NotificationModel;
import com.surikat.documents.notifyservice.common.request.NotificationRequest;
import com.surikat.documents.notifyservice.service.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.surikat.documents.notifyservice.common.MethodConst.*;

@RestController
@RequestMapping("/v1")
@Tag(name = "NotificationV1Controller", description = "Контроллер для работы с уведомлениями")
public class NotificationV1Controller extends AbstractApiController {

    private final NotificationService notificationService;

    public NotificationV1Controller(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Operation(description = "Послать уведомление")
    @PostMapping(value = POST_NOTIFICATION, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public NotificationModel notify(@RequestBody NotificationRequest notification) throws DocsServiceException {
        return notificationService.notify(notification);
    }
}
