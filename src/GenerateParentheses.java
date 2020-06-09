import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backTrack(ans,"", 0, 0, n);

        return ans;
    }

    static void backTrack(List<String> ans, String curr, int open, int close, int max){

        if(curr.length() == max *2){
            ans.add(curr);
            return;
        }

        if(open<max)
            backTrack(ans, curr+"(", open+1, close, max);

        if(close<open)
            backTrack(ans, curr+")", open, close+1, max);

    }

    public static void main(String args[]) {

        System.out.println(generateParenthesis(4));
    }
}
