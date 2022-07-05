package studyAlgorithm.M2207.D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * (1,1) (4,4)
 * 물고기 M마리
 * 이동방향 8방향
 * 둘 이상의 물고기가 같은 칸에 있을 수 있음.
 * <p>
 * 1. 모든 물고기가 한 칸 이동
 * - 상어가 있는 칸, 물고기의 냄새가 있는 칸, 격자의 범위를 벗어난 칸으로는 이동할 수 없다.
 * - 각 물고기는 자신이 이동할 수 있는 방향을 향할 때까지 45도 반시계 방향으로 회전
 * - 이동할 수 있는 칸이 없으면 이동 X
 * -
 * 2. 상어가 연속해서 3칸 이동
 * - 현재 칸에서 상하좌우 인접한 칸으로 이동 가능
 * - 연속해서 이동하는 중에 물고기가 있는 같은 칸으로 이동하게 된다면, 그 칸에 있는 물고기는 격자에서 제외
 * - 물고기 냄새를 남긴다
 * <p>
 * 1부터 순서대로
 * ←, ↖, ↑, ↗, →, ↘, ↓, ↙
 * <p>
 * <p>
 * 5 1
 * 4 3 5
 * 1 3 5
 * 2 4 2
 * 2 1 6
 * 3 4 4
 * 4 2
 * <p>
 * 4 1
 * 3 1
 * 1 3 5
 * 2 2 7
 * 3 4 6
 * 4 2 2
 * 3 1
 */
public class B23290 {
    static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    static int[] sr = {-1, 0, 1, 0};
    static int[] sc = {0, -1, 0, 1};

    static class Fish {
        int r;
        int c;
        int d;
        int y;

        Fish(int r, int c) {
            this.r = r;
            this.c = c;
        }

        Fish(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    static int[] moveNumber = new int[3];
    static int maxEat = Integer.MIN_VALUE;

    static int test;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 물고기의 수
        int M = Integer.parseInt(st.nextToken());

        // 마법 연습
        int S = Integer.parseInt(st.nextToken());

        // 격자, 물고기, 상어 생성
        int[][] mapArr = new int[5][5];
        boolean[][] visitArr;
        ArrayList<Fish> fishes = new ArrayList<>();

        // 물고기 시체 관리
        ArrayList<Fish> deadFishList = new ArrayList<>();

        // 물고기 클론 관리
        ArrayList<Fish> cloneFishList = new ArrayList<>();

        Fish shark;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fishes.add(new Fish(r, c, d));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        shark = new Fish(r, c);


        for (int i = 1; i <= S; i++) {

            if (i == 4) {
                test = 4;
                System.out.println(i + "회차");
            }
            maxEat = Integer.MIN_VALUE;
            visitArr = new boolean[5][5];
            cloneFish(cloneFishList, fishes);       // 1번
            moveFish(fishes, deadFishList, shark);  // 2번
            findPath(fishes, deadFishList, shark, visitArr); // 3-1. 상어 이동 방법 찾기
            //System.out.print(moveNumber[0]);
            //System.out.print(moveNumber[1]);
            //System.out.print(moveNumber[2]);
            moveShark(fishes, deadFishList, shark); // 3-2. 상어 이동
            removeSmell(deadFishList);              // 4번
            makeFish(cloneFishList, fishes);        // 5번
        }

        //printFish(fishes);
        System.out.println(fishes.size());
    }

    // 물고기 복제
    static void cloneFish(ArrayList<Fish> cloneFishList, ArrayList<Fish> fishes) {
        int sizeOfFish = fishes.size();

        for (int i = 0; i < sizeOfFish; i++) {
            int r = fishes.get(i).r;
            int c = fishes.get(i).c;
            int d = fishes.get(i).d;

            cloneFishList.add(new Fish(r, c, d));
        }
    }

    static void moveFish(ArrayList<Fish> fishes, ArrayList<Fish> deadFishList, Fish shark) {
        int countOfFish = fishes.size();
        int countOfDeadFish = deadFishList.size();
        for (int i = 0; i < countOfFish; i++) {
            Fish fish = fishes.get(i);

            // 이동 가능할 때까지 8방향 회전
            for (int j = 0; j < 8; j++) {
                int nextR = fish.r + dr[fish.d];
                int nextC = fish.c + dc[fish.d];
                boolean isCanMove = true;
                // 격자를 벗어나지 않고
                if (1 <= nextR && nextR <= 4 && 1 <= nextC && nextC <= 4) {
                    // 이동하려는 공간에 시체가 있으면
                    for (int k = 0; k < countOfDeadFish; k++) {
                        if (deadFishList.get(k).r == nextR && deadFishList.get(k).c == nextC) {
                            isCanMove = false;
                        }
                    }

                    // 이동하려는 공간에 상어가 있으면
                    if (shark.r == nextR && shark.c == nextC) {
                        isCanMove = false;
                    }

                    // 물고기 이동
                    if (isCanMove) {
                        fish.r = nextR;
                        fish.c = nextC;
                        break;
                    }
                }

                fish.d = fish.d - 1;
                if (fish.d == 0) fish.d = 8;
            }
        }
    }

