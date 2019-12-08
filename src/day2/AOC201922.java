package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AOC201922 {
    public static int calculateValue(ArrayList<Integer> registers, int i, char c) {
        if(c=='+') return registers.get(registers.get(i+1))+registers.get(registers.get(i+2));
        else return registers.get(registers.get(i+1))*registers.get(registers.get(i+2));
    }
    public static int programRun(ArrayList<Integer> registersT, int input1, int input2) {
        ArrayList<Integer> registers = new ArrayList<Integer>(registersT);
        registers.set(1,input1);
        registers.set(2,input2);
        int i=0;
        while (i<=registers.size() && registers.get(i)!=99) {
            //System.out.println(i + " : " + registers.get(i));
            if(registers.get(i)==1) {
                registers.set(registers.get(i+3), calculateValue(registers,i,'+'));
                i=i+4;
            }
            if(registers.get(i)==2) {
                registers.set(registers.get(i+3), calculateValue(registers,i,'-'));
                i=i+4;
            }
        }
        assert (registersT.get(0)!=registers.get(0));
        return registers.get(0);
    }
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\chewb\\Downloads\\IntelIJ-Projects\\AdventOfCode3\\src\\day2\\input.txt");
            Scanner in = new Scanner(file).useLocale(Locale.US);
            ArrayList<Integer> registers=new ArrayList<Integer>();
            in.useDelimiter(",");
            while (in.hasNext()) {
                registers.add(in.nextInt());
            }
            int output=0;
            System.out.println(registers.size());
            for(int i=0;i<registers.size();i++) {
                for(int j=0;j<registers.size();j++) {
                    output=programRun(registers,i,j);
                    if(output==19690720) {
                        System.out.println("--------------------------FOUND------------------------");
                        System.out.println(i + " : " +j);
                        System.out.println("--------------------------FOUND------------------------");
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
