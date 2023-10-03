package Module_6_3.controller;

import Module_6_3.model.Pet;
import Module_6_3.view.PetView;

public class PetController {
    private final Pet pet = new Pet();
    private final PetView petView;

    public PetController(PetView petView) {
        this.petView = petView;
    }

    public static void main(String[] args) {
        PetView.launch(PetView.class);
    }

    public void movePet(int targetX, int targetY) {
        int currentX = pet.getX();
        int currentY = pet.getY();

        double distance = Math.hypot(targetX - currentX, targetY - currentY);

        int speed = 100;
        int steps = (int) (distance / speed);

        double stepX = (double) (targetX - currentX) / steps;
        double stepY = (double) (targetY - currentY) / steps;

        for (int i = 0; i < steps; i++) {
            currentX += (int) stepX;
            currentY += (int) stepY;

            System.out.printf("Mouse x: %d, y: %d\n", targetX, targetY);
            System.out.printf("Pet x: %d, y: %d\n", currentX, currentY);

            pet.setX(currentX);
            pet.setY(currentY);

            petView.drawImage(pet.getX(), pet.getY());

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getPetX() {
        return pet.getX();
    }

    public int getPetY() {
        return pet.getY();
    }
}
