DROP DATABASE IF EXISTS Currency;
CREATE DATABASE Currency;

USE Currency;

CREATE TABLE Currencies
(
    ID           INT(11)                                                      NOT NULL AUTO_INCREMENT,
    Name         VARCHAR(50)                                                  NOT NULL,
    Abbreviation VARCHAR(50)                                                  NOT NULL,
    ExchangeRate DOUBLE DEFAULT 0                                             NOT NULL,
    Symbol       VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (ID)
);

ALTER TABLE currencies
    AUTO_INCREMENT = 1;

INSERT INTO Currencies (Name, Abbreviation, ExchangeRate, Symbol)
VALUES ('Euro', 'EUR', 0.95, '€'),
       ('US Dollar', 'USD', 1, '$'),
       ('British Pound', 'GBP', 0.82, '£'),
       ('Canadian Dollar', 'CAD', 1.35, '$'),
       ('Japanese Yen', 'JPY', 149.07, '¥'),
       ('Swedish Krona', 'SEK', 11.01, 'kr'),
       ('Norwegian Krone', 'NOK', 10.74, 'kr'),
       ('Australian Dollar', 'AUD', 1.56, '$'),
       ('Dogecoin', 'DOGE', 16.49, 'Ð'),
       ('Bitcoin', 'BTC', 0.000038, '₿'),
       ('Ethereum', 'ETH', 0.00062, 'Ξ');

DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'appuser';

GRANT SELECT ON Currency.* TO 'appuser'@'localhost';
