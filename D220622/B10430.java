package studyAlgorithm.D220622;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10430 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        sb.append( (A+B) % C).append("\n");
        sb.append(( (A%C) + (B%C) ) % C).append("\n");
        sb.append( (A*B)%C ).append("\n");
        sb.append( ((A%C) * (B%C))%C ).append("\n");

        bw.write(sb+"");
        bw.close();

    }
}