    static void printFish(ArrayList<Fish> fishes) {
        for (int i = 0; i < fishes.size(); i++) {
            //System.out.println(fishes.get(i).r + " " + fishes.get(i).c + " " + fishes.get(i).d);
        }
    }

    static void findPath(ArrayList<Fish> fishes, ArrayList<Fish> deadFishList, Fish shark, boolean[][] visitArr) {

        int countOfFish = fishes.size();
        int canEatFish = 0;
        // **
        visitArr[shark.r][shark.c] = true;


        for (int i = 0; i < 4; i++) {
            int firstR = shark.r + sr[i];
            int firstC = shark.c + sc[i];
            int firstEat = 0;

            if (1 <= firstR && firstR <= 4 && 1 <= firstC && firstC <= 4) {
                /* 상어 이동 1 */
                visitArr[firstR][firstC] = true;
                for (int j = 0; j < countOfFish; j++) {
                    if (firstR == fishes.get(j).r && firstC == fishes.get(j).c) {
                        firstEat++;
                    }
                }

                for (int j = 0; j < 4; j++) {
                    int secondR = firstR + sr[j];
                    int secondC = firstC + sc[j];
                    int secondEat = 0;

                    if (1 <= secondR && secondR <= 4 && 1 <= secondC && secondC <= 4 && visitArr[secondR][secondC] == false) {
                        /* 상어 이동 2*/
                        visitArr[secondR][secondC] = true;

                        for (int k = 0; k < countOfFish; k++) {
                            if (secondR == fishes.get(k).r && secondC == fishes.get(k).c) {
                                secondEat++;
                            }
                        }

                        for (int k = 0; k < 4; k++) {
                            int thirdR = secondR + sr[k];
                            int thirdC = secondC + sc[k];
                            int thirdEat = 0;

                            if (1 <= thirdR && thirdR <= 4 && 1 <= thirdC && thirdC <= 4 && visitArr[thirdR][thirdC] == false) {
                                /* 상어 이동 3 */
                                visitArr[thirdR][thirdC] = true;

                                for (int l = 0; l < countOfFish; l++) {
                                    // *** ㅡㅡ
                                    if (thirdR == fishes.get(l).r && thirdC == fishes.get(l).c) {
                                        thirdEat++;
                                    }

                                    if (firstEat + secondEat + thirdEat > maxEat) {
                                        maxEat = firstEat + secondEat + thirdEat;
                                        moveNumber[0] = i;
                                        moveNumber[1] = j;
                                        moveNumber[2] = k;
                                    }
                                }
                                visitArr[thirdR][thirdC] = false;
                            }
                        }
                        visitArr[secondR][secondC] = false;
                    }
                }
                visitArr[firstR][firstC] = false;
            }
        }
    }

    static void moveShark(ArrayList<Fish> fishes, ArrayList<Fish> deadFishList, Fish shark) {
        int sharkR = shark.r;
        int sharkC = shark.c;
        int sizeOfFish = fishes.size();

        for (int i = 0; i < 3; i++) {
            sharkR = sharkR + sr[moveNumber[i]];
            sharkC = sharkC + sc[moveNumber[i]];

            Iterator<Fish> fishIterator = fishes.iterator();
            while (fishIterator.hasNext()) {
                Fish fish = fishIterator.next();
                if (fish.r == sharkR && fish.c == sharkC) {
                    //System.out.println("catch");
                    fishIterator.remove();
                    fish.y = 4;
                    deadFishList.add(fish);
                }
            }
        }

        shark.r = sharkR;
        shark.c = sharkC;
    }

    static void removeSmell(ArrayList<Fish> deadFishList) {
        int sizeofDeadFish = deadFishList.size();
        for (int i = 0; i < sizeofDeadFish; i++) {
            Fish deadFish = deadFishList.get(i);
            deadFish.y = deadFish.y - 1;
            deadFishList.set(i, deadFish);
        }

        /* 2년 지난 Smell 삭제 */
        Iterator<Fish> deadFishIter = deadFishList.iterator();
        while (deadFishIter.hasNext()) {
            Fish deadFish = deadFishIter.next();
            if (deadFish.y == 1) {
                deadFishIter.remove();
            }
        }


    }

    static void makeFish(ArrayList<Fish> cloneFishList, ArrayList<Fish> fishes) {
        int sizeOfCloneFishList = cloneFishList.size();

        for (int i = 0; i < sizeOfCloneFishList; i++) {
            fishes.add(cloneFishList.get(i));
        }

        cloneFishList.clear();
    }
}
