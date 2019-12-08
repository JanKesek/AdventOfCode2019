import java.lang.reflect.Array;

public class Panel {
    char squareSize[][] = new char[1000][1000];
    Panel() {
        for(int i=0;i<1000;i++) {
            for (int  j = 0; j < 1000; j++) {
                System.out.print(".");
            }
            System.out.println("");
        }
    }
}
