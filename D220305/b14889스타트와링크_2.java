package studyAlgorithm.D220305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 축구를 하기 위해 모인 사람은 총 N명. N명은 신기하게도 짝수
 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.

 번호를 1부터 N까지 배정했고, 능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치
 팀에 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합.
 Sij와 Sji는 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는
 Sij와 Sji이다.

 축구를 재미있게 하기 위해 팀의 능력치의 차이를 최소로 하려고 한다.

 입력
 ---
 첫째 줄에 N(4 ≤ N ≤ 20, N은 짝수)이 주어진다. 둘째 줄부터 N개의 줄에 S가 주어진다.
 각 줄은 N개의 수로 이루어져 있고, i번 줄의 j번째 수는 Sij 이다. Sii는 항상 0이고,
 나머지 Sij는 1보다 크거나 같고, 100보다 작거나 같은 정수이다.
 */
public class b14889스타트와링크_2 {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] abilityArray = new int[N][N];
        ArrayList<Integer> firstGroup = new ArrayList<>();
        ArrayList<Integer> secondGroup = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                abilityArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        process(N, abilityArray, 0, firstGroup, secondGroup);

        System.out.println(answer);
    }


    static void process(int N, int[][] abilityArray, int idx, ArrayList<Integer> firstGroup, ArrayList<Integer> secondGroup){
        if(idx == N){
            if (firstGroup.size() != N / 2) return;
            if (secondGroup.size() != N / 2) return;

            int firstScore = 0;
            int secondScore = 0;

            for(int i = 0 ; i < N/2 ; i++){
                for(int j = 0 ; j < N/2 ; j++){
                    if(i == j) continue;
                    firstScore += abilityArray[firstGroup.get(i)][firstGroup.get(j)];
                    secondScore += abilityArray[secondGroup.get(i)][secondGroup.get(j)];
                }
            }

            int resultValue = Math.abs(firstScore - secondScore);
            if(answer > resultValue) answer = resultValue;
        }

        if(idx >= N) return;

        firstGroup.add(idx);
        process(N, abilityArray, idx+1, firstGroup, secondGroup);
        firstGroup.remove(firstGroup.size()-1);

        secondGroup.add(idx);
        process(N, abilityArray, idx+1, firstGroup, secondGroup);
        secondGroup.remove(secondGroup.size()-1);
    }

    static void calcScore(int[][] abilityArray, boolean[] chkArray, int N){
        int firstIdx = 0;
        int secondIdx = 0;
        int[] firstGroup = new int[N/2];
        int[] secondGroup = new int[N/2];
        int firstScore = 0;
        int secondScore = 0;

        for (int i = 0; i < N; i++) {
            if (chkArray[i] == true) {
                firstGroup[firstIdx++] = i;
            } else {
                secondGroup[secondIdx++] = i;
            }
        }

        for(int i = 0 ; i < N/2 ; i++){
            for(int j = 0 ; j < N/2 ; j++){
                if(i == j) continue;
                firstScore += abilityArray[firstGroup[i]][firstGroup[j]];
                secondScore += abilityArray[secondGroup[i]][secondGroup[j]];
            }
        }

        int resultValue = Math.abs(firstScore - secondScore);
        if(answer > resultValue) answer = resultValue;
    }
}
