package studyAlgorithm.D220422;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 크기가 N * N인 격자
 N은 항상 홀수, (R,C)는 R행 C열을 의미
 격자의 가장 왼쪽 윗 칸은 (1,1) 가장 오른쪽 아랫 칸은 (N,N)
 마법사 상어는 ((N+1)/2 , (N+1)/2))

 N = 3
 ---
 8 7 6
 1 X 5
 2 3 4


 N = 5
 -----
 24 23 22 21 20
 09 08 07 06 19
 10 01 XX 05 18
 11 02 03 04 17
 12 13 14 15 16

 N = 7
 -----
 48 47 46 45 44 43 42
 25 24 23 22 21 20 41
 26 09 08 07 06 19 40
 27 10 01 XX 05 18 39
 28 11 02 03 04 17 38
 29 12 13 14 15 16 37
 30 31 32 33 34 35 36

Log10 = 1




 */


public class B21611마법사상어와블리자드 {

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};

    static int[] blizardR = {0, -1, 1, 0, 0};
    static int[] blizardC = {0, 0, 0, -1, 1};

    public static class Node{
        int beedScore;  // 구슬 종류(1번, 2번, 3번)
        int idx;        // 해당 위치의 나선형idx
        int r;
        int c;

        Node(){}

        Node(int beedScore, int idx, int r, int c){
            this.beedScore = beedScore;
            this.idx = idx;
            this.r = r;
            this.c = c;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        // Map 크기
        int N = Integer.parseInt(st.nextToken());

        // 마법 사용 횟수
        int M = Integer.parseInt(st.nextToken());


        HashMap<Integer, Node> hash = new HashMap();    // idx의 (r,c) 좌표 값 저장을 위한 Hash 사용
        Node[][] mapArr = new Node[N+1][N+1];           // 좌표의 Idx와 구슬 종류를 표현하기 위한 클래스 배열 생성
        int[][] testMap = new int[N+1][N+1];

        for(int i = 0 ; i <= N ; i++){
            for(int j = 0 ; j <= N ; j++){
                mapArr[i][j] = new Node();
            }
        }

        // 구슬 Value 세팅
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++){
                int inputValue = Integer.parseInt(st.nextToken());
                mapArr[i][j].beedScore = inputValue;
                mapArr[i][j].r = i;
                mapArr[i][j].c = j;
            }
        }

        // 지도 Idx 세팅
        int positionR = (N+1)/2; // 시작 위치는 상어부터
        int positionC = (N+1)/2; // 시작 위치는 상어부터
        int direction = 0;       // 진행방향은 상어 위치에서 왼쪽부터 시작
        int idx = 1;             // 해당 좌표의 맵 IDX값
        int moveCnt = 1;         // 몇칸씩 이동할지

        outloop:while(idx < N * N){
            for(int j = 0 ; j < 2 ; j++){
                for(int i = 0 ; i < moveCnt ; i++){
                    positionR = positionR + dr[direction]; // idx setting을 위한 Row 좌표
                    positionC = positionC + dc[direction]; // idx setting을 위한 Col 좌표

                    // idx의 (r,c) 좌표 저장을 위한 Hash
                    hash.put(idx, new Node(mapArr[positionR][positionC].beedScore, idx, positionR, positionC));

                    // 지도 (r,c)에 맞는 idx 세팅
                    mapArr[positionR][positionC].idx = idx;
                    idx++;

                    //arrayList.add(new Node(mapArr[positionR][posi]))
                    if(idx == N*N) break outloop;
                }
                direction = (direction+1)%4;
            }
            moveCnt++;
        }
        // 지도 Idx 세팅 종료

        ///// 블리자드 마법 시작 ////
        for(int i = 0 ; i < M ; i++){
            // 블리자드 마법으로 구슬이 깨진 Node 좌표 저장용
            ArrayList<Node> crushNodeList = new ArrayList();

            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken()); // 방향
            int s = Integer.parseInt(st.nextToken()); // 거리

            int crushNodeR = (N+1)/2;
            int crushNodeC = (N+1)/2;

            // 거리만큼 시전
            for(int j = 0 ; j < s ; j++){
                crushNodeR = crushNodeR + blizardR[d];
                crushNodeC = crushNodeC + blizardC[d];

                Node node = new Node();
                node.r = crushNodeR;
                node.c = crushNodeC;
                node.idx = mapArr[node.r][node.c].idx;

                // 깨진 Node 저장
                crushNodeList.add(node);
            }


            if(i == 1) System.out.println("");

            //// 블리자드로 깨진 구슬 공간 당기기 ////
            for(int j = crushNodeList.size()-1 ; j >= 0 ; j--){
                int r = crushNodeList.get(j).r;
                int c = crushNodeList.get(j).c;

                // 해당 좌표의 IDX
                int startIdx = mapArr[r][c].idx;

                // 시작 IDX부터 뒤에 당기기
                for(int k = startIdx ; k < N * N ; k++){
                    // 배열 당기기
                    //Node node = (Node)arrayList.get(k);
                    Node node = hash.get(k);
                    Node nextNode = hash.get(k+1);

                    if(nextNode == null || nextNode.beedScore == 0){
                        //mapArr[node.r][node.c].beedScore = 0;
                        break;
                    }

                    // 다음 공간의 구슬 점수로 당기기 (지도)
                    mapArr[node.r][node.c].beedScore = nextNode.beedScore;


                    // 다음 공간의 구슬 점수로 당기기 (hash)
                    node.beedScore = nextNode.beedScore;
                    nextNode.beedScore = 0;
                    mapArr[nextNode.r][nextNode.c].beedScore = 0;
                    hash.put(k, node);
                    hash.put(k+1, nextNode);
                }
            }

            //// 구슬 폭발 ////
            // 4개이상 연속하는 구슬이 있을 때 발생
            while(true){
                crushNodeList.clear();

                // 구슬 폭발 시작
                for(int j = 1 ; j < ( N * N ) - 1 ; j++){
                    int score = hash.get(j).beedScore;
                    if(score == 0) break;
                    int nodeIdx = j+1;
                    int countIdx = 0;

                    while(nodeIdx < N * N){
                        // 해당 노드의 Idx 정보가 Null이 아니고
                        // Idx beedScore와 비교하는 beedScore가 같은 경우(4개이상 쌓이면 폭발)
                        if(hash.get(nodeIdx) != null && hash.get(nodeIdx).beedScore == score){
                            countIdx++; // 4개이상 쌓이는지 확인하기 위한 변수
                            nodeIdx++;  // 다음 nodeIdx의 beedScore를 찾기 위해 +1
                        }
                        else{
                            break;
                        }
                    }

                    // 4개 이상일 경우
                    if(countIdx >= 3){
                        //System.out.println("BOOOM");

                        for(int k = j ; k <= j + countIdx ; k++){
                            crushNodeList.add(new Node(0, k, hash.get(k).r, hash.get(k).c));
                        }

                        j = j + countIdx;
                    }
                }
                //// 구슬 폭발 종료 ////

                //// 당기기 시작 ////
                for(int j = crushNodeList.size()-1 ; j >= 0 ; j--){
                    int r = crushNodeList.get(j).r;
                    int c = crushNodeList.get(j).c;

                    // 해당 좌표의 IDX
                    int startIdx = mapArr[r][c].idx;

                    // 시작 IDX부터 뒤에 당기기
                    for(int k = startIdx ; k< N * N ; k++){
                        // 배열 당기기
                        //Node node = (Node)arrayList.get(k);
                        Node node = hash.get(k);
                        Node nextNode = hash.get(k+1);

                        if(nextNode == null || nextNode.beedScore == 0){
                            //mapArr[node.r][node.c].beedScore = 0;
                            break;
                        }

                        // 다음 공간의 구슬 점수로 당기기 (지도)
                        mapArr[node.r][node.c].beedScore = nextNode.beedScore;
                        mapArr[nextNode.r][nextNode.c].beedScore = 0;

                        // 다음 공간의 구슬 점수로 당기기 (hash)
                        node.beedScore = nextNode.beedScore;
                        nextNode.beedScore = 0;
                        hash.put(k, node);
                        hash.put(k+1, nextNode);
                    }
                }
                //// 당기기 종료 ////

                // 부서진 공간이 없으면 탈출
                if(crushNodeList.size() < 1){
                    break;
                }
            }
            //// 구슬 폭발 종료 ////

            //// 구슬 변화 시작 ////
            int copyIdx = 1;

            HashMap<Integer, Node> copyHash = new HashMap();
            Node[][] copyMapArr = new Node[N+1][N+1];

            for(int j = 0 ; j <= N ; j++){
                for(int k = 0 ; k <= N ; k++){
                    copyMapArr[j][k] = new Node();
                }
            }

            for(int j = 1 ; j < (N * N)-1 ; j++){
                int score = hash.get(j).beedScore;
                if(score == 0) break;

                int nodeIdx = j+1;
                int countIdx = 1;

                while(nodeIdx < N * N) {
                    // 해당 노드의 Idx정보가 Null이 아니고
                    // Idx beedScore와 비교하는 beedScore가 같은 경우
                    if (hash.get(nodeIdx) != null && hash.get(nodeIdx).beedScore == score) {
                        countIdx++; // 4개 이상 쌓였는지 확인하기 위한 변수
                        nodeIdx++;  // 다음 NodeIdx의 beedScore를 찾기 위해 +1
                    } else {
                        break;
                    }
                }

                Node node = new Node();
                Node originNode = hash.get(copyIdx);
                if(originNode == null) break;
                node.r = originNode.r;
                node.c = originNode.c;
                node.idx = originNode.idx;
                node.beedScore = countIdx;
                copyHash.put(copyIdx, node);
                //copyMapArr[node.r][node.c].beedScore = countIdx;
                copyMapArr[node.r][node.c] = node;
                copyIdx++;



                node = new Node();
                originNode = hash.get(copyIdx);
                node.r = originNode.r;
                node.c = originNode.c;
                node.idx = originNode.idx;
                node.beedScore = score;
                copyHash.put(copyIdx, node);
                //copyMapArr[node.r][node.c].beedScore = score;
                copyMapArr[node.r][node.c] = node;
                copyIdx++;

                j = j + countIdx-1;
                if(copyIdx >= N * N) break;
            }

            //// 구슬 변화 종료 ////



            hash = copyHash;
            printMap(copyMapArr);
        }
        // 블리자드 마법 종료
    }

    static void printMap(Node[][] mapArr){
        for(int i = 1 ; i < mapArr.length ; i++){
            for(int j = 1 ; j < mapArr[0].length ; j++){
                System.out.print(mapArr[i][j].beedScore + " ");
            }
            System.out.println("");
        }

        System.out.println("--");
    }

    static void printIdx(Node[][] mapArr){
        for(int i = 1 ; i <= 7 ; i++){
            for(int j = 1; j <= 7 ; j++){
                System.out.print(mapArr[i][j].idx + " ");
            }
            System.out.println("");
        }
    }
}
