package studyAlgorithm.D220321;

import studyAlgorithm.D220308.b1753최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 6종류(1원, 5원, 10원, 50원, 100원, 500원)의 동전을 생산하는 공장.
 특정 금액만큼 동전을 생산해달라는 의뢰가 들어왔을 때, 최소 비용으로 그 금액만큼 동선을 생산하고자 한다.

 화폐 단위      생산 단가
 1              1
 5              4
 10             99
 50             35
 100            50
 500            1000

 만약 각 동전의 생산 단가가 위의 표와 같고, 의뢰받은 금액이 4578원이라면 최소의 비용으로
 4578원어치의 동전을 생산하는 방법은 다음과 같다.

 화폐 단위      생산 단가       생산 수량       생산 비용       생산 화폐 가치
 1              1              3          1 * 3 = 3        1 * 3 = 3
 5              4               5         4 * 5 = 20       5 * 5 = 25
 10             99             0          99 * 0 = 0       10 * 0 = 0
 50             35              1         35 * 1 = 35      50 * 1 = 50
 100            50              45        50 * 45 = 2250  100 * 45 = 4500
 500            1000            0         1000 * 0 = 0    500 * 0 = 0

 총 비용                                   3 + 20 + 35 + 2250 = 2308
 총 화폐 가치                                                3 + 25 + 50 + 4500 = 4578

 즉 1원짜리 동전을 3개, 5원짜리 동전을 5개, 50원짜리 동전을 1개, 100원짜리 동전을 45개
 생산하면 2308원이라는 최소 비용으로 4578원어치의 동전을 생산할 수 있다. 2308원보다
 적은 비용으로 4578원어치의 동전을 생산할 수 있는 방법은 없다.
 공장이 생산해야 하는 금액을 나타내는 정수 MONEY, 6종류 동전의 생산 단가를 나타내는 1차원 정수 배열 COsts가 매개변수로 주어진다.
 money원만큼 동전을 최소 비용으로 생산했을 때, 그 최소 비용을 return 하도록 solution 함수 완성하기



 */
public class s01 {

    public static class Money implements Comparable<Money>{

        public double amt;
        public double makeAmt;
        public double weight;

        public Money(double amt, double makeAmt){
            this.amt = amt;
            this.makeAmt = makeAmt;
            this.weight = this.amt / this.makeAmt;
        };

        @Override
        public int compareTo(Money money) {
            //return this.weight - money.weight;
            return Double.compare(money.weight, this.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue<Money> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        /*
        int money = 4578;
        int[] moneyIdx = {1, 5, 10, 50, 100, 500};
        int[] costs = { 1, 4, 99, 35, 50, 1000};
         */

        int money = 1999;
        int[] moneyIdx = {1,5,10,50,100,500};
        int[] costs = {2, 11, 20, 100, 200, 600};
        int[] answer = new int[6];
        for(int i = 0 ; i < costs.length ; i++){
            pq.add(new Money(moneyIdx[i], costs[i]));
        }

        for(int i = 0 ; i < costs.length ; i++){
            //System.out.println(pq.poll().amt);
            int amt = (int)pq.poll().amt;
            int cntOfMoney = money / amt;

            switch(amt){
                case 1:
                    answer[0] = cntOfMoney;
                    break;
                case 5:
                    answer[1] = cntOfMoney;
                    break;
                case 10:
                    answer[2] = cntOfMoney;
                    break;
                case 50:
                    answer[3] = cntOfMoney;
                    break;
                case 100:
                    answer[4] = cntOfMoney;
                    break;
                case 500:
                    answer[5] = cntOfMoney;
                    break;
            }

            money -= cntOfMoney * amt;
        }


        int ans = 0;
        for(int i = 0 ; i < answer.length ; i++){
            ans += answer[i] * costs[i];
        }

        System.out.println(ans);
    }
}
