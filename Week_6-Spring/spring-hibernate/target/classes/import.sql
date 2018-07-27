INSERT INTO flashcards (id, question, answer) VALUES (FC_SEQ.NEXTVAL, 'test', 'answer');

INSERT INTO flashcards (id, question, answer) VALUES (FC_SEQ.NEXTVAL, 'What does DI promote?', 'loose-coupling');

INSERT INTO flashcards (id, question, answer) VALUES (FC_SEQ.NEXTVAL, 'What is the primary IOC container in Spring?', 'ApplicationContext');

INSERT INTO flashcards (id, question, answer) VALUES (FC_SEQ.NEXTVAL, 'What are the Spring stereotype annotations?', '@Component, @Controller, @Service, and @Repository');

INSERT INTO flashcards (id, question, answer) VALUES (FC_SEQ.NEXTVAL, 'What is the difference between ApplicationContext and BeanFactory with regard to bean instantiation?', 'BeanFactory lazily instantiates beans, while ApplicationContext eagerly loads beans');

COMMIT;