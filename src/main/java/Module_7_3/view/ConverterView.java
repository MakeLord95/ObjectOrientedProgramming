package Module_7_3.view;

import Module_7_3.controller.ConverterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConverterView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ConverterView.class.getResource("/Module_7_3/CurrencyConverter.fxml"));
        Parent root = fxmlLoader.load();

        stage.setTitle("Currency Converter");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

        ConverterController converterController = fxmlLoader.getController();
        converterController.newCurrencyButton.setOnAction(event -> createNewStage());
    }

    // Doesn't work
    //TODO: fix this
    public void createNewStage() {
        Stage newStage = new Stage();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ConverterView.class.getResource("/Module_7_3/NewCurrency.fxml"));
            Parent root = fxmlLoader.load();
            newStage.setTitle("New Currency");
            newStage.setScene(new Scene(root));
            newStage.setResizable(false);
            newStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
