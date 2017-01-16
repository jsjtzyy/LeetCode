import java.util.*;

public class LC488_ZumaGame{
	public int findMinStep(String board, String hand) {
        char[] hands = hand.toCharArray();
        char[] boards = board.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : hands){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }
        int res = 6, tmp = 0;
        if(map.containsKey(boards[0]) && map.get(boards[0]) > 1){
            map.put(boards[0], map.get(boards[0]) - 2);
            tmp = 2 + helper(board.substring(1), map);
            if(tmp > 1 && tmp < res) res = tmp;
            map.put(boards[0], map.get(boards[0]) + 2);
        }
        for(int i = 1; i < boards.length; ++i){
            if(boards[i] == boards[i - 1] && map.containsKey(boards[i]) && map.get(boards[i]) > 0){
                map.put(boards[i], map.get(boards[i]) - 1);
                tmp = 1 + helper(board.substring(0, i - 1) + board.substring(i + 1), map);
                if(tmp > 0 && tmp < res) res = tmp;
                map.put(boards[i], map.get(boards[i]) + 1);
            }else{
                if(map.containsKey(boards[i]) && map.get(boards[i]) > 1){
                    map.put(boards[i], map.get(boards[i]) - 2);
                    tmp = 2 + helper(board.substring(0, i) + board.substring(i + 1), map);
                    if(tmp > 1 && tmp < res) res = tmp;
                    map.put(boards[i], map.get(boards[i]) + 2);
                }
            }
        }
        if(res == 6) return -1;
        return res;
    }

    public int helper(String board, HashMap<Character, Integer>map){
        if(board == null || board.length() == 0) return 0;
        int res = 6, tmp = 0;
        board = simplify(board);   // remove any three same color in a row.
        if(board == null || board.length() == 0) return 0;
        char[] boards = board.toCharArray();
        if(map.containsKey(boards[0]) && map.get(boards[0]) > 1){
            map.put(boards[0], map.get(boards[0]) - 2);
            tmp = 2 + helper(board.substring(1), map);
            if(tmp > 1 && tmp < res) res = tmp;
            map.put(boards[0], map.get(boards[0]) + 2);
        }
        for(int i = 1; i < boards.length; ++i){   // backtracking
            if(boards[i] == boards[i - 1] && map.containsKey(boards[i]) && map.get(boards[i]) > 0){
                map.put(boards[i], map.get(boards[i]) - 1);
                tmp = 1 + helper(board.substring(0, i - 1) + board.substring(i + 1), map);
                if(tmp > 0 && tmp < res) res = tmp;
                map.put(boards[i], map.get(boards[i]) + 1);
            }else{
                if(map.containsKey(boards[i]) && map.get(boards[i]) > 1){
                    map.put(boards[i], map.get(boards[i]) - 2);
                    tmp = 2 + helper(board.substring(0, i) + board.substring(i + 1), map);
                    if(tmp > 1 && tmp < res) res = tmp;
                    map.put(boards[i], map.get(boards[i]) + 2);
                }
            }
        }
        if(res == 6) return -1;
        return res;
    }

    public String simplify(String str){
        if(str == null || str.length() < 3) return str;
        char[] arr = str.toCharArray();
        int start = -1, end = -1;
        for(int i = 2; i < arr.length; ++i){
            if(arr[i] == arr[i - 1] && arr[i - 2] == arr[i]){
                start = i - 2;
                end = i;
                while(end < arr.length && arr[end] == arr[start]) ++end;
                break;
            }
        }
        if(start >= 0) return simplify(str.substring(0, start) + str.substring(end));
        return str;
    }
}