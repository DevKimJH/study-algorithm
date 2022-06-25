package studyAlgorithm.D220625;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 수빈이는 현재 점 N
 동새은 점 K
 
 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 혹은 X+1로 이동.
 순간이동을 하는 경우에는 1초 후에 2 * X 의 위치롱 ㅣ동
 
 가장 빠른 시간이 몇 초 후인지 구하는 프로그램 작성
 */
public class B1697 {

    static class Node{
        int location;
        int time;

        Node(int location, int time){
            this.location = location;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        process(N, K);
    }

    static void process(int N, int K){
        Queue<Node> queue = new LinkedList();
        boolean[] visitArr = new boolean[100001];
        int second = 1;


        if(N == K){
            System.out.println("0");
            return;
        }

        queue.add(new Node(N, second));
        visitArr[N] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            try {
                if (visitArr[node.location + 1] == false) {
                    if (node.location + 1 == K) {
                        System.out.println(node.time);
                        break;
                    } else {
                        visitArr[node.location + 1] = true;
                        queue.add(new Node(node.location + 1, node.time + 1));
                    }
                }
            }catch(Exception e){}

            try {


                if (visitArr[node.location - 1] == false) {
                    if (node.location - 1 == K) {
                        System.out.println(node.time);
                        break;
                    } else {
                        visitArr[node.location - 1] = true;
                        queue.add(new Node(node.location - 1, node.time + 1));
                    }
                }
            }catch(Exception e){}


            try {

                if (visitArr[node.location * 2] == false) {
                    if (node.location * 2 == K) {
                        System.out.println(node.time);
                        break;
                    } else {
                        visitArr[node.location * 2] = true;
                        queue.add(new Node(node.location * 2, node.time + 1));
                    }
                }
            }catch(Exception e){}
        }
    }
}
