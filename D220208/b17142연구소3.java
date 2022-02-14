package studyAlgorithm.D220208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b17142연구소3 {

    static class virus{

        virus(){}

        virus(int y, int x){
            this.y = y;
            this.x = x;
        }

        virus(int y, int x, int score){
            this.y =y;
            this.x = x;
            this.score =score;
        }

        int x;
        int y;
        int score;
    }

    static int[][] arrMap;
    static int[][] copyMap;
    static boolean[][] visit;
    static int answer = 99;

    static ArrayList<virus> virusList;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static virus[][] virusMap;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arrMap = new int[N][N];
        visit = new boolean[N][N];
        virusList = new ArrayList<virus>();
        virusMap  = new virus[N][N];

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

        System.out.println(answer);
    }

    static void virusComb(int[] virus, boolean[] selectVirus, int startIdx, int virusCnt){
        if(virusCnt == 0){
            copyMap = arrMap;

            for(int i = 0 ; i < arrMap.length ; i++){
                for(int j = 0 ; j < arrMap.length ; j++){
                    visit[i][j] = false;
                    virusMap[i][j] = new virus(i,j,Integer.MAX_VALUE);
                    virusMap[i][j].score = 99;
                }
            }

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
        for(int i = 0 ; i < selectVirus.length ; i++){
            if(selectVirus[i] == true){

                for(int j = 0 ; j < virusList.size() ; j++){
                 //   virusMap[virusList.get(j).y][virusList.get(j).x].score = 0;
                }

                virusMap[virusList.get(i).y][virusList.get(i).x].score = 0;
                visit = new boolean[arrMap.length][arrMap.length];
                bfs(i);
            }
        }

        int maxNum = 0;

        for(int i = 0 ; i < virusMap.length ; i++){
            for(int j = 0 ; j < virusMap[0].length ; j++){
                String s = String.format("%02d", virusMap[i][j].score);
                System.out.print(s + " ");
                if(virusMap[i][j].score != 99 && maxNum < virusMap[i][j].score) maxNum = virusMap[i][j].score;
            }
            System.out.println("");
        }
        System.out.println("");
        if(answer > maxNum) answer = maxNum;
    }

    // 바이러스 퍼트리기
    static void bfs(int idx){
        Queue queue = new LinkedList();
        virus virus = new virus();

        virus.x = virusList.get(idx).x;
        virus.y = virusList.get(idx).y;
        virus.score = 0;
        queue.add(virus);
        visit[virus.y][virus.x] = true;

        while (!queue.isEmpty()) {
            virus point = (virus)queue.poll();
            visit[point.y][point.x] = true;

            for(int i = 0 ; i < 4 ; i++){
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];

                if(0 <= nextX && 0 <= nextY){
                    if(nextY < copyMap.length && nextX < copyMap[0].length){
                        if(virusMap[nextY][nextX].score >= virusMap[point.y][point.x].score+1 && copyMap[nextY][nextX] == 0 && visit[nextY][nextX] == false){
                            virusMap[nextY][nextX].score = virusMap[point.y][point.x].score+1;
                            //System.out.print(virusMap[nextY][nextX].score + " ");
                            queue.add(new virus(nextY, nextX));
                        }
                    }
                }
            }
        }
        //System.out.println("");
    }
}
