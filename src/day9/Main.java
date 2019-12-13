package day9;

import day5.Computer;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void runProgram(HashMap<Long,Long> registers) {
        ComputerLong cmp = new ComputerLong(registers);
        cmp.runProgram();
    }

    public static void main(String[] args) {
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(109, 1, 204, -1, 1001, 100, 1, 100, 1008, 100, 16, 101, 1006, 101, 0, 99));
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(1102, 34915192, 34915192, 7, 4, 7, 99, 0));
        //ArrayList<Long> testCase3 = new ArrayList<Long>(Arrays.asList(104L,1125899906842624L,99L));
        //runProgram(testCase2);
        //runProgram(testCase3);
        try {
            File file = new File("C:\\Users\\chewb\\Downloads\\IntelIJ-Projects\\AdventOfCode3\\AdventOfCode2019\\src\\day9\\input9.txt");
            Scanner in = new Scanner(file).useLocale(Locale.US);
            //ArrayList<Integer> registers = new ArrayList<Integer>();
            HashMap<Long, Long> registers = new HashMap<>();
            in.useDelimiter(",");
            long i=0;
            while (in.hasNext()) {
                registers.put(i, in.nextLong());
                i++;
            }
            runProgram(registers);
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        }
    }
}
