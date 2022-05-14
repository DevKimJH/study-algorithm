package studyAlgorithm.D220509;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P퀵정렬 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] array = { 5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        //System.out.println(array[array.length-1]);
        Process(array, 0, array.length-1);

        for(int i = 0 ; i < array.length ; i++){
            System.out.print(array[i] + " ");
        }

    }

    static void Process(int[] array, int start, int end){
        // 원소가 1개인 경우 종료
        if(start >= end){
            return;
        }

        // pivot은 첫 번째 원소
        int pivot = array[start];

        int left = start+1;
        int right = end;

        while(left <= right){
            // Pivot보다 큰 데이터를 찾을 때 까지 반복
            while(left <= end && pivot <= array[left]){
                left = left+1;
            }

            // Pivot보다 작은 데이터를 찾을 때까지 반복
            while(start < right && pivot > array[right]){
                right = right-1;
                break;
            }
            
            // 엇갈렸다면 작은 데이터와 피벗을 교체
            if(left > right){
                int idx = 0;
                if(array[left] > array[right]){
                    idx = left;
                }
                else{
                    idx = right;
                }

                int temp = array[start];
                array[start] = array[idx];
                array[idx] = temp;
            }
            // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            else{
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
        Process(array, start, right-1);
        Process(array, right+1, end);
    }
}
