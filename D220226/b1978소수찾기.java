package studyAlgorithm.D220226;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class b1978소수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < N ; i++){
            if(process(Integer.parseInt(st.nextToken())))
            {
                answer++;
            }
        }

        System.out.print(answer);
    }

    static boolean process(int n){
        if(n < 2){
            return false;
        }

        for(int i = 2 ; i * i <= n ; i++){
            if(n % i ==0){
                return false;
            }
        }

        return true;
    }
}
