package Module_7_4.view;

import Module_7_4.controller.ConverterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConverterView extends Application {
    private final Stage newStage = new Stage();
    private boolean currenciesAdded = false;
    private ConverterController converterController;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader converterLoader = new FXMLLoader(getClass().getResource("/Module_7_4/CurrencyConverter.fxml"));
        Parent root = converterLoader.load();

        stage.setTitle("Currency Converter");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

        converterController = converterLoader.getController();

        if (!currenciesAdded) {
            converterController.addCurrencies();
            currenciesAdded = true;
        }

        converterController.startup();


        converterController.newCurrencyButton.setOnAction(e -> {
            try {
                createNewStage();
                stage.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
    }

    public void createNewStage() throws Exception {
        FXMLLoader newCurrencyLoader = new FXMLLoader(getClass().getResource("/Module_7_4/NewCurrency.fxml"));
        Parent root = newCurrencyLoader.load();

        newStage.setTitle("New Currency");
        newStage.setScene(new Scene(root));
        newStage.setResizable(false);
        newStage.show();

        converterController = newCurrencyLoader.getController();
        converterController.addNewCurrencyButton.setOnAction(e -> {
            converterController.addNewCurrency();
            newStage.close();
            try {
                start(new Stage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
    }
}
