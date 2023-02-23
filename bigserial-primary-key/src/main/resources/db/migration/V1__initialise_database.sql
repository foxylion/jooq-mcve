DROP SCHEMA IF EXISTS mcve CASCADE;

CREATE SCHEMA mcve;

CREATE TABLE mcve.segment
(
    id     bigserial    not null,
    start  int4         not null,
    finish int4         not null,
    value  float4       not null,
    code   varchar(128) not null unique,
    primary key (id)
);
