drop table if exists USER_ENTITY;
drop table if exists REALM_ATTRIBUTE;
drop table if exists REALM;

create table REALM (
  ID         varchar(36)           not null primary key,
  NAME       varchar(255) unique   not null,
  ENABLED    boolean default false not null,
  NOT_BEFORE integer
);

create table REALM_ATTRIBUTE (
  NAME     varchar(255) not null,
  VALUE    varchar(255),
  REALM_ID varchar(36)  not null references REALM,
  primary key (NAME, REALM_ID)
);

create table USER_ENTITY (
  ID         varchar(36)           not null primary key,
  REALM_ID   varchar(255)          not null,
  USERNAME   varchar(255)          not null,
  PASSWORD   varchar(255)          not null,
  FIRST_NAME varchar(255),
  LAST_NAME  varchar(255),
  EMAIL      varchar(255),
  ENABLED    boolean default false not null,
  constraint USER_ENTITY_UNIQUE unique (REALM_ID, USERNAME)
);
