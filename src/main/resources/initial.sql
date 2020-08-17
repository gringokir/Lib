create database library;

use library;

create table storage
(
    id bigint primary key not null auto_increment
);

create table person
(
    id          bigint primary key not null auto_increment,
    first_name  varchar(255),
    last_name   varchar(255),
    person_type varchar(255),
    address_id  bigint,
    purchase_id bigint,
    storage_id  bigint,
    foreign key (storage_id) references storage (id)
);

create table address
(
    id        bigint primary key not null auto_increment,
    street    varchar(255),
    house     int,
    flat      int,
    person_id bigint,
    foreign key (person_id) references person (id)
);

create table purchase
(
    id          bigint primary key not null auto_increment,
    person_id   bigint,
    return_date date,
    foreign key (person_id) references person (id)
);

create table book
(
    id            bigint primary key not null auto_increment,
    name          varchar(255),
    author        varchar(255),
    bookCondition varchar(255),
    person_id     bigint,
    storage_id    bigint,
    purchase_id   bigint,
    foreign key (person_id) references person (id),
    foreign key (purchase_id) references purchase (id),
    foreign key (storage_id) references storage (id)
);

create table client
(
    id              bigint primary key not null auto_increment,
    customer_number bigint
);

create table librarian
(
    id bigint primary key not null auto_increment
);

insert storage(id)
values (1);

INSERT person(id, first_name, last_name, person_type, address_id, purchase_id, storage_id)
VALUES (1, 'Ivan', 'Ivanov', 'CLIENT', 1, 1, 1);

insert address(id, street, house, flat, person_id)
values (1, 'Pushkina', 1, 1, 1);

insert purchase(id, person_id, return_date)
values (1,1,'2000-01-01');

insert book(id, name, author, person_id, storage_id, purchase_id)
values (1, 'Book', 'Human', 1, 1, 1);



