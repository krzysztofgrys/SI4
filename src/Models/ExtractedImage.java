package Models;

import java.util.ArrayList;

/**
 * Created by krzysztofgrys on 5/28/17.
 */
public class ExtractedImage {
    float x;
    float y;
    ArrayList<Integer> cechy;
    Neighbours neighbour;

    public ExtractedImage() {
        cechy = new ArrayList<>();
    }

    public Neighbours getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(Neighbours neighbour) {
        this.neighbour = neighbour;
    }

    public void addCeche(int value) {
        cechy.add(value);
    }

    public ArrayList<Integer> getCechy() {
        return cechy;
    }

    public float getCeche(int index) {
        return cechy.get(index);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "ExtractedImage{" +
                "x=" + x +
                ", y=" + y +
                ", cechy=" + cechy.size() +
                '}';
    }
}
