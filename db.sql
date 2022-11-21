
QUERY PARA H2

----------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO DIST_USERS VALUES(1,'Thomas@gmail.com','Thomas Wayne');
INSERT INTO DIST_USERS VALUES(2,'Clancys@hotmail.com','Thomas Leo Clancy Jr');

INSERT INTO DIST_WORKERS VALUES(1,'Gotham city','62', 'wayneenterprise@ask.com', 'Alfred Penworth','(415) 555-2671','butler',1);
INSERT INTO DIST_WORKERS VALUES(2,'Gotham city','23', 'dawes@yahoo.com', 'Rachel Dawes','(415) 555-3592','lawyer',1);
INSERT INTO DIST_WORKERS VALUES(3,' Baltimore, Maryland','36', 'echelon@outlook.com', 'Samuel Leo Fisher','(415) 555-2789','Secret Agent',2);

SELECT * FROM DIST_USERS;
SELECT * FROM DIST_WORKERS; 

SELECT WORKER_NAME, WORKER_EMAIL, WORKER_POST, WORKER_ADDRESS FROM  DIST_WORKERS;
SELECT WORKER_NAME, WORKER_EMAIL, WORKER_POST, WORKER_ADDRESS FROM  DIST_WORKERS WHERE WORKER_NAME = 'Alfred Penworth';
SELECT WORKER_NAME, WORKER_EMAIL, WORKER_POST, WORKER_ADDRESS FROM  DIST_WORKERS WHERE WORKER_EMAIL = 'dawes@yahoo.com';
SELECT WORKER_NAME, WORKER_EMAIL, WORKER_POST, WORKER_ADDRESS FROM  DIST_WORKERS WHERE WORKER_ADDRESS  = 'Gotham city';

DELETE FROM DIST_USERS;
DELETE FROM DIST_WORKERS; 

/* exemplo de query para listar os dados de um User especifico*/
SELECT  W.WORKER_ID,
 	W.WORKER_ADDRESS,
	W.WORKER_AGE,
	W.WORKER_EMAIL,
	W.WORKER_NAME,
	W.WORKER_PHONE_NUMBER ,
	W.WORKER_POST      	
FROM DIST_USERS U
INNER JOIN DIST_WORKERS W
ON U.USER_ID=W.USER_ID
WHERE U.USER_ID='1';

SELECT  W.WORKER_ID,
 	W.WORKER_ADDRESS,
	W.WORKER_AGE,
	W.WORKER_EMAIL,
	W.WORKER_NAME,
	W.WORKER_PHONE_NUMBER ,
	W.WORKER_POST      	
FROM DIST_USERS U
INNER JOIN DIST_WORKERS W
ON U.USER_ID=W.USER_ID
WHERE U.USER_ID='2';

/* exemplo de query para deletar os dados de um worker especifico*/
/* pode ser uma procedure */
DELETE FROM DIST_WORKERS WHERE WORKER_ID   = '1' AND ADMIN_USER_ID='1' ; 

/* exemplo de query para atualizar os dados de um worker especifico*/
/* pode ser uma procedure */
UPDATE DIST_WORKERS SET WORKER_AGE='24' WHERE WORKER_ID   = '2' AND ADMIN_USER_ID='1' ; 
----------------------------------------------------------------------------------------------------------------------------------------------








QUERY PARA POSTGRES/RDS

----------------------------------------------------------------------------------------------------------------------------------------------
CREATE DATABASE distproject;
\c distproject

CREATE TABLE IF NOT EXISTS dist_users(
	userId VARCHAR(250) PRIMARY KEY NOT NULL,
	username VARCHAR(100),
	email VARCHAR(100) UNIQUE NOT NULL
);

DROP TABLE dist_users;

CREATE TABLE IF NOT EXISTS dist_workers(
	workerId SERIAL PRIMARY KEY,
 	workerName VARCHAR(100) NOT NULL,
	workerEmail VARCHAR(100) UNIQUE NOT NULL,
	workerPost VARCHAR(100)NOT NULL,
	workerAddress VARCHAR(100)NOT NULL,
	workerPhoneNumber VARCHAR(100)NOT NULL,
	workerAge VARCHAR(100)NOT NULL,
	user_Id VARCHAR(250),
	FOREIGN KEY(user_Id) REFERENCES dist_users(userId)
);
DROP TABLE dist_workers;

SELECT * FROM dist_users;
SELECT * FROM dist_workers;

INSERT INTO dist_users VALUES('1', 'Thomas Wayne', 'Thomas@gmail.com');
INSERT INTO dist_users VALUES('2', 'Thomas Leo Clancy Jr','Clancys@hotmail.com');
INSERT INTO dist_users VALUES('3', 'Jim Lee','dccomics@hotmail.com');

