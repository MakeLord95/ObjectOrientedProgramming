package Module_6_3.view;

import Module_6_3.controller.PetController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PetView extends Application {
    private final int canvasSize = 500;
    private final int petSize = canvasSize / 10;
    private final Canvas canvas = new Canvas(canvasSize, canvasSize);
    private final GraphicsContext gc = canvas.getGraphicsContext2D();
    private final Image image = new Image("Module_6_3/resources/pet.png");
    private PetController petController;

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, canvasSize, canvasSize);

        gc.drawImage(image, petController.getPetX(), petController.getPetY(), petSize, petSize);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Pet Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();


        canvas.setOnMouseMoved(event -> {
            int x = (int) event.getX();
            int y = (int) event.getY();
            System.out.println("x: " + x + ", y: " + y);
            petController.movePet(x, y);
        });
    }

    public void init() {
        petController = new PetController(this);
    }

    public void drawImage(int x, int y) {
        gc.clearRect(0, 0, canvasSize, canvasSize);
        gc.drawImage(image, x - ((double) petSize / 2), y - ((double) petSize / 2), petSize, petSize);
    }
}
