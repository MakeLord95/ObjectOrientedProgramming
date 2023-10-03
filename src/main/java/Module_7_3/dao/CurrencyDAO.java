package Module_7_3.dao;

import Module_7_3.entity.Currency;
import Module_7_3.datasource.MariaDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyDAO {
    private static final Connection conn = MariaDBConnection.getConnection();

    public static int getCurrencyCount() {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT COUNT(ID) FROM Currencies;");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static Module_7_3.entity.Currency getCurrency(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM Currencies where ID = ?;");

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("Name");
                String abbreviation = rs.getString("Abbreviation");

                return new Currency(name, abbreviation);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static double getRate(String abbreviation) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT ExchangeRate FROM Currencies where Abbreviation = ?;");

            statement.setString(1, abbreviation);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return rs.getDouble("ExchangeRate");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
