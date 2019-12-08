package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Day5Main {
    public static void testSuite(ArrayList<ArrayList<Integer>> listOfCases) {
        for(ArrayList<Integer> testCase : listOfCases) {
            Computer cmp = new Computer(testCase);
            cmp.runProgram();
        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\chewb\\Downloads\\IntelIJ-Projects\\AdventOfCode3\\src\\day5\\input.txt");
            Scanner in = new Scanner(file).useLocale(Locale.US);
            ArrayList<Integer> registers=new ArrayList<Integer>();
            in.useDelimiter(",");
            while (in.hasNext()) {
                registers.add(in.nextInt());
            }
            Computer cmp1 = new Computer(registers);
            cmp1.runProgram();
            //System.out.println(j);
            //System.out.println(registers);
            ArrayList<ArrayList<Integer>> testCases = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> testCase1=new ArrayList<Integer>(Arrays.asList(3,9,8,9,10,9,4,9,99,-1,8));
            ArrayList<Integer> testCase2=new ArrayList<Integer>(Arrays.asList(3,9,7,9,10,9,4,9,99,-1,8));
            ArrayList<Integer> testCase3=new ArrayList<Integer>(Arrays.asList(3,3,1108,-1,8,3,4,3,99));
            ArrayList<Integer> testCase4=new ArrayList<Integer>(Arrays.asList(3,3,1107,-1,8,3,4,3,99));
            ArrayList<Integer> testCase5=new ArrayList<Integer>(Arrays.asList(3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9));
            ArrayList<Integer> testCase6=new ArrayList<Integer>(Arrays.asList(3,3,1105,-1,9,1101,0,0,12,4,12,99,1));
            ArrayList<Integer> testCase7=new ArrayList<Integer>(Arrays.asList(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
                    1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
                    999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99));
/*
            testCases.add(testCase1);
            testCases.add(testCase2);
            testCases.add(testCase3);
            testCases.add(testCase4);
            testCases.add(testCase5);
            testCases.add(testCase6);
*/
            testCases.add(testCase7);

        //    testSuite(testCases);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
