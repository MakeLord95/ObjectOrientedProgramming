package Module_5_3;

public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; }
        @Override public String toString() { return color; }
    }

    private Color currentColor;
    private boolean capOn;

    public Pen() {
        this(Color.RED);
    }

    public Pen(Color initialColor) {
        this.currentColor = initialColor;
        this.capOn = true;
    }

    public void capOff() {
        this.capOn = false;
    }

    public void capOn() {
        this.capOn = true;
    }

    public void changeColor(Color newColor) {
        if (capOn) {
            this.currentColor = newColor;
        }
    }

    public String draw() {
        if (capOn) {
            return "";
        } else {
            return "Drawing " + currentColor.toString();
        }
    }
}
