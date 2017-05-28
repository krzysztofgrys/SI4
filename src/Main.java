import Pre.ExtractFeatures;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String image1 =  "/Users/krzysztofgrys/si4/images/si_example.png";
        String image2 =  "/Users/krzysztofgrys/si4/images/si_example.png";
        String file1 = "/Users/krzysztofgrys/si4/images/si_example.png.haraff.sift";
        String file2 = "/Users/krzysztofgrys/si4/images/si_example.png.haraff.sift";
        ExtractFeatures extractFeatures = new ExtractFeatures();
        extractFeatures.loadHaraffFile(file1);
        ExtractFeatures extractFeatures1 = new ExtractFeatures();
        extractFeatures1.loadHaraffFile(file2);


        NearestNeighbours nearestNeighbours = new NearestNeighbours(extractFeatures.getExtractedImages(),extractFeatures1.getExtractedImages());
        nearestNeighbours.findNeighbours();

        View view = new View(image1, image2);

        view.drawNearest(extractFeatures.getExtractedImages());
    }
}
