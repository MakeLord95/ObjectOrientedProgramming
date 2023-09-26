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

    public void movePet(int x, int y) {
        pet.setX(x);
        pet.setY(y);
        petView.drawImage(pet.getX(), pet.getY());
    }

    public int getPetX() {
        return pet.getX();
    }

    public int getPetY() {
        return pet.getY();
    }
}
