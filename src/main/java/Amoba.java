import java.util.Arrays;

public class Amoba
{
    private static int TABLE_WIDTH = 30;
    private static int TABLE_HEIGHT = 30;

    private static char SIGN_EMPTY = '.';
    private static char SIGN_X = 'X';
    private static char SIGN_O = 'O';

    private char[][] gameField = new char[TABLE_WIDTH][TABLE_HEIGHT];

    public Amoba()
    {
        init();
        for (char[] is : gameField)
        {
            System.out.println(Arrays.toString(is));
        }
        System.out.println(isEndGame());
    }

    public void init()
    {
        boolean isX = true;
        for (int j = 0; j < gameField.length; j++)
        {
            for (int i = 0; i < gameField[j].length; i++)
            {
                double p = Math.random();
                if (p < 0.5)
                {
                    gameField[j][i] = SIGN_EMPTY;
                }
                else
                {
                    gameField[j][i] = isX ? SIGN_X : SIGN_O;
                    isX = !isX;
                }
            }
        }
    }

    public  boolean isEndGame()
    {
        int counter = 0;
        for (int j = 0; j < gameField.length; j++) {

            for (int i = 0; i < gameField[j].length; i++) {

            if(gameField[j][i] == 'X'){
                int vizszintes = i;
                int fuggoleges = j;
                if(vizszintes!=29){
                    while (gameField[j][vizszintes+1] == 'X'){
                        counter +=1;
                        if(vizszintes+1<TABLE_WIDTH && vizszintes+1 != TABLE_WIDTH-1){
                            vizszintes++;
                        }
                        if(counter == 5){
                            return true;
                        }
                    }
                }

                counter = 0;
                vizszintes = j;
                fuggoleges = i;
                if(vizszintes!=29 && fuggoleges !=29) {
                    while (gameField[fuggoleges + 1][vizszintes + 1] == 'X') {
                        counter += 1;
                        if (fuggoleges + 1 < TABLE_HEIGHT && fuggoleges+1 != TABLE_HEIGHT - 1 && vizszintes + 1 < TABLE_WIDTH && vizszintes+1 != TABLE_WIDTH - 1) {
                            fuggoleges++;
                            vizszintes++;
                        }

                        if (counter == 5) {
                            return true;
                        }
                    }
                }

                fuggoleges = i;
                if(fuggoleges!=29) {
                    while (gameField[fuggoleges + 1][i] == 'X') {
                        counter += 1;
                        if (fuggoleges + 1 < TABLE_HEIGHT && fuggoleges+1 != TABLE_HEIGHT - 1) {
                            fuggoleges++;
                        }
                        if (counter == 5) {
                            return true;
                        }
                    }

                }




            } else if(gameField[j][i] =='O') {
                int vizszintes = i;
                int fuggoleges = j;
                if (vizszintes != 29) {
                    while (gameField[j][vizszintes + 1] == 'O') {
                        counter += 1;
                        if (vizszintes + 1 < TABLE_WIDTH && vizszintes + 1 != TABLE_WIDTH - 1) {
                            vizszintes++;
                        }
                        if (counter == 5) {
                            return true;
                        }
                    }
                }

                counter = 0;
                vizszintes = j;
                fuggoleges = i;
                if (vizszintes != 29 && fuggoleges != 29) {
                    while (gameField[fuggoleges + 1][vizszintes + 1] == 'O') {
                        counter += 1;
                        if (fuggoleges + 1 < TABLE_HEIGHT && fuggoleges + 1 != TABLE_HEIGHT - 1 && vizszintes + 1 < TABLE_WIDTH && vizszintes + 1 != TABLE_WIDTH - 1) {
                            fuggoleges++;
                            vizszintes++;
                        }

                        if (counter == 5) {
                            return true;
                        }
                    }
                }

                fuggoleges = i;
                if (fuggoleges != 29) {
                    while (gameField[fuggoleges + 1][i] == 'O') {
                        counter += 1;
                        if (fuggoleges + 1 < TABLE_HEIGHT && fuggoleges + 1 != TABLE_HEIGHT - 1) {
                            fuggoleges++;
                        }
                        if (counter == 5) {
                            return true;
                        }
                    }
                }
            }
            }

            }
        return  false;
    }

    public static void main(String[] args)
    {
        new Amoba();


    }
}