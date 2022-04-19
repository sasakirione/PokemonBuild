create table pokemon_master."user"
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

alter table pokemon_master."user"
    owner to sasakirione;

create table pokemon_master.build
(
    id                   serial
        constraint build_pk
            primary key,
    building_name        varchar,
    building_explanation varchar,
    user_id              integer
        constraint "user"
            references pokemon_master."user"
);

alter table pokemon_master.build
    owner to sasakirione;

create table pokemon_master.building_memo
(
    id          serial
        constraint building_memo_pk
            primary key,
    building_id integer
        constraint building
            references pokemon_master.build,
    type        integer default 1 not null,
    value       varchar
);

alter table pokemon_master.building_memo
    owner to sasakirione;

create table pokemon_master.pokemon
(
    id         integer           not null,
    form       integer default 0 not null,
    pokemon_id serial,
    name       varchar           not null,
    constraint pokemon_pk
        primary key (id, form)
);

alter table pokemon_master.pokemon
    owner to sasakirione;

create table pokemon_master.building_pokemon
(
    id          serial
        constraint building_pokemon_pk
            primary key,
    building_id integer
        constraint building
            references pokemon_master.build,
    pokemon_id  integer not null
        constraint building_pokemon_pokemon_pokemon_id_fk
            references pokemon_master.pokemon (pokemon_id),
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

alter table pokemon_master.building_pokemon
    owner to sasakirione;

create unique index pokemon_pokemon_id_uindex
    on pokemon_master.pokemon (pokemon_id);

create table pokemon_master.pokemon_type
(
    id         serial
        constraint pokemon_type_pk
            primary key,
    pokemon_id integer not null
        constraint pokemon_type_pokemon_pokemon_id_fk
            references pokemon_master.pokemon (pokemon_id),
    type       integer not null
);

alter table pokemon_master.pokemon_type
    owner to sasakirione;

create table pokemon_master.pokemon_base
(
    id integer not null
        constraint pokemon_base_pk
            primary key
        constraint pokemon_base_pokemon_pokemon_id_fk
            references pokemon_master.pokemon (pokemon_id),
    h  integer not null,
    a  integer not null,
    b  integer not null,
    c  integer not null,
    d  integer not null,
    s  integer not null
);

alter table pokemon_master.pokemon_base
    owner to sasakirione;

create table pokemon_master.building_pokemon_move
(
    id    integer not null
        constraint building_pokemon_move_pk
            primary key
        constraint building_pokemon_move_building_pokemon_id_fk
            references pokemon_master.building_pokemon,
    move1 integer not null,
    move2 integer not null,
    move3 integer not null,
    move4 integer not null
);

alter table pokemon_master.building_pokemon_move
    owner to sasakirione;

create table pokemon_master.building_pokemon_tag
(
    id                  serial
        constraint building_pokemon_tag_pk
            primary key,
    building_pokemon_id integer
        constraint building_pokemon_tag_building_pokemon_id_fk
            references pokemon_master.building_pokemon,
    tag                 integer
);

alter table pokemon_master.building_pokemon_tag
    owner to sasakirione;

