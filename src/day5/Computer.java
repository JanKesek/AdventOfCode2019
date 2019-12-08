package day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Computer {
    protected ArrayList<Integer> registers;
    protected int index=0;
    public Computer() { super(); }
    Computer(ArrayList<Integer> registersIn) {
        registers=registersIn;
    }
    public ArrayList<Integer> parseParameters(ArrayList<Integer> instructions, String parameters) {
        for(char c : parameters.toCharArray()) instructions.add(0,Character.getNumericValue(c));
        while (instructions.size()<3) instructions.add(0);
        return instructions;
    }
    public void runProgram() {
        Integer[] tmpArr = new Integer[]{new Integer(0),new Integer(0),new Integer(0)};
        while (index<=registers.size() && registers.get(index)!=99) {
            //System.out.println(index + " : " + registers.get(index));
            if(registers.get(index)>=100) {
                String parameters=Integer.toString(registers.get(index));
                ArrayList<Integer> instructions=new ArrayList<Integer>();
                int opcode =Integer.parseInt(parameters.substring(parameters.length()-2));
                instructions=parseParameters(instructions,parameters.substring(0,parameters.length()-2));
                runInstruction(opcode, instructions);
            }
            else runInstruction(registers.get(index), new ArrayList<Integer>(Arrays.asList(tmpArr)));
        }
//        if(registers.get(index)==99) System.out.println(index + " : " +registers.get(index));
    }
    public void runInstruction(int opcode, ArrayList<Integer> instructions) {
        if(opcode==1) add(instructions.get(0),instructions.get(1),instructions.get(2));
        if(opcode==2) multiply(instructions.get(0),instructions.get(1),instructions.get(2));
        //if(opcode==99) halt();
        if(opcode==3) input();
        if(opcode==4) output(instructions.get(0));
        if(opcode==5) jump(instructions.get(0), instructions.get(1),1);
        if(opcode==6) jump(instructions.get(0), instructions.get(1),0);
        if(opcode==7) lessThan(instructions.get(0), instructions.get(1), instructions.get(2));
        if(opcode==8) equalsTo(instructions.get(0), instructions.get(1), instructions.get(2));
    }
    public void jump(int mode1, int mode2, int ifTrue) {
        int tmpIndex=index;
        if(ifTrue==1) {
            if(getByMode(mode1, index+1)!=0) tmpIndex=getByMode(mode2, index+2);
        }
        else {
            if(getByMode(mode1, index+1)==0) tmpIndex=getByMode(mode2, index+2);
        }
        if(tmpIndex!=index) index=tmpIndex;
        else index+=3;
    }
    public void lessThan(int mode1, int mode2, int mode3) {
        System.out.println("USED MODE: " + mode3);
        if(getByMode(mode1, index+1)<getByMode(mode2, index+2)) registers.set(getByMode(1, index+3), 1);
        else registers.set(registers.get(index+3), 0);
        index+=4;
    }
    public void equalsTo(int mode1, int mode2, int mode3) {
        System.out.println("USED MODE: " + mode3);
        if(getByMode(mode1, index+1)==getByMode(mode2, index+2)) registers.set(getByMode(1, index+3), 1);
        else registers.set(registers.get(index+3), 0);
        index+=4;
    }

    public void input() {
        System.out.println("ENTER INPUT PLEASE KIND SIR: ");
        Scanner in = new Scanner(System.in);
        registers.set(registers.get(index+1), in.nextInt());
        index+=2;
    }
    public void output(int mode1) {
        //System.out.println(registers.get(registers.get(index+1)));
        System.out.println(getByMode(mode1, index+1));
        index+=2;
    }
    public void add(int mode1, int mode2, int mode3) {
        registers.set(registers.get(index+3), getByMode(mode1, index+1)+getByMode(mode2, index+2));
        index+=4;
    }
    public void multiply(int mode1, int mode2, int mode3) {
        registers.set(registers.get(index+3), getByMode(mode1, index+1)*getByMode(mode2,index+2));
        index+=4;
    }
    public int getByMode(int mode, int i) {
        if(mode==0) return registers.get(registers.get(i));
        else return registers.get(i);
    }
}
