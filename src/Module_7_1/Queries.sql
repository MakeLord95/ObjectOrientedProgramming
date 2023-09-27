USE Currency;

SELECT Name, Abbreviation, ExchangeRate FROM Currencies;
SELECT * FROM Currencies WHERE Abbreviation='EUR';
SELECT COUNT(ID) FROM Currencies;
SELECT * FROM Currencies WHERE ExchangeRate=(SELECT MAX(ExchangeRate) FROM Currencies);
