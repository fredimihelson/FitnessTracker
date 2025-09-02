-- Insert customers
INSERT INTO customer (id, first_name, last_name)
VALUES (1, 'Mari', 'Tamm'),
       (2, 'Jaan', 'Kask'),
       (3, 'Liis', 'Mets');

-- Insert exercises
INSERT INTO exercise (id, exercise_name, muscle_group)
VALUES (1, 'Squat', 'Legs'),
       (2, 'Bench Press', 'Chest'),
       (3, 'Deadlift', 'Back');

-- Insert workouts
INSERT INTO workout (customer_id, "date", exercise_id, sets, reps, weight)
VALUES (1, '2025-08-10', 1, 4, 8, 70.00),
       (1, '2025-08-12', 2, 3, 10, 50.00),
       (2, '2025-08-11', 3, 5, 5, 100.00),
       (3, '2025-08-15', 1, 4, 12, 60.00);
