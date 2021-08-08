create table resume
(
    uuid      char(36) not null
        constraint resume_pk
            primary key,
    full_name text
);

create table contact
(
    id          serial
        constraint contact_pk
            primary key,
    type        text     not null,
    value       text     not null,
    resume_uuid char(36) not null
        constraint contact_resume_uuid_fk
            references resume
            on update restrict on delete cascade
);
