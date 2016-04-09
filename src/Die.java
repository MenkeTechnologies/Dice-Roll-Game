import java.util.Random;

/**
 * Created by jacobmenke on 4/3/16.
 */

public class Die {
     int value = 0;

    Die (){
        Random rand = new Random();
       value = rand.nextInt(6) + 1;

    }

    public int getDieValue (){
        return value;
    }

}
