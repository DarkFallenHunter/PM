CREATE TABLE study_group
(
  id INT NOT NULL,
  name TEXT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE subject
(
  id INT NOT NULL,
  name TEXT NOT NULL,
  short_name TEXT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE mark
(
  id INT NOT NULL,
  name TEXT NOT NULL,
  value TEXT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE exam_type
(
  id INT NOT NULL,
  type TEXT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE study_plan
(
  id INT NOT NULL,
  subject_id INT NOT NULL,
  exam_type_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (subject_id) REFERENCES subject(id),
  FOREIGN KEY (exam_type_id) REFERENCES exam_type(id)
);

CREATE TABLE student
(
  id INT NOT NULL,
  surname TEXT NOT NULL,
  name TEXT NOT NULL,
  second_name TEXT NOT NULL,
  study_group_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (study_group_id) REFERENCES  study_group(id)
);

CREATE TABLE journal
(
  id INT NOT NULL,
  student_id INT NOT NULL,
  study_plan_id INT NOT NULL,
  in_time BIT NOT NULL,
  count INT NOT NULL,
  mark_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (student_id) REFERENCES student(id),
  FOREIGN KEY (study_plan_id) REFERENCES study_plan(id),
  FOREIGN KEY (mark_id) REFERENCES  mark(id)
);