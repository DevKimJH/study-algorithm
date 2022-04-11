package studyAlgorithm.D220409;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 템플릿 문자열이란, 문자열 안에 존재하는 변수를 사용해 문자열을 작성하고
 실제 사용할 때 변수에 값을 대입해 사용하는 문자열

 this is {template}
 {template} is {state}

 {} 로 감싼 단어들은 모두 변수.

 모든 변수에 값을 대입한 뒤 새로운 변수가 있다면, 변수가 없어질 때까지 대입해야 한다.

 "this is {template} {template} is {state}"

 */
public class O3 {
    public static void main(String[] args) throws Exception {
        //String tString = "this is {template} {template} is {state}";
        //String[][] variables = {{"template", "string"}, {"state", "changed"}};

        //String tString = "this is {template} {template} is {state}";
        //String[][] variables = {{"template", "string"}, {"state", "{template}"}};

        //String tString = "this is {template} {template} is {state}";
        //String[][] variables = {{"template", "{state}"}, {"state", "{template}"}};

        //String tString = "this is {template} {template} is {state}";
        //String[][] variables = {{"template", "{state}"}, {"state", "{templates}"}};

        String tString = "{a} {b} {c} {d} {i}";
        String[][] variables = {{"b", "{c}"}, {"a", "{b}"}, {"e", "{f}"}, {"h", "i"}, {"d", "{e}"}, {"f", "{d}"}, {"c", "d"}};

        HashMap<String, String> hashMap = new HashMap<String, String>();

        // 해쉬 세팅
        for(int i = 0 ; i < variables.length ; i++){
            hashMap.put(variables[i][0], variables[i][1]);
        }

        for(int i = 0 ; i < variables.length ; i++){
            // 템플릿
            String templateString = variables[i][0];

            templateString = "\\{" + templateString + "\\}";

            // 변경해야할 값
            String valueString = variables[i][1];
            String findTemplate = null;

            if(valueString.charAt(0) == '{'){
                findTemplate = valueString.substring(0, valueString.length()-1);
                findTemplate = findTemplate.substring(1, valueString.length()-1);
            }


            if (hashMap.get(findTemplate) == null) {
                tString = tString.replaceAll(templateString, valueString);
            }
            else{
                valueString = hashMap.get(findTemplate);
                tString = tString.replaceAll(templateString, valueString);
            }
        }

        System.out.println(tString);
    }
}




