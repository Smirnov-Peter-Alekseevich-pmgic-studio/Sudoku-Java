package sample.game;

import java.util.ArrayList;

public class SudokuRenderer{
    public static int[][] GetSudoku(){
        int[][] place = new int[9][9];
        int errors = 0;
        for(int x = 0;x < 9;x++){
            for(int y = 0;y < 9;y++){
                ArrayList<Integer> vertical = new ArrayList<>();
                ArrayList<Integer> horizontal = new ArrayList<>();
                for(int i = 0;i < 9;i++){
                    vertical.add(place[x][i]);
                    horizontal.add(place[i][y]);
                }
                int number = (int) (Math.random() * 9);
                int numberOfUpdates = 0;
                boolean isSetNumber = true;
                while (ThereIsInList(vertical,number) || ThereIsInList(horizontal,number) || ThereIsInKvadrat(x,y,place,number)){
                    if(number > 8)number = -1;
                    number++;
                    if(numberOfUpdates >= 9){
                        if(errors > 10) {
                            System.out.println("many errors");
                            return GetSudoku();
                        }else{
                            System.out.println("error");
                            errors++;
                        }
                        y = -1;
                        isSetNumber = false;
                        for(int i = 0;i < 9;i++){
                            place[x][i] = 0;
                        }
                        break;
                    } else numberOfUpdates++;
                }
                if(isSetNumber){place[x][y] = number;
                }
            }
            //System.out.println("shut down errors");
            errors = 0;
            for(int i = 0;i < 9;i++) {
                System.out.print(place[x][i]);
            }
            System.out.println();
        }
        return place;
    }
    private static boolean ThereIsInList(ArrayList<Integer> list,int number){
        for (int i : list) {
            if(number == i)return true;
        }
        return false;
    }
    private static boolean ThereIsInKvadrat(int x,int y,int[][] place,int number){
        int prefixDown = 0;
        int prefixRight = 0;
        if(x < 3 && y < 3){

        } else if(x < 3 && y < 6){
            prefixRight = 3;
        } else if(x < 3 && y < 9){
            prefixRight = 6;
        } else if(x < 6 && y < 3){
            prefixDown = 3;
        } else if(x < 6 && y < 6){
            prefixDown = 3;
            prefixRight = 3;
        } else if(x < 6 && y < 9){
            prefixDown = 3;
            prefixRight = 6;
        } else if(x < 9 && y < 3){
            prefixDown = 6;
        } else if(x < 9 && y < 6){
            prefixDown = 6;
            prefixRight = 3;
        } else if(x < 9 && y < 9){
            prefixDown = 6;
            prefixRight = 6;
        }
        for(int x1 = 0;x1 < 3;x1++){
            for(int y1 = 0;y1 < 3;y1++){
                if(place[x1 + prefixDown][y1 + prefixRight] == number)return true;
            }
        }
        return false;
    }
}