package day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class ComputerLong {
    protected HashMap<Long, Long> registers;
    protected long index=0;
    protected long relativeBase=0;
    public ComputerLong() { super(); }
    public ComputerLong(HashMap<Long,Long> registersIn) {
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
            if(registers.get(index)>=100) {
                String parameters=Long.toString(registers.get(index));
                ArrayList<Integer> instructions=new ArrayList<Integer>();
                int opcode =Integer.parseInt(parameters.substring(parameters.length()-2));
                instructions=parseParameters(instructions,parameters.substring(0,parameters.length()-2));
                runInstruction(opcode, instructions);
            }
            else runInstruction(registers.get(index), new ArrayList<Integer>(Arrays.asList(tmpArr)));
        }
//        if(registers.get(index)==99) System.out.println(index + " : " +registers.get(index));
    }
    public void runInstruction(long opcode, ArrayList<Integer> instructions) {
        if(opcode==1) add(instructions.get(0),instructions.get(1),instructions.get(2));
        if(opcode==2) multiply(instructions.get(0),instructions.get(1),instructions.get(2));
        //if(opcode==99) halt();
        if(opcode==3) input(instructions.get(0));
        if(opcode==4) output(instructions.get(0));
        if(opcode==5) jump(instructions.get(0), instructions.get(1),1);
        if(opcode==6) jump(instructions.get(0), instructions.get(1),0);
        if(opcode==7) lessThan(instructions.get(0), instructions.get(1), instructions.get(2));
        if(opcode==8) equalsTo(instructions.get(0), instructions.get(1), instructions.get(2));
        if(opcode==9) adjustRelativeBase(instructions.get(0));
    }
    public void adjustRelativeBase(int mode1) {
        relativeBase+=getByModeRead(mode1, index+1);
        index+=2;
    }
    public void jump(int mode1, int mode2, int ifTrue) {
        long tmpIndex=index;
        if(ifTrue==1) {
            if(getByModeRead(mode1, index+1)!=0) tmpIndex=getByModeRead(mode2, index+2);
        }
        else {
            if(getByModeRead(mode1, index+1)==0) tmpIndex=getByModeRead(mode2, index+2);
        }
        if(tmpIndex!=index) index=(int)tmpIndex;
        else index+=3;
    }
    public void lessThan(int mode1, int mode2, int mode3) {
        if(getByModeRead(mode1, index+1)<getByModeRead(mode2, index+2)) registers.put(getByModeWrite(mode3, index+3), 1L);
        else registers.put(getByModeWrite(mode3,index+3), (long)0);
        index+=4;
    }
    public void equalsTo(int mode1, int mode2, int mode3) {
        if(getByModeRead(mode1, index+1)==getByModeRead(mode2, index+2)) registers.put(getByModeWrite(mode3, index+3), 1L);
        else registers.put(getByModeWrite(mode3,index+3), (long)0);
        index+=4;
    }

    public void input(int mode) {
        System.out.println("ENTER INPUT PLEASE KIND SIR: ");
        Scanner in = new Scanner(System.in);
        registers.put(getByModeWrite(mode, index+1), in.nextLong());
        index+=2;
    }
    public void output(int mode1) {
        System.out.println(getByModeRead(mode1,index+1));
        index+=2;
    }
    public void add(int mode1, int mode2, int mode3) {
        registers.put(getByModeWrite(mode3, index+3), getByModeRead(mode1, index+1)+getByModeRead(mode2, index+2));
        index+=4;
    }
    public void multiply(int mode1, int mode2, int mode3) {
        long n1=getByModeRead(mode1, index+1);
        long n2=getByModeRead(mode2, index+2);
        //System.out.println(n1 + " * " + n2 + " = " + n1*n2);
        registers.put(getByModeWrite(mode3,index+3), n1*n2);
        index+=4;
    }
    public long getByModeRead(int mode, long i) {
        mode=checkIfNegative(i,mode);
        if(mode==0) return checkIfExists(registers.get(i));
        else if(mode==1) return checkIfExists(i);
        else return checkIfExists(registers.get(i)+relativeBase);
    }
    public long getByModeWrite(int mode, long i) {
        if (mode==0) return registers.get(i);
        else return registers.get(i)+relativeBase;
    }
    public long checkIfExists(long i) {
        if(registers.get(i)==null) registers.put(i,0L);
        return registers.get(i);
    }
    public int checkIfNegative(long i, int mode) {
        if (mode==2) {
            if((registers.get(i)+relativeBase)<0) mode=1;
        }
        else {
            if(registers.get(i)<0) mode=1;
        }
        return mode;
    }

}
