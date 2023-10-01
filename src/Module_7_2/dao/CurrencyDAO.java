package Module_7_2.dao;

import Module_7_2.datasource.MariaDBConnection;
import Module_7_2.entity.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyDAO {
    private static final Connection conn = MariaDBConnection.getConnection();

    public static int getCurrencyCount() {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT COUNT(ID) FROM currencies;");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static Currency getCurrency(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM currencies where ID = ?;");

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
            PreparedStatement statement = conn.prepareStatement("SELECT ExchangeRate FROM currencies where Abbreviation = ?;");

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
