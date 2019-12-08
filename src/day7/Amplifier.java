package day7;

import day5.Computer;

import java.util.ArrayList;

public class Amplifier extends Computer {
    private int input;
    private int phase;
    private int output;

    Amplifier(int input, int phase, ArrayList<Integer> registers) {
        super();
        this.input=input;
        this.phase=phase;
        this.registers=registers;
    }
    public void input() {
        //while (this.registers.get(this.index)!=99 || this.index<this.registers.size()-1) this.index+=1;
        this.index+=2;
    }
    public void output(int mode1) {
        System.out.println("OUTPUT: " + getByMode(mode1,this.index));
        this.output=getByMode(mode1, this.index+1);
        while (this.registers.get(this.index)!=99 || this.index<this.registers.size()-1) this.index+=1;
    }
    public int getOutput() {return this.output;}
}
