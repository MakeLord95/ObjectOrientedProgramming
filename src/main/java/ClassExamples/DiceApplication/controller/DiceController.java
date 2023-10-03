package ClassExamples.DiceApplication.controller;

import ClassExamples.DiceApplication.model.Dice;
import ClassExamples.DiceApplication.view.DiceGUI;

public class DiceController {

    private final DiceGUI gui;
    private final Dice dice = new Dice(6);

    public DiceController(DiceGUI gui) {
        this.gui = gui;
    }

    public void cast() {
        int sides = gui.getSides();
        dice.setSides(sides);
        int result = dice.cast();
        gui.setResult(result);
    }

    public static void main(String[] args) {
        DiceGUI.launch(DiceGUI.class);
    }
}
