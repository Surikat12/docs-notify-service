package com.surikat.documents.notifyservice.client;

import com.surikat.docs.common.exception.MicroserviceMethodErrorException;
import com.surikat.docs.common.model.MicroserviceSetting;
import com.surikat.docs.common.service.AbstractDocsClient;
import com.surikat.docs.common.service.MicroserviceDiscoveryFacade;
import com.surikat.documents.notifyservice.common.model.NotificationModel;
import com.surikat.documents.notifyservice.common.request.NotificationRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import static com.surikat.documents.notifyservice.common.MethodConst.POST_NOTIFICATION;

public class NotifyServiceClientImpl extends AbstractDocsClient implements NotifyServiceClient {

    protected static final MicroserviceSetting MS = MicroserviceSetting.MICROSERVICE_DOCS_NOTIFY_SERVICE;
    private static final Logger LOGGER = LogManager.getLogger();
    private final RestTemplate restTemplate;
    private final MicroserviceDiscoveryFacade microserviceFacade;

    public NotifyServiceClientImpl(RestTemplateBuilder restTemplateBuilder,
                                   MicroserviceDiscoveryFacade microserviceFacade) {
        this.restTemplate = restTemplateBuilder.build();
        this.microserviceFacade = microserviceFacade;
    }

    @Override
    public NotificationModel notify(NotificationRequest notificationRequest) throws MicroserviceMethodErrorException {
        LOGGER.info("POST_NOTIFICATION started with notificationRequest={}", notificationRequest.toString());

        String url = microserviceFacade.compose(MS, POST_NOTIFICATION, null);
        return handleExchange(url, "POST_NOTIFICATION",
                () -> restTemplate.exchange(url, HttpMethod.POST,
                        new HttpEntity<>(notificationRequest, getDefaultHeaders()),
                        new ParameterizedTypeReference<NotificationModel>() {}));
    }

    private HttpHeaders getDefaultHeaders() {
        return new HttpHeaders();
    }

    @Override
    protected MicroserviceSetting getMS() {
        return MS;
    }

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
}
