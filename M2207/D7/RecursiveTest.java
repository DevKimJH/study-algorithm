package studyAlgorithm.M2207.D7;


import java.util.Arrays;

public class RecursiveTest {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};

        recurTest(array, 1);

        System.out.println(array[1]);

        int[] array2 = array.clone();
        System.out.println(array2);
    }


    static void recurTest(int[] array, int idx){
        if(idx == 1) {
                System.out.println("1" + array);
        }

        if(idx == 2){
                System.out.println("2" + array);
                array[1] = 10;
                return;
        }

        recurTest(array, idx+1);
    }
}
