package Module_7_4.view;

import Module_7_4.controller.ConverterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConverterView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader converterLoader = new FXMLLoader(getClass().getResource("/Module_7_4/CurrencyConverter.fxml"));
        Parent root = converterLoader.load();

        stage.setTitle("Currency Converter");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

        ConverterController converterController = converterLoader.getController();
        converterController.startup();
    }
}
