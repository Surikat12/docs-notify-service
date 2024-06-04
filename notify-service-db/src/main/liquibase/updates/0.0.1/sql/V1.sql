DROP TABLE IF EXISTS "notify-service".notification;

CREATE TABLE "notify-service".notification (
	id int8 GENERATED ALWAYS AS IDENTITY NOT NULL,
	process_id uuid NOT NULL,
	"type" varchar(16) NOT NULL,
	message varchar NOT NULL,
	"time" timestamp NOT NULL,
	CONSTRAINT notification_pk PRIMARY KEY (id)
);

COMMENT ON TABLE "notify-service".notification IS 'Таблица для хранения уведомлений';
COMMENT ON COLUMN "notify-service".notification.id IS 'Уникальный идентификатор уведомления';
COMMENT ON COLUMN "notify-service".notification.process_id IS 'Идентификатор процесса, к которому относится уведомление';
COMMENT ON COLUMN "notify-service".notification."type" IS 'Тип уведомления';
COMMENT ON COLUMN "notify-service".notification.message IS 'Сообщение уведомления';
COMMENT ON COLUMN "notify-service".notification."time" IS 'Время отправки уведомления';
