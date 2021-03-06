package deveone.graphics.additional;

import java.awt.*;

public class Resistor {
        private Vertex start;
        private Vertex end;
        private int weight;
        private Color color;

    public Resistor(Vertex start, Vertex end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
        this.color = Color.black;
    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
