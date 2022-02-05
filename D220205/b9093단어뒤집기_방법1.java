package studyAlgorithm.D220205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


/**
 문제
 문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오. 단, 단어의 순서는 바꿀 수 없다. 단어는 영어 알파벳으로만 이루어져 있다.

 입력
 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있으며, 문장이 하나 주어진다. 단어의 길이는 최대 20, 문장의 길이는 최대 1000이다.
 단어와 단어 사이에는 공백이 하나 있다.

 출력
 각 테스트 케이스에 대해서, 입력으로 주어진 문장의 단어를 모두 뒤집어 출력한다.

 예제 입력
 2
 I am happy today
 We want to win the first prize
 */
public class b9093단어뒤집기_방법1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Stack stack = new Stack();

        // 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            // 한 줄 입력 받아서 공백 단위로 자르기
            st = new StringTokenizer(br.readLine(), " ");

            while(st.hasMoreTokens()){
                // 입력 받은 한 줄에서 단어 하나 뽑기
                String splitWord = st.nextToken();

                // 단어에서 알파벳 수 만큼 반복문
                for(int j = 0 ; j < splitWord.length() ; j++){
                    stack.push(splitWord.charAt(j));
                }

                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }

                sb.append(" ");
            }
            System.out.println(sb);
            sb = new StringBuilder();
        }
    }
}
