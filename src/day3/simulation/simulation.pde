class Wire {
  int x, y;
  String[] directions;
  Wire(String[] directionsIn) {
    directions=directionsIn;
    x=250;
    y=250;
  }
  void parse() {
    for(int i=0;i<directions.length;i++) {
      if(directions[i].charAt(0)=='L') goLeft(Integer.parseInt(directions[i].substring(1))/10);
      if(directions[i].charAt(0)=='R') goRight(Integer.parseInt(directions[i].substring(1))/10);
      if(directions[i].charAt(0)=='U') goUp(Integer.parseInt(directions[i].substring(1))/10);
      if(directions[i].charAt(0)=='D') goDown(Integer.parseInt(directions[i].substring(1))/10);      
    }
  }
  void goLeft(int delta) {
    line(x,y,x-delta,y);
    x=x-delta;
  }
  void goRight(int delta) {
    line(x,y,x+delta,y);
    x=x+delta;
  }
  void goUp(int delta) { 
    line(x,y,x,y-delta);
    y=y-delta;
  }
  void goDown(int delta) {
    line(x,y,x,y+delta);
    y=y+delta;
  }
}



void setup() {
  size(700, 700);
}

void draw() {
  background(153);
  String[] lines = loadStrings("C:\\Users\\chewb\\Downloads\\IntelIJ-Projects\\AdventOfCode3\\src\\day3\\input");
//println(lines);
  //println("there are: " + lines.length);

  String[] wire1=split(lines[0],",");
  String[] wire2=split(lines[1],",");
  Wire w1=new Wire(wire1);
  w1.parse();
  Wire w2=new Wire(wire2);
  w2.parse();
//println(wire1);
//println(wire2);
}