INSERT INTO dist_workers VALUES(1, 'Alfred Penworth', 'wayneenterprise@ask.com', 'butler', 'Gotham city', '(415) 555-2671','62' ,'1');
INSERT INTO dist_workers VALUES(2, 'Rachel Dawes',  'dawes@yahoo.com', 'lawyer','Gotham city', '(415) 555-3592', '23', '1');
INSERT INTO dist_workers VALUES(3, 'Jim lee', 'dccomics@ask.com', 'executive', 'Seul, South Corea', '(415) 555-8587','58' ,'1');
INSERT INTO dist_workers VALUES(4, 'Todd McFarlane',  'spiderman90@yahoo.com', 'drawer','Calgary, canada', '(415) 555-4455', '61', '1');
INSERT INTO dist_workers VALUES(5, 'Clark Kent', 'dayliplanet@ask.com', 'jornalist', 'Metropolis', '(415) 555-3335','37' ,'1');
INSERT INTO dist_workers VALUES(6, 'Alan Moore',  'moore@yahoo.com', 'writter','Northampton, United Kingdom', '(415) 555-5587', '68', '1');
INSERT INTO dist_workers VALUES(7, 'John Salvatore Romita Jr', 'romitajr@ask.com', 'drawer', 'New York/NY', '(415) 555-6666','66' ,'1');
INSERT INTO dist_workers VALUES(8, 'Frank Miller',  'sincity@yahoo.com', 'writter','Olney, Maryland', '(415) 555-0214', '65', '1');
INSERT INTO dist_workers VALUES(9, 'Benjamin Parker,', 'ben@ask.com', 'seller', 'New York/NY', '(415) 555-5578','62' ,'1');
INSERT INTO dist_workers VALUES(10, 'Miles Bennett Dyson',  'genysis@yahoo.com', 'scientist', 'Chicago, Illinois', '(415) 555-3559', '33', '1');
INSERT INTO dist_workers VALUES(11, 'Sarah Jeanette Connor', 'terminator84@ask.com', 'manager', 'Los Angeles, California', '(415) 555-0650','27' ,'1');
INSERT INTO dist_workers VALUES(12, 'Kyle Reese',  'reese2021@yahoo.com', 'assistent','----', '(415) 555-0020', '30', '1');
INSERT INTO dist_workers VALUES(13, 'Jonh Connor', 'connor@ask.com', 'trainee', 'Manhattan, Los Angeles, California', '(415) 555-5589','17' ,'1');
INSERT INTO dist_workers VALUES(14, 'John Jonah Jameson Jr',  'daylibugle@yahoo.com', 'executive','NEW York/NY', '(415) 555-4445', '42', '1');
INSERT INTO dist_workers VALUES(15, 'Ellen Louise Ripley', 'nostromos@ask.com', 'astronaut', '---', '(415) 555-0236','35' ,'1');

INSERT INTO dist_workers VALUES(16, 'Samuel Leo Fisher', 'echelon@outlook.com', 'Secret Agent', 'Baltimore, Maryland', '(415) 555-2789', '36', '2');

INSERT INTO dist_workers VALUES(17, 'Frank Miller', 'millercomics@outlook.com', 'writter/drawer', 'Olney, Maryland', '(415) 555-8974', '65', '3');
INSERT INTO dist_workers VALUES(18, 'Alan More', 'watchmenseries@ask.com', 'writter', 'Northampton, United Kingdom', '(415) 555-8745', '68', '3');
INSERT INTO dist_workers VALUES(19, 'Todd McFarlane', 'spiderman90@marvel.com', 'drawer', 'Calgary, Canada', '(415) 555-7877', '61', '3');

SELECT * FROM dist_users;
SELECT * FROM dist_workers;

DELETE FROM dist_workers;
DELETE FROM dist_users;

SELECT workerName, workerEmail, workerPost, workerAddress FROM dist_workers;
SELECT workerName, workerEmail FROM dist_workers WHERE workerEmail='dawes@yahoo.com';

SELECT  w.workerId,
 	w.workerName ,
	w.workerEmail,
	w.workerPost, 
	w.workerAddress,
	w.workerPhoneNumber,
	w.workerAge 	
FROM dist_users u
INNER JOIN dist_workers w
ON u.userId =w.user_id
WHERE u.userId ='1';

SELECT  w.workerId,
 	w.workerName ,
	w.workerEmail,
	w.workerPost, 
	w.workerAddress,
	w.workerPhoneNumber,
	w.workerAge 	
FROM dist_users u
INNER JOIN dist_workers w
ON u.userId =w.user_id
WHERE u.userId ='2';

SELECT  w.workerId,
 	w.workerName ,
	w.workerEmail,
	w.workerPost, 
	w.workerAddress,
	w.workerPhoneNumber,
	w.workerAge 	
FROM dist_users u
INNER JOIN dist_workers w
ON u.userId =w.user_id
WHERE u.userId ='3';


SELECT w.workerid, 
	 w.workername,
	 w.workeremail,
 	 w.workerpost,
	 w.workeraddress,
	 w.workerphonenumber,
	 w.workerage	
 FROM dist_users u INNER JOIN dist_workers w ON u.userId = w.user_id WHERE u.userId = 'v9Cky6EdNcT8rOqYl65XVvI2cZK2' AND w.workername = 'Kyle Reese';	


/*paginação*/
/* LIMIT por página, OFFSET saltos para a próxima consulta*/
select * from dist_workers LIMIT 3 OFFSET 1;
select * from dist_workers LIMIT 5 OFFSET 0;
select * from dist_workers LIMIT 2 OFFSET 0;
			   	
select * from dist_workers LIMIT 5;
select * from dist_workers LIMIT 5 OFFSET 5;

/*paginação para meu uso*/
select * from dist_workers LIMIT 5 OFFSET 5;

ALTER TABLE  dist_workers DROP COLUMN workername;
ALTER TABLE  dist_workers ADD COLUMN workername varchar(100) UNIQUE;

REF: https://www.tutorialspoint.com/postgresql/postgresql_alter_command.htm
     https://clebersonsilva.com/2018/01/limit-e-offset-no-postgresql/#:~:text=O%20PostgreSQL%20%C3%A9%20muito%20amigo,do%20que%20pagina%C3%A7%C3%A3o%20no%20cliente.
----------------------------------------------------------------------------------------------------------------------------------------------





RDS

As configuraçãoes de conexão estarão na area-de-trabalho na pasta db, já foi aberta conexão via server com pgAdmin.


obs* o database da AMAZON só possui 7 dias grátuitos de db, a cada 6 dias alterar o banco.

distproject - criado 04-11 as 19:38
	      destruição 10-11

