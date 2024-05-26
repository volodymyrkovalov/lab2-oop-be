-- Inserting sample data into the faculty table
INSERT INTO faculty (id, name, admission_plan) VALUES
(1, 'Engineering', 100),
(2, 'Arts', 50),
(3, 'Science', 75);

-- Inserting sample data into the applicant table
INSERT INTO applicant (id, first_name, last_name, email, average_grade, faculty_id) VALUES
(1, 'John', 'Doe', 'john.doe@example.com', 3.5, 1),
(2, 'Jane', 'Smith', 'jane.smith@example.com', 3.8, 2),
(3, 'Alice', 'Johnson', 'alice.johnson@example.com', 3.9, 3);

-- Inserting sample data into the subject_grade table
INSERT INTO subject_grade (id, subject_name, grade, applicant_id) VALUES
(1, 'Mathematics', 4.0, 1),
(2, 'Physics', 3.8, 1),
(3, 'History', 3.5, 2),
(4, 'Literature', 4.0, 2),
(5, 'Biology', 3.7, 3),
(6, 'Chemistry', 3.9, 3);
