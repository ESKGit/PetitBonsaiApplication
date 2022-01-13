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


CREATE TABLE framework_spring.owner (
     id UUID PRIMARY KEY,
     name varchar
);

ALTER TABLE framework_spring.bonsai ADD COLUMN owner_id UUID;
ALTER TABLE framework_spring.bonsai ADD CONSTRAINT FK_owner_id FOREIGN KEY (owner_id) references framework_spring.owner(id);

ALTER TABLE framework_spring.watering
DROP CONSTRAINT watering_bonsai_id_fkey,
ADD CONSTRAINT watering_bonsai_id_fkey
FOREIGN KEY (bonsai_id)
REFERENCES framework_spring.bonsai(id)
ON DELETE CASCADE;

ALTER TABLE framework_spring.prunning
DROP CONSTRAINT prunning_bonsai_id_fkey,
ADD CONSTRAINT prunning_bonsai_id_fkey
FOREIGN KEY (bonsai_id)
REFERENCES framework_spring.bonsai(id)
ON DELETE CASCADE;

ALTER TABLE framework_spring.repotting
DROP CONSTRAINT repotting_bonsai_id_fkey,
ADD CONSTRAINT repotting_bonsai_id_fkey
FOREIGN KEY (bonsai_id)
REFERENCES framework_spring.bonsai(id)
ON DELETE CASCADE;



INSERT INTO framework_spring.bonsai(id, name, species, datetime, acquisition_age, status, acquisition_date, owner_id)
VALUES ('', '', '', '', '', '', '', '');

INSERT INTO framework_spring.owner(id, name)
VALUES (?, ?);

INSERT INTO framework_spring.watering(id, datetime, bonsai_id)
VALUES (?, ?, ?);

INSERT INTO framework_spring.prunning(id, datetime, bonsai_id)
VALUES (?, ?, ?);

INSERT INTO framework_spring.repotting(id, datetime, bonsai_id)
VALUES (?, ?, ?);