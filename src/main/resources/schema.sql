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

CREATE TABLE student_local
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

INSERT INTO STUDY_GROUP VALUES (3, 'ИВБО-02-15-3');

INSERT INTO STUDENT_LOCAL VALUES (1, 'Воронцов', 'Юрий', 'Алексеевич', 3),
                           (2, 'Зубкова', 'Марина', 'Геннадьевна', 3);

INSERT INTO SUBJECT VALUES (1, 'Проектирование информационных систем', 'ПрИС'),
                           (2, 'Системы искусственного интеллекта', 'СИИ'),
                           (3, 'Программная инженерия', 'ПИ'),
                           (4, 'Национальная система информационной безопасности', 'НСИБ'),
                           (5, 'Системный анализ', 'СисАнал'),
                           (6, 'Распределенные базы данных', 'РБД'),
                           (7, 'Системное программное обеспечение', 'СПО');

INSERT INTO EXAM_TYPE VALUES (1, 'Экзамен'),
                             (2, 'Зачет'),
                             (3, 'Зачет с оценкой'),
                             (4, 'Курсовая');

INSERT INTO STUDY_PLAN VALUES (1, 1, 1),
                              (2, 1, 4),
                              (3, 2, 1),
                              (4, 3, 1),
                              (5, 4, 2),
                              (6, 5, 1),
                              (7, 6, 2),
                              (8, 7, 1);

INSERT INTO MARK VALUES (1, 'Отлично', 5),
                        (2, 'Хорошо', 4),
                        (3, 'Удовлетворительно', 3),
                        (4, 'Неудовлетворительно', 2),
                        (5, 'Зачет', 'з'),
                        (6, 'Незачет', 'н'),
                        (7, 'Неявка', '');
