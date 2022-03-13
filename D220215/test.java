package studyAlgorithm.D220215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int[] arr = { 1,2,3,4,5};

        for(int i = arr.length-1 ; i >= 0 ; i--){
            System.out.println(arr[i]);
        }
    }
}
