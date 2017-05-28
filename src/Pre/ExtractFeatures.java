package Pre;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Models.*;

/**
 * Created by krzysztofgrys on 5/28/17.
 */
public class ExtractFeatures {

    private ArrayList<ExtractedImage> extractedImages;

    public ExtractFeatures() {
        extractedImages = new ArrayList<>();
    }

    public void loadHaraffFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            ExtractedImage extractedImage = new ExtractedImage();
            parseLine(scanner.nextLine(), extractedImage);
            extractedImages.add(extractedImage);
        }
    }

    private void parseLine(String line, ExtractedImage extractedImage) {
        String[] splited = line.split(" ");
        extractedImage.setX(Float.parseFloat(splited[0]));
        extractedImage.setY(Float.parseFloat(splited[1]));

        for (int i = 5; i < splited.length; i++) {
            extractedImage.addCeche(Integer.parseInt(splited[i]));
        }
    }

    public ArrayList<ExtractedImage> getExtractedImages() {
        return extractedImages;
    }

}
