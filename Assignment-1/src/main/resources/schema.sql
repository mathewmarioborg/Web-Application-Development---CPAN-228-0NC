create table if not exists clothing (
    id identity,
    name varchar(50) not null,
    brandForm varchar(50) not null,
    yearOfCreation int not null,
    price double not null
);
