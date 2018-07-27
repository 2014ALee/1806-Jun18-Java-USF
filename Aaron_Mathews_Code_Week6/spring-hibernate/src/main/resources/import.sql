INSERT INTO flashcards (id, question, answer) VALUES (1, 'test', 'answer');
INSERT INTO flashcards (id, question, answer) VALUES (2, 'What does DI promote?', 'loose-coupling');
INSERT INTO flashcards (id, question, answer) VALUES (3, 'What is the primary IOC container in Spring?', 'ApplicationContext');
INSERT INTO flashcards (id, question, answer) VALUES (4, 'What are the Spring stereotype annotations?', '@Component, @Controller, @Service, and @Repository');
INSERT INTO flashcards (id, question, answer) VALUES (5, 'What is the difference between ApplicationContext and BeanFactory with regard to bean instantiation?', 'BeanFactory lazily instantiates beans, while ApplicationContext eagerly loads beans');
COMMIT;