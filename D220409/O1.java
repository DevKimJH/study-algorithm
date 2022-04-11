package studyAlgorithm.D220409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 오늘의집에서 구매한 물건은 로봇이 자동 배송한다. 이 로봇은 물건 배달지에서
 네비게이션의 안내를 따라 이동한다. 네비게이션의 다음 방향 변경 지점까지의 거리가 500m이거나, 출발 혹은 방향 변경 직후
 다음 방향 변경 지점까지의 거리가 500m 이하이면 다음 형식으로 메시지를 보낸다.

 Time x : Go straight ym and turn direction

 x : 네비게이션이 안내 메시지를 보내는 시간을 의미. 출발 직후 시간은 0.
 100m 이동할 때마다 단위 시간 1만큼 소요. 방향을 변경하는 데는 시간이 소요되지 않는다.

 y : 다음 방향 변경 지점까지의 직선 거리

 direction : 진행 방향 기준으로 바꾸어야 할 방향 left 혹은 right

 로봇은 x축과 y축이 서로 직교하는 2차원 평면상에서 축과 평행하게 이동하며, 로봇이 이동할 경로는
 동 서 남 북 4가지 문자로 구성된 문자열 형식으로 주어진다.

 로봇은 항상 정면을 바라본 상태로 직진. 방향을 바꿀 때는, 고정된 위치에서 90도로


 */
public class O1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        ArrayList<String> answerList = new ArrayList();

        String path = "EEESEEEEEENNNN";
        //String path = "SSSSSSWWWNNNNNN";
        //System.out.print((int)'E');
        //System.out.print((int)'W');

        char prevDirection = path.charAt(0); // 이전 process에서 진행중이던 방향
        // 네비게이션 출력시 가지고 있어야할 시간 변수
        int prevTime = 0;

        // 시간이 얼마나 흘렀는지 계산하기 위한 변수
        int time = 0;

        int cnt = 1; // 100m 단위로 얼마나 가야하는지 체크
        for(int i = 1 ; i < path.length() ; i++){
            char nextDirection = path.charAt(i);
            // 이전이랑 방향이 같으면
            if(prevDirection == nextDirection){
                cnt++;
                time++;
            }
            // 방향이 다르면
            else{
                String turnDirection = getTurnDirection(prevDirection, nextDirection);
                if(cnt > 5){
                    int calcOverTime = cnt - 5;
                    cnt = cnt - calcOverTime;
                    prevTime = prevTime + calcOverTime;
                }
                //System.out.println("Time " + prevTime + ": Go Straight " + (cnt*100) + "m and turn " + turnDirection);
                answerList.add("Time " + prevTime + ": Go straight " + (cnt*100) + "m and turn " + turnDirection);
                cnt = 1;
                time++;
                prevTime = time;
                prevDirection = nextDirection;
            }
        }

        String[] answer = new String[answerList.size()];

        for(int i = 0 ; i < answerList.size() ; i++){
            answer[i] = answerList.get(i);
        }

        for(int i = 0 ; i < answer.length ; i++){
            System.out.println(answer[i]);
        }

    }

    static String getTurnDirection(char prevDirection, char nextDirection){
        switch(prevDirection){
            case 'N':
                if(nextDirection == 'W') return "left";
                else return "right";
            case 'E':
                if(nextDirection == 'N') return "left";
                else return "right";
            case 'S':
                if(nextDirection == 'E') return "left";
                else return "right";
            case 'W':
                if(nextDirection == 'S') return "left";
                else return "right";
            default:
                return null;
        }
    }
}
