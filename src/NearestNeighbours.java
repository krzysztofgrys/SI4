import Models.ExtractedImage;
import Models.Neighbours;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by krzysztofgrys on 5/28/17.
 */
public class NearestNeighbours {
    private ArrayList<ExtractedImage> extractedImages1;
    private ArrayList<ExtractedImage> extractedImages2;

    public NearestNeighbours(ArrayList<ExtractedImage>  extractedImages1, ArrayList<ExtractedImage> extractedImages2) {
        this.extractedImages1 = extractedImages1;
        this.extractedImages2 = extractedImages2;
    }

    public void findNeighbours() {
        //TODO rozne rozmiary
        for (int i = 0; i < extractedImages1.size(); i++) {
            find(extractedImages1.get(i));
        }

    }


    public void find(ExtractedImage extractedImage) {
        int nearest = 99999999;
        ArrayList<Integer> cechy = extractedImage.getCechy();
        for (int i = 0; i < extractedImages2.size(); i++) {
            int res = compareCechy(cechy, extractedImages2.get(i).getCechy());
            if (res < nearest) {
                nearest = res;
                extractedImage.setNeighbour(new Neighbours(extractedImages2.get(i).getX(), extractedImages2.get(i).getY()));
            }
        }

    }


    //TODO to moze nie dzialc
    public int compareCechy(ArrayList<Integer> cechy1, ArrayList<Integer> cechy2) {
        int val = 0;
        for (int i = 0; i < cechy1.size(); i++) {
            val += cechy1.get(i) - cechy2.get(i);
        }
        return Math.abs(val);
    }

}
