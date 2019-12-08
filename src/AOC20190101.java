import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class AOC20190101 {
    static double calculateFuel(double fuel) {
        double fuelDelta=Math.floor(fuel/3)-2;
        if (fuelDelta<=0) return 0;
        else return fuelDelta+calculateFuel(fuelDelta);
    }
    public static void main(String[] args) {
       try {
           File file = new File("C:\\Users\\chewb\\Downloads\\IntelIJ-Projects\\AdventOfCode3\\src\\inputAOC1");
           Scanner in = new Scanner(file).useLocale(Locale.US);
           int finalSum=0;
           System.out.println(calculateFuel(1969));
           System.out.println(calculateFuel(100756));
           while (in.hasNext()) {
               double fuel=Math.floor(in.nextDouble()/3)-2;
               finalSum+=fuel;
               finalSum+=calculateFuel(fuel);
           }
           System.out.println(finalSum);
       }
       catch (FileNotFoundException e) {
           System.out.println("File not found");
       }
    }
}
