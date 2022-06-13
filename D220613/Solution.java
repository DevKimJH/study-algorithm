package studyAlgorithm.D220613;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 카카오프렌즈 컬러링북
class Solution {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node{
        int r;
        int c;

        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        // 몇개의 영역이 있는지
        int numberOfArea = 0;

        // 가장 큰 영역의 칸 수
        int maxSizeOfOneArea = 0;

        int r = picture.length;
        int c = picture[0].length;
        int countArea = 0;
        boolean[][] visitArr = new boolean[r][c];

        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(visitArr[i][j] == false && picture[i][j] > 0){
                    countArea = process(i, j, picture, visitArr);
                    numberOfArea++;
                    if(maxSizeOfOneArea < countArea){
                        maxSizeOfOneArea = countArea;
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static int process(int r, int c, int[][] picture, boolean[][] visitArr){
        int countArea = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(r,c));
        visitArr[r][c] = true;
        int idxOfPicture = picture[r][c];

        while(!queue.isEmpty()){
            Node node = queue.poll();
            visitArr[node.r][node.c] = true;
            countArea++;

            for(int i = 0 ; i < 4 ; i++){
                int nextR = node.r + dr[i];
                int nextC = node.c + dc[i];

                if(0<= nextR && nextR < visitArr.length && 0 <= nextC && nextC < visitArr[0].length){
                    if(visitArr[nextR][nextC] == false && picture[nextR][nextC] == idxOfPicture){
                        queue.add(new Node(nextR, nextC));
                        visitArr[nextR][nextC] = true;
                    }
                }
            }
        }

        return countArea;
    }
}