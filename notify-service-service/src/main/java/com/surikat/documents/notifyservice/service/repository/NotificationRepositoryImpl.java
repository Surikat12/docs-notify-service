package com.surikat.documents.notifyservice.service.repository;

import com.surikat.documents.notifyservice.common.NotificationModel;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.surikat.documents.notifyservice.service.codegen.jooq.tables.Notification.NOTIFICATION;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {

    private final DSLContext jooqContext;

    public NotificationRepositoryImpl(DSLContext jooqContext) {
        this.jooqContext = jooqContext;
    }

    public void insert(NotificationModel notification) {
        jooqContext.insertInto(NOTIFICATION)
                .set(NOTIFICATION.ID, notification.getId())
                .set(NOTIFICATION.PROCESS_ID, notification.getProcessId())
                .set(NOTIFICATION.TYPE, notification.getType().toString())
                .set(NOTIFICATION.MESSAGE, notification.getMessage())
                .set(NOTIFICATION.TIME, notification.getTime())
                .execute();
    }
}