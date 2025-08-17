-- ******************************************************************
-- PLACEHOLDER SCHEMA (blank project)
-- Remove these lines and replace with real DDL scripts when ready
-- ******************************************************************
CREATE TABLE placeholder_dummy (id INT);
DROP TABLE placeholder_dummy;-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2025-08-17 15:33:40.206

-- tables
-- Table: customer
CREATE TABLE customer (
                          id int GENERATED ALWAYS AS IDENTITY NOT NULL,
                          first_name varchar(20)  NOT NULL,
                          last_name varchar(20)  NOT NULL,
                          CONSTRAINT customer_pk PRIMARY KEY (id)
);

-- Table: exercise
CREATE TABLE exercise (
                          id int GENERATED ALWAYS AS IDENTITY NOT NULL,
                          exercise_name varchar(20)  NOT NULL,
                          muscle_group varchar(20)  NOT NULL,
                          CONSTRAINT exercise_pk PRIMARY KEY (id)
);

-- Table: workout
CREATE TABLE workout (
                         id int  NOT NULL,
                         customer_id int  NOT NULL,
                         "date" date  NOT NULL,
                         exercise_id int  NOT NULL,
                         sets int  NOT NULL,
                         reps int  NOT NULL,
                         weight decimal(10,2)  NOT NULL,
                         customer_2_id int  NOT NULL,
                         exercise_2_id int  NOT NULL,
                         CONSTRAINT workout_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: workout_customer (table: workout)
ALTER TABLE workout ADD CONSTRAINT workout_customer
    FOREIGN KEY (customer_2_id)
        REFERENCES customer (id);

-- Reference: workout_exercise (table: workout)
ALTER TABLE workout ADD CONSTRAINT workout_exercise
    FOREIGN KEY (exercise_2_id)
        REFERENCES exercise (id);

-- End of file.

