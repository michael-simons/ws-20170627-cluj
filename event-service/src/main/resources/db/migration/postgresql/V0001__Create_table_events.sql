create table events (
    id                 serial primary key,
    held_on            timestamp with time zone not null,
    name               varchar(512) not null,
    status             varchar(16) not null default 'open',
    created_at timestamp not null DEFAULT current_timestamp,
    CONSTRAINT events_uk UNIQUE (held_on, name)
);
