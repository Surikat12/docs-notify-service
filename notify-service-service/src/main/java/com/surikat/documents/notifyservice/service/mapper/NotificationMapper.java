package com.surikat.documents.notifyservice.service.mapper;

import com.surikat.documents.notifyservice.common.NotificationType;
import com.surikat.documents.notifyservice.common.model.NotificationModel;
import org.jooq.Record;
import org.jooq.RecordMapper;

import static com.surikat.documents.notifyservice.service.codegen.jooq.tables.Notification.NOTIFICATION;

public class NotificationMapper implements RecordMapper<Record, NotificationModel> {
    @Override
    public NotificationModel map(Record record) {
        if (record == null) {
            return null;
        }
        return new NotificationModel()
                .withId(record.get(NOTIFICATION.ID))
                .withProcessId(record.get(NOTIFICATION.PROCESS_ID))
                .withType(NotificationType.valueOf(record.get(NOTIFICATION.TYPE)))
                .withMessage(record.get(NOTIFICATION.MESSAGE))
                .withTime(record.get(NOTIFICATION.TIME));
    }
}
