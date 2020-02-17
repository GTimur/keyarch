﻿

  CREATE TABLE "XXI"."SZFLOW" 
   (	"IRECID" NUMBER(12,0) NOT NULL ENABLE, 
	"DREGDATE" DATE NOT NULL ENABLE, 
	"ICLICUSID" NUMBER(12,0) NOT NULL ENABLE, 
	"CNEKTYPE" VARCHAR2(100), 
	"CNEKSN" VARCHAR2(100), 
	"CCNFRMTYPE" VARCHAR2(100), 
	"CCNFRMSN" VARCHAR2(100), 
	"DCLILNK" DATE DEFAULT NULL, 
	"IKEYNUM" NUMBER(12,0) DEFAULT NULL, 
	"CCOMMENT" VARCHAR2(1024) DEFAULT NULL, 
	"RECSTATE" NUMBER(*,0) DEFAULT 1, 
	 CONSTRAINT "SZFLOW_IRECID" PRIMARY KEY ("IRECID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "XXI"."SZFLOW"."IRECID" IS 'ID записи';
   COMMENT ON COLUMN "XXI"."SZFLOW"."DREGDATE" IS 'Дата выдачи средств';
   COMMENT ON COLUMN "XXI"."SZFLOW"."ICLICUSID" IS 'ID клиента (внутр.)';
   COMMENT ON COLUMN "XXI"."SZFLOW"."CNEKTYPE" IS 'Тип НЭК (usb-токен)';
   COMMENT ON COLUMN "XXI"."SZFLOW"."CNEKSN" IS 's/n НЭК (usb-токен)';
   COMMENT ON COLUMN "XXI"."SZFLOW"."CCNFRMTYPE" IS 'Тип средства подтверждения (otp-токен)';
   COMMENT ON COLUMN "XXI"."SZFLOW"."CCNFRMSN" IS 's/n средства подтверждения (otp-токен)';
   COMMENT ON COLUMN "XXI"."SZFLOW"."DCLILNK" IS 'Дата привязки к клиенту';
   COMMENT ON COLUMN "XXI"."SZFLOW"."IKEYNUM" IS 'ID записи (связь с другой строкой журнала)';
   COMMENT ON COLUMN "XXI"."SZFLOW"."CCOMMENT" IS 'Примечание';
   COMMENT ON COLUMN "XXI"."SZFLOW"."RECSTATE" IS 'состояние записи: 1=активна, 2=удалена';
   COMMENT ON TABLE "XXI"."SZFLOW"  IS 'Таблица учета выданных средств подтверждения клиенту (OTP)';
