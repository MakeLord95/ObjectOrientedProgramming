package Module_7_2.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConverterView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ConverterView.class.getResource("../resources/CurrencyConverter.fxml"));
        Parent root = fxmlLoader.load();

        stage.setTitle("Currency Converter");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}
