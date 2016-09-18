import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wopqw on 18.09.16.
 */
public class StepicBasiOperationsJava {

    static String printTextPerRole(String[] roles, String[] textLines){

        Map<String,List<String>> hashMap = new HashMap<>();

        for (String role :
                roles) {
            hashMap.put(role,new ArrayList<>());
        }
        String regexp = ".+?(?=:)";
        int count = 0;
        for (String text:
             textLines) {
            count+=1;
            String name = regexp(text, regexp, true);
            hashMap.get(name).add(String.valueOf(count)+")");
            hashMap.get(name).add(regexp(text, ":(.+)", false));;
        }
        StringBuilder sb = new StringBuilder("");
        for (String role :
                roles) {
            sb.append(role).append(":\n");
            for (int i = 0; i < hashMap.get(role).size(); i++) {
                if(i%2!=0){
                    sb.append(hashMap.get(role).get(i)).append("\n");
                }
                else {
                    sb.append(hashMap.get(role).get(i));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    static String regexp(String word, String regexp,boolean choice){


        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(word);
        if(matcher.find()){
            return choice?matcher.group(0):matcher.group(1);
        }
        return "No matches";
    }


}
