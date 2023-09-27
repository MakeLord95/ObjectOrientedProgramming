DROP DATABASE IF EXISTS Currency;
CREATE DATABASE Currency;

USE Currency;

CREATE TABLE Currencies (
  ID int(11) not null,
  Name varchar(50) not null,
  Abbreviation varchar(50) not null,
  ExchangeRate double DEFAULT 0 not null,
  PRIMARY KEY (ID)
  );
  
INSERT INTO Currencies VALUES
 (1,'Euro','EUR',0.95),
 (2,'US Dollar','USD',1),
 (3,'British Pound','GBP',0.82),
 (4,'Canadian Dollar','CAD',1.35),
 (5,'Japanese Yen','JPY',149.07),
 (6,'Swedish Krona','SEK',11.01),
 (7,'Estonian Kroon','EEK',14.8),
 (8,'Australian Dollar','AUD',1.56),
 (9,'Dogecoin','DOGE',16.49),
 (10,'Bitcoin','BTC',0.000038);
 
 DROP USER IF EXISTS 'appuser'@'localhost';
 CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'appuser';
 
 GRANT SELECT ON Currency.* TO 'appuser'@'localhost';
