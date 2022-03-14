package studyAlgorithm.D220314;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class p신고결과받기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        /*
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
           */

        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        // id_list만큼 배열 인덱스를 채번
        HashMap<String, Integer> answerMap = new HashMap();
        for(int i = 0 ; i < id_list.length ; i++){
            answerMap.put(id_list[i], i);
        }

        int[] answer = new int[id_list.length];

        HashMap<String, HashMap> hash = new HashMap();

        // hash 안에는 user_id가 키고, value에는 user_id를 신고한 사람이 들어가 있음 hash형태
        // 신고 내역 조회
        for(int i = 0 ; i < report.length ; i++){
            // reportData[0] : 유저 ID
            // reportData[1] : 유저가 신고한 ID
            String[] reportData = report[i].split(" ");

            HashMap userInfoMap = hash.get(reportData[1]);

            // 신고 History가 존재하지 않으면
            if(userInfoMap == null){
                userInfoMap = new HashMap();
                // 신고한 유저 ID를 담아서
                userInfoMap.put(reportData[0], "1");
                
                // hash에 추가
                hash.put(reportData[1], userInfoMap);
            }
            else{
                userInfoMap.put(reportData[0], "1");
                hash.put(reportData[1], userInfoMap);
            }
        }

        for(int i = 0 ; i < id_list.length ; i++){
            if(hash.get(id_list[i]) != null && hash.get(id_list[i]).size() >= k){
                //System.out.println(hash.get(id_list[i]) + " " + hash.get(id_list[i]).size());
                for(int j = 0 ; j < id_list.length ; j++){
                    if(hash.get(id_list[i]).containsKey(id_list[j])){
                        System.out.println(id_list[j]);
                        answer[answerMap.get(id_list[j])]++;
                    }
                }
            }
        }

        for(int i = 0 ; i < answer.length ; i++){
            System.out.print(answer[i]);
        }
    }
}
