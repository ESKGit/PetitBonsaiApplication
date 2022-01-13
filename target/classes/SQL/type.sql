CREATE TABLE framework_spring.bonsai (
    id uuid PRIMARY KEY,
    name text,
    species text,
    datetime date,
    acquisition_age int,
    acquisition_date date,
    status text

);


CREATE TABLE framework_spring.watering (
    id uuid PRIMARY KEY,
    datetime date,
    bonsai_id uuid,
    FOREIGN KEY (bonsai_id) REFERENCES framework_spring.bonsai(id)
);

CREATE TABLE framework_spring.prunning (
    id uuid PRIMARY KEY,
    datetime date,
    bonsai_id uuid,
    FOREIGN KEY (bonsai_id) REFERENCES framework_spring.bonsai(id)
);

CREATE TABLE framework_spring.repotting (
    id uuid PRIMARY KEY,
    datetime date,
    bonsai_id uuid,
    FOREIGN KEY (bonsai_id) REFERENCES framework_spring.bonsai(id)  on delete cascade on update cascade,
);

alter table framework_spring.repotting
drop constraint watering_bonsai_id_fkey,
add constraint watering_bonsai_id_fkey
   foreign key (bonsai_id)
   references framework_spring.bonsai(id)
   on delete cascade;

CREATE TABLE framework_spring.owner (
     id UUID PRIMARY KEY,
     name varchar
);

ALTER TABLE framework_spring.bonsai ADD COLUMN owner_id UUID;
ALTER TABLE framework_spring.bonsai ADD CONSTRAINT FK_owner_id FOREIGN KEY (owner_id) references framework_spring.owner(id);