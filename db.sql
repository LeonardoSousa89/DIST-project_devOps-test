
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
	WORKER_EMAIL,
	WORKER_NAME,
	WORKER_PHONE_NUMBER ,
	WORKER_POST      	
FROM DIST_USERS U
INNER JOIN DIST_WORKERS W
ON U.USER_ID=W.USER_ID
WHERE U.USER_ID='1';

SELECT  W.WORKER_ID,
 	W.WORKER_ADDRESS,
	W.WORKER_AGE,
	WORKER_EMAIL,
	WORKER_NAME,
	WORKER_PHONE_NUMBER ,
	WORKER_POST      	
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





QUERY PARA @QUERY() JPA

----------------------------------------------------------------------------------------------------------------------------------------------
---Psql---

"SELECT workerName, workerEmail, workerPost, workerAddress FROM dist_workers"
"SELECT workerName FROM dist_workers WHERE workerName LIKE (:workername)"

---H2---

"SELECT WORKER_NAME, WORKER_EMAIL, WORKER_POST, WORKER_ADDRESS FROM  DIST_WORKERS"
"SELECT WORKER_NAME, WORKER_EMAIL, WORKER_POST, WORKER_ADDRESS FROM  DIST_WORKERS WHERE WORKER_NAME = (:workerName)"





QUERY PARA POSTGRES

----------------------------------------------------------------------------------------------------------------------------------------------
CREATE DATABASE distproject;
\c distproject

CREATE TABLE IF NOT EXISTS dist_users(
	userId SERIAL PRIMARY KEY,
	name VARCHAR(100),
	email VARCHAR(100) UNIQUE
);

DROP TRABLE dist_users;

CREATE TABLE IF NOT EXISTS dist_workers(
	workerId SERIAL PRIMARY KEY,
 	workerName VARCHAR(100),
	workerEmail VARCHAR(100),
	workerPost VARCHAR(100),
	workerAddress VARCHAR(100),
	workerPhoneNumber VARCHAR(100),
	workerAge VARCHAR(100),
	user_Id INT,
	FOREIGN KEY(user_Id) REFERENCES dist_users(userId)
);

DROP TRABLE dist_workers;


SELECT * FROM dist_users;
SELECT * FROM dist_workers;

INSERT INTO dist_users VALUES(1,'Thomas Wayne', 'Thomas@gmail.com');
INSERT INTO dist_users VALUES(2, 'Thomas Leo Clancy Jr','Clancys@hotmail.com');

INSERT INTO dist_workers VALUES(1, 'Alfred Penworth', 'wayneenterprise@ask.com', 'butler', 'Gotham city', '(415) 555-2671','62' ,1);
INSERT INTO dist_workers VALUES(2, 'Rachel Dawes',  'dawes@yahoo.com', 'lawyer','Gotham city', '(415) 555-3592', '23', 1);
INSERT INTO dist_workers VALUES(3, 'Samuel Leo Fisher', 'echelon@outlook.com', 'Secret Agent', 'Baltimore, Maryland', '(415) 555-2789', '36', 2);


DELETE FROM dist_workers;
DELETE FROM dist_users;

SELECT workerName, workerEmail, workerPost, workerAddress FROM dist_workers;
SELECT workerName, workerEmail FROM dist_workers WHERE workerEmail='dawes@yahoo.com';


----------------------------------------------------------------------------------------------------------------------------------------------





RDS

As configuraçãoes de conexão estarão na area-de-trabalho na pasta db, já foi aberta conexão via server com pgAdmin.


obs* o database da AMAZON só possui 7 dias grátuitos de db, a cada 6 dias alterar o banco.

distproject - criado 04-11 as 19:38
	      destruição 10-11

