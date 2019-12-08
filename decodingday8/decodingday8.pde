size(500,500);
strokeWeight(6);  
String encodedMessage="WBBWBBWWBBBWWBBWBBWBWBBWBWBBWBWBBWBWBBWBWBBWBWBBWBWBBWBWBBBBWBBBBWBBWBWWWWBWBBWBWBWWBWBBBBWBBWBWBBWBWBBWBWBBWBWBBWBWBBWBWBBWBBWWBBBWWWBBWWBBBWWBBWBBWB";


int i=1;
int x=100;
int y=100;
 for (char letter : encodedMessage.toCharArray())
  {
    if(letter=='B') {
      stroke(100);
      point(x,y);
    }
    else {
      stroke(50);
      point(x,y);
    }
    x+=6;
    if(i==25) {
      i=1;
      y+=6;
      x=100;
    }
    else i+=1;
  }
