package studyAlgorithm.D220206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
최대 60만 글자까지 입력
 편집기에 커서가 있는데 커서는 문장의 맨 앞(첫 번째 문자의 왼쪽), 문장의 맨 뒤(마지막 문자의 오른쪽), 또는 문장 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치할 수 있다.
 즉 길이가 L인 문자열이 편집기에 입력되어 있으면, 커서가 위치할 수 있는 곳은 L+1가지 경우가 있다.

 L : 커서를 왼쪽으로 한 칸 옮김(커서가 문장의 맨 앞이면 무시됨)
 D : 커서를 오른쪽으로 한 칸 옮김(커서가 문장의 맨 뒤이면 무시됨)
 B : 커서 왼쪽에 있는 문자를 삭제함(커서가 문장의 맨 앞이면 무시됨)
 삭제로 인해 커서는 한 칸 왼쪽으류ㅗ 이동하는 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
 P $ : $라는 문자를 커서 왼쪽에 추가함

 ":/
 명령어가 수해오디기 전에 커서는 문장의 맨 뒤에 위치하고 있음.


 */
public class b1406에디터 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


    }
}
