package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AOC201902 {
    public static int calculateValue(ArrayList<Integer> registers, int i, char c) {
        if(c=='+') return registers.get(registers.get(i+1))+registers.get(registers.get(i+2));
        else return registers.get(registers.get(i+1))*registers.get(registers.get(i+2));
    }
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\chewb\\Downloads\\IntelIJ-Projects\\AdventOfCode3\\src\\day2\\input.txt");
            Scanner in = new Scanner(file).useLocale(Locale.US);
            ArrayList<Integer> registers=new ArrayList<Integer>();
            in.useDelimiter(",");
            int j=0;
            while (in.hasNext()) {
                registers.add(in.nextInt());
                j++;
            }
            System.out.println(j);
            registers.set(1,12);
            registers.set(2,2);
            System.out.println(registers.size());
            int i=0;
/*
            while (i<=registers.size() && registers.get(i)!=99) {
                System.out.println(i + " : " + registers.get(i));
                if(registers.get(i)==1) {
                    registers.set(registers.get(i+3), calculateValue(registers,i,'+'));
                    i=i+4;
                }
                if(registers.get(i)==2) {
                    registers.set(registers.get(i+3), calculateValue(registers,i,'-'));
                    i=i+4;
                }
            }
            */
            //System.out.println(registers);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
