package studyAlgorithm.D220419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 가장 왼쪽 위 좌표는 (1,1) 가장 오른쪽 아래 좌표는 (N,N)
 여행가 A는 상, 하, 좌, 우 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1,1)이다.
 우리 앞에는 여행가 A가 이동할 계획이 적힌 계획서가 놓여 있다.

 계획서에는 하나의 줄에 띄어쓰기를 기준으로 하여 L,R,U,D 중 하나의 문자가 반복적으로 적혀 있다. Left Right Up Down
 */



public class P04_1상하좌우 {

    static class People {
        int r;
        int c;

        People(int r, int c) {
            this.r = r;
            this.c = c;
        }

        void move(String direction, int N){

            switch(direction){
                case "R":
                    if(c < N){
                        this.c++;
                    }
                    break;
                case "L":
                    if(1 < c){
                        this.c--;
                    }
                    break;
                case "U":
                    if(1 < r){
                        this.r--;
                    }
                    break;
                case "D":
                    if(r < N){
                        this.r++;
                    }
                    break;
            }
        }
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 지도의 크기
        int N = Integer.parseInt(br.readLine());

        // 이동할 계획서 내용
        st = new StringTokenizer(br.readLine(), " ");

        People people = new People(1,1);

        int sizeOfToken = st.countTokens();

        for(int i = 0 ; i < sizeOfToken ; i++){
            String moveDirection = st.nextToken();


            people.move(moveDirection, N);
        }

        System.out.println(people.r + " " + people.c);
    }
}
