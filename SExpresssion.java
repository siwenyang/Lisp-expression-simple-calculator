import java.util.*;

public class SExpresssion{

    public static int expressFuc(String s){
        Stack<Integer> num = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();
        int res = 0;
        int i = 0;
        for(;i < s.length();){
            int t = 0;
            while(s.charAt(i) == ' '){
                ++i;
                ++t;
            }
            if(t > 1){
                res = -1;//duplicate blank
                break;
            }
			
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                if(s.charAt(i) == ')'){
                    char op = ops.peek();
                    ops.pop();
                    if(op == '+'){
                        int addRes=0;
                        while(!num.isEmpty() && num.peek() != -1){
                            addRes += num.pop();
                        }
                        num.pop();
                        num.push(addRes);
                    }
                    else if(op == '*'){
                        int mulRes = 1;
                        while(!num.isEmpty() && num.peek() != -1){
                            mulRes *= num.pop();
                        }
                        num.pop();
                        num.push(mulRes);
                    }
                    else {
                        res = -2;//unknown operation
                        break;
                    }
                    ops.pop();
                    if(ops.isEmpty()) {
                        res = num.peek();
                        break;
                    }
					
                } else {
                    if(s.charAt(i) == '('){
                        ops.push('(');
                        num.push(-1);
                    }
                    else if (s.charAt(i) == 'a'){
                        if(s.substring(i, i + 3).equals("add")){
                            ops.push('+');
                            i = i + 2;
                        } else {
                            res = -3;//operation spelling wrong
                            break;
                        }
                    }
                    else if (s.charAt(i) == 'm'){
                        if(s.substring(i, i + 8).equals("multiply")){
                            ops.push('*');
                            i= i + 7;
                        } else {
                            res = -3;//operation spelling wrong
                            break;
                        }
                    } 
                }
                i++;
                
            } else {
                t = i;
                while(i <= s.length() - 1 && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    i++;
                }
                num.push(Integer.parseInt(s.substring(t, i)));
                res = num.peek();
            }
        }
        return res;
    }

     public static void main(String []args){
		int result = 0;
		if (args.length != 1) {
			result = -4;//wrong arguments
		} else {
			String input = args[0]; 
			result = expressFuc(input);
		}
		
        System.out.println(result);
     }
}