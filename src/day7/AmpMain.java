package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class AmpMain {
    public static ArrayList<String> permutation(String str)
    {
        ArrayList<String> combinations=new ArrayList<String>();
        combinations.add(permutation("", str, combinations));
        return combinations;
    }
    private static String permutation(String prefix, String str, ArrayList<String> combinations) {
        int n = str.length();
        if (n == 0) {
            return prefix;
        }
        else {
            for (int i = 0; i < n; i++)
                combinations.add(permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), combinations));
                return "";
        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\chewb\\Downloads\\IntelIJ-Projects\\AdventOfCode3\\AdventOfCode2019\\src\\day7\\input.txt");
            Scanner in = new Scanner(file).useLocale(Locale.US);
            //final ArrayList<Integer> registers=new ArrayList<Integer>();
            final ArrayList<Integer> registers=new ArrayList<>(Arrays.asList(3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,
                    27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5));
            in.useDelimiter(",");
            while (in.hasNext()) {
                registers.add(in.nextInt());
            }
            //Part 1 signals:
            //List<String> perms = permutation("01234");
            //Part 2 signals:
            List<String> perms = permutation("56789");
            perms.removeAll(Collections.singleton(""));
            System.out.println(perms.size());
            ArrayList<int[]> combinations = new ArrayList<int[]>();
            int maxOutput = 0;
            for (String s : perms) {
                int[] combArr = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
                //for(int i=0;i<5;i++) System.out.println(combArr[i]);
                int input = 0;
                int j=0;
                while (j<10) {
                    for (int i = 0; i < 5; i++) {
                        //System.out.println(combArr[i]);
                        Amplifier amp = new Amplifier(input, combArr[i], registers);
                        amp.runProgram();
                        input = amp.getOutput();
                        //System.out.println(input);
                    }
                    j++;
                    System.out.println(j);
                }
                if (input >= maxOutput) maxOutput = input;
            }
            System.out.println(maxOutput);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
