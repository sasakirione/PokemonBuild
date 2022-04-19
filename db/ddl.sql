create table "user"
(
    token   varchar,
    icon    varchar,
    id      serial
        constraint user_pk
            primary key,
    profile varchar,
    url     varchar,
    name    varchar not null
);

alter table "user"
    owner to sasakirione;

create table build
(
    id                   serial
        constraint build_pk
            primary key,
    building_name        varchar,
    building_explanation varchar,
    user_id              integer
        constraint "user"
            references "user"
);

alter table build
    owner to sasakirione;

create table building_pokemon
(
    id          serial
        constraint building_pokemon_pk
            primary key,
    building_id integer
        constraint building
            references build,
    pokemon_id  integer not null,
    ev_h        integer default 0,
    ev_a        integer default 0,
    ev_b        integer default 0,
    ev_c        integer default 0,
    ev_d        integer default 0,
    ev_s        integer default 0,
    iv_h        integer default 31,
    iv_a        integer default 31,
    iv_b        integer default 31,
    iv_c        integer default 31,
    iv_d        integer default 31,
    iv_s        integer default 31,
    good_id     integer not null,
    ability_id  integer not null,
    nature_id   integer not null,
    shiny       boolean default false
);

alter table building_pokemon
    owner to sasakirione;

create table building_memo
(
    id          serial
        constraint building_memo_pk
            primary key,
    building_id integer
        constraint building
            references build,
    type        integer default 1 not null,
    value       varchar
);

alter table building_memo
    owner to sasakirione;

