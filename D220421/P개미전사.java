package studyAlgorithm.D220421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 개미 전사는 부족한 식량을 충당하고자 메뚜기 마을의 식량창고를 몰래 공격하려고 한다.
 메뚜기 마을에는 여러 개의 식량창고가 있는데 식량창고는 일직선으로 이어져 있다.
 각 식량창고에는 정해진 수의 식량을 저장하고 있으며 개미 전사는 식량창고를 선택적으로 약탈하여 식량을 빼앗을 예정이다.
 이때 메뚜기 정찰병들은 일직선상에 존재하는 식량창고 중에서 서로 인접한 식량창고가 공격받으면 바로 알아챌 수 있다. 따라서 개미 전사가
 정찰병에게 들키지 않고 식량창고를 약탈하기 위해서는 최소한 한 칸 이상 떨어진 식량창고를 약탈해야 한다. 예를 들어 식량창고 4개가 다음과 같이 존재한다고 가정하자.

 {1, 3, 1, 5}

 이때 개미 전사는 두 번째 식량창고와 네 번째 식량창고를 선택했을 때 최댓값인 총 8개의 식량을 빼앗을 수 있다.


 */
public class P개미전사 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 식량창고의 개수
        int N = Integer.parseInt(br.readLine());

        int[] storage = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < N ; i++){
            storage[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[105];

        dp[0] = storage[0] + storage[2];
        dp[1] = storage[1] + storage[3];

        for(int i = 2 ; i < N-1 ; i++){
            dp[i] = Math.max(dp[i] + storage[i-2], dp[i] + storage[i+2]);
        }

        dp[N-1] = storage[N-1] + storage[N-3];
        dp[N-2] = storage[N-2] + storage[N-4];
    }
}
