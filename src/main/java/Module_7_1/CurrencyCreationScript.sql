DROP DATABASE IF EXISTS Currency;
CREATE DATABASE Currency;

USE Currency;

CREATE TABLE Currencies
(
    ID           INT(11)     NOT NULL AUTO_INCREMENT,
    Name         VARCHAR(50) NOT NULL,
    Abbreviation VARCHAR(50) NOT NULL,
    ExchangeRate DOUBLE      NOT NULL,
    Symbol       VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID)
);

ALTER TABLE Currencies
    AUTO_INCREMENT = 1;

INSERT INTO Currencies (Name, Abbreviation, ExchangeRate, Symbol)
VALUES ('US Dollar', 'USD', 1, '$'),
       ('Euro', 'EUR', 0.95, '€'),
       ('British Pound', 'GBP', 0.82, '£'),
       ('Canadian Dollar', 'CAD', 1.35, '$'),
       ('Japanese Yen', 'JPY', 149.07, '¥'),
       ('Swedish Krona', 'SEK', 11.01, 'kr'),
       ('Norwegian Krone', 'NOK', 10.74, 'kr'),
       ('Australian Dollar', 'AUD', 1.56, '$');

DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'appuser';

GRANT ALL PRIVILEGES ON Currency.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;
