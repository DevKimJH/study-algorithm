package studyAlgorithm.M2207.D1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 R x C 격자판
 r,c에 있는 미세먼지를 실시간 모니터링

 공기청정기는 항상 1열에 설치

 크기는 두 행을 차지

 공기청정기가 설치되어 있지 않은 칸은 미세먼지가 있음. (r,c)에 있는 미세먼지 양은 A(r,c)

 1초 동안 순서대로 일어나는 일

 미세먼지가 확산

 (r,c)에 있는 미세먼지는 인접한 네 방향으로 확산
 인접한 방향에 공기청정기가 있거나 칸이 없으면 그 방향으로 확산 X
 확산되는 양은 A(r,c/5), 소수점은 버림
 (r,c)에 남은 미세먼지 양은 A(r,c) - A(r,c/5) * 확산 방향 개수
 공기청정기가 작동

 공기청정기는 바람이 나온다
 위쪽 공기청정기의 바람은 반시계방향으로 순환, 아래쪽 공기청정기의 바람은 시계방향으로 순환
 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동
 공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
 TEST (1)
 3 3 1
 5 0 0
 0 0 0
 0 0 0

 TEST (2)
 3 3 1
 0 0 0
 0 46 0
 0 0 0

 TEST (3)
 3 3 1
 10 0 15
 0 0 0
 0 0 0

 TEST(4)
 3 3 1
 10 0 15
 -1 0 0
 -1 0 0

 TEST (4)
 3 3 1
 0 30 7
 -1 10 0
 -1 0 20
 */
public class B17144 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    // 공기청정기 위 (시계방향 회전을 위한)
    static int[] mr = {-1, 0, 1, 0};
    static int[] mc = {0, 1, 0, 1};



    static class Node{

        int r;
        int c;

        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // Row
        int R = Integer.parseInt(st.nextToken());

        // Col
        int C = Integer.parseInt(st.nextToken());

        // T초 후 방에 남아 있는 미세먼지 양 구해야함
        int T = Integer.parseInt(st.nextToken());

        int[][] mapArr = new int[R][C];
        Node[] nodes = new Node[2];
        int idx = 0;
        // Map Set
        for(int i = 0 ; i < R ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < C ; j++){
                int inputNum = Integer.parseInt(st.nextToken());
                if(inputNum == -1){
                    nodes[idx++] = new Node(i,j);
                }
                mapArr[i][j] = inputNum;
            }
        }

        int[][] mapArrClone = null;

        // T초 동안 실행
        for(int i = 0 ; i < T ; i++){
            mapArrClone = new int[R][C];
            /* 1. 미세먼지 확산 */
            spreadDust(mapArr, mapArrClone);
            mapArr = mapArrClone;

            /* 2. 공기청정기 작동 */
            machineOperate(mapArr, nodes);
        }

        printMap(mapArr);
    }


    static void spreadDust(int[][] mapArr, int[][] mapArrClone){
        int rowSize = mapArr.length;
        int colSize = mapArr[0].length;

        for(int i = 0 ; i < rowSize ; i++){
            for(int j = 0 ; j < colSize ; j++){

                int countSpread = 0; // 퍼진 횟수
                int dust = mapArr[i][j]; // 미세먼지 농도
                if(dust > 0){
                    for(int k = 0 ; k < 4 ; k++){
                        int nextR = i + dr[k];
                        int nextC = j + dc[k];

                        if(0 <= nextR && nextR < rowSize && 0 <= nextC && nextC < colSize){
                            if(mapArr[nextR][nextC] != -1){
                                countSpread++;
                                mapArrClone[nextR][nextC] = mapArrClone[nextR][nextC] + mapArr[i][j]/5;
                            }
                        }
                    }

                    mapArrClone[i][j] = mapArrClone[i][j] + mapArr[i][j] - (mapArr[i][j]/5 * countSpread);
                }

                if(dust == -1){
                    mapArrClone[i][j] = mapArr[i][j];
                }
            }
        }
    }

    static void printMap(int[][] mapArr){
        for(int i = 0 ; i < mapArr.length ; i++){
            for(int j = 0 ; j < mapArr[0].length ; j++){
                System.out.print(mapArr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static void machineOperate(int[][] mapArr, Node[] nodes){
        // 1. 공기청정기 위   ( 반시계방향 )
        int startR = nodes[0].r;
        int startC = nodes[0].c;
        for(int i = 0 ; i < 4 ; i++){
            while(true){

                if(startR == 2 && startC == 7){
                    System.out.println("");
                }

                int nextR = startR + mr[i];
                int nextC = startC + mc[i];

                if(0 <= nextR && nextR < mapArr.length && 0 <= nextC && nextC < mapArr[0].length){
                    if(mapArr[startR][startC] != -1){
                        mapArr[startR][startC] = mapArr[nextR][nextC];
                    }
                    startR = nextR;
                    startC = nextC;
                }
                else{
                    break;
                }
            }
        }

        startR = nodes[1].r;
        startC = nodes[1].c;
        // 2. 공기청정기 아래 ( 시계방향 )
        for(int i = 0 ; i < 4 ; i++){
            while(true){
                int nextR = startR + mr[i];
                int nextC = startC + mc[i];

                if(0 <= nextR && nextR < mapArr.length && 0 <= nextC && nextC < mapArr[0].length){
                    if(mapArr[startR][startC] != -1){
                        mapArr[startR][startC] = mapArr[nextR][nextC];
                    }
                    startR = nextR;
                    startC = nextC;
                }
                else{
                    break;
                }
            }
        }
    }
}

