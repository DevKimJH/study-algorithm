package studyAlgorithm.M2207.D14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class B25330 {

    static class Village {
        int monsterHP;
        int P;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 몬스터 수
        int N = Integer.parseInt(st.nextToken());

        // 주인공 초기 체력
        int K = Integer.parseInt(st.nextToken());

        /* 마을 설정 */
        Village[] village = new Village[N];

        /* 몬스터 체력 설정 */
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            village[i] = new Village();
            village[i].monsterHP = Integer.parseInt(st.nextToken());
        }

        /* 주민 설정 */
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            village[i].P = Integer.parseInt(st.nextToken());
        }

        /* 주민수 / 체력 순으로 정렬 */
        Arrays.sort(village, new Comparator<Village>() {
            @Override
            public int compare(Village o1, Village o2) {
                return Double.compare(o2.P * 1.0 / o2.monsterHP, o1.P * 1.0 / o1.monsterHP);
            }
        });

        int answer = 0;

        for (int i = 0; i < N; i++) {

            // 0부터 i까지 마이너스
            for (int j = 0; j <= i; j++) {
                K = K - village[j].monsterHP;
            }

            if (K >= 0) {
                answer = answer + village[i].P;
            } else {
                break;
            }
        }

        System.out.print(answer);
    }
}