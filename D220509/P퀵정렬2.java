package studyAlgorithm.D220509;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P퀵정렬2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] array = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        QuickSort(array, 0, array.length-1);

        for(int i = 0 ; i < array.length ; i++){
            System.out.print(array[i] + " " );
        }
    }

    static void QuickSort(int[] array, int left, int right){
        if(left < right){
            int pivot = partition(array, left, right);

            QuickSort(array, left, pivot-1);
            QuickSort(array, pivot+1, right);
        }
    }

    static int partition(int[] array, int left, int right){
        int pivot = array[(left+right)/2];

        while(left < right){
            while((array[left] < pivot) && (left < right)){
                left++;
            }

            while((array[right] > pivot) && (left < right)){
                right--;
            }

            if(left < right){
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }

        return left;
    }


}
