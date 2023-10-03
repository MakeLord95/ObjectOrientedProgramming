SELECT Name, Abbreviation, ExchangeRate FROM Currency.Currencies;
SELECT * FROM Currency.Currencies WHERE Abbreviation='EUR';
SELECT COUNT(ID) FROM Currency.Currencies;
SELECT * FROM Currency.Currencies WHERE ExchangeRate=(SELECT MAX(ExchangeRate) FROM Currency.Currencies);
