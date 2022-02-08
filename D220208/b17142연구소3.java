package studyAlgorithm.D220208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b17142연구소3 {

    static class virus{
        virus(int y, int x){
            this.y = y;
            this.x = x;
        }

        int x;
        int y;
    }

    static int[][] arrMap;
    static int[][] copyMap;
    static ArrayList<virus> virusList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arrMap = new int[N][N];
        virusList = new ArrayList<virus>();

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                int mapInfo = Integer.parseInt(st.nextToken());

                // Map set
                arrMap[i][j] = mapInfo;

                // 바이러스 위치 저장(virusList)
                if(mapInfo == 2){
                    virusList.add(new virus(i,j));
                }
            }
        }

        boolean[] selectVirus = new boolean[virusList.size()];
        int[] virus = new int[virusList.size()];

        virusComb(virus, selectVirus, 0, M);
    }

    static void virusComb(int[] virus, boolean[] selectVirus, int startIdx, int virusCnt){
        if(virusCnt == 0){
            copyMap = arrMap;
            process(selectVirus);
            return;
        }

        for(int i = startIdx ; i < virus.length ; i++){
            if(selectVirus[i] == false){
                selectVirus[i] = true;
                virusComb(virus, selectVirus, i+1, virusCnt-1);
                selectVirus[i] = false;
            }
        }
    }

    static void process(boolean[] selectVirus){

    }
}
