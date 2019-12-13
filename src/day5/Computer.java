package day5;

import java.util.*;

public class Computer {
    protected ArrayList<Integer> registers;
    HashMap<Integer, Long> longValues=new HashMap<>();
    protected int index=0;
    protected int relativeBase=0;
    public Computer() { super(); }
    public Computer(ArrayList<Integer> registersIn) {
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
            System.out.println(index + " : " + registers.get(index));
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
        if(opcode==9) adjustRelativeBase(instructions.get(0));
    }
    public void adjustRelativeBase(int mode1) {
        relativeBase+=getByMode(mode1, index+1);
        index+=2;
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
        //System.out.println("USED MODE: " + mode3);
        if(getByMode(mode1, index+1)<getByMode(mode2, index+2)) registers.set(getByMode(1, index+3), 1);
        else registers.set(registers.get(index+3), 0);
        index+=4;
    }
    public void equalsTo(int mode1, int mode2, int mode3) {
        //System.out.println("USED MODE: " + mode3);
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
        System.out.println("PRINTING LONGS");
        for(int i : longValues.keySet()) System.out.println(longValues.get(i));
        if(longValues.containsKey(index+1)) System.out.println("LONG VALUE: " + longValues.get(index+1));
        index+=2;
    }
    public int checkIfOverflow(int a, int b, char operation) {
        Long c=0L;
        if(operation=='+') c = (long)a+(long)b;
        else c=(long)a*(long)b;
        System.out.println("WARTOSC" + c);
        if (c > Integer.MAX_VALUE || c < Integer.MIN_VALUE) {
            System.out.println("ZA DUZA: " + c + " do indeksu: " + (index+3));
            longValues.put(index+3, c);
            return c.intValue();
        }
        else return c.intValue();
    }
    public void add(int mode1, int mode2, int mode3) {
        int n=checkIfOverflow(getByMode(mode1,index+1),getByMode(mode2, index+2),'+');
        registers.set(getByMode(1, index+3), n);
        index+=4;
    }
    public void multiply(int mode1, int mode2, int mode3) {
        int n1=getByMode(mode1, index+1);
        int n2=getByMode(mode2, index+2);
        int n3=checkIfOverflow(n1,n2,'*');
        System.out.println("CASTING TO INT: " + n3);
        System.out.println(n1 + " * " + n2 + " = " + n3);
        registers.set(registers.get(index+3), n3);
        index+=4;
    }
    public int getByMode(int mode, int i) {
        checkMemory(mode,i);
        mode=checkIfNegative(i,mode);
        if(mode==0) return registers.get(registers.get(i));
        else if(mode==1) return registers.get(i);
        else return registers.get(registers.get(i)+relativeBase);
    }
    public int checkIfNegative(int i, int mode) {
        if (mode==2) {
            if((registers.get(i)+relativeBase)<0) mode=1;
        }
        else {
            if(registers.get(i)<0) mode=1;
        }
        return mode;
    }
    public void checkMemory(int mode, int i) {
        if(mode==0) {
            if (registers.get(i)>=registers.size()) extendMemory(registers.get(i));
        }
        if(mode==1) {
            if (i>=registers.size()) extendMemory(i);
        }
        else {
            if((registers.get(i)+relativeBase)>=registers.size()) extendMemory(registers.get(i)+relativeBase);
        }
    }
    public void extendMemory(int i) {
        while (i>=registers.size()) registers.add(0);
    }
}
