public class q13 {
    static String decodedString(String s){
        // code here
        Stack<String> st = new Stack<>();
        
        for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i) == ']')
            {
                String current = "";
                
                while(!st.isEmpty() && !st.peek().equals("["))
                current = st.pop()+current;
                
                if(!st.isEmpty())
                st.pop();
                
                int multiply = 0;
                String multiplyFactor = "";
                if(!st.isEmpty())
                {
                    while(!st.isEmpty() && isNumeric(st.peek()))
                    {
                        multiplyFactor = st.pop() + multiplyFactor;
                    }
                }
                multiply = Integer.parseInt(multiplyFactor);
                
                String rep = "";
                while(multiply-- > 0)
                rep += current;
                
                st.push(rep); 
            }
            else
            st.push(""+s.charAt(i));
        }
        
        return st.peek();
    }
    static boolean isNumeric(String str)
    {
        return str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5") || str.equals("6") || str.equals("7") || str.equals("8") || str.equals("9") || str.equals("0");
    }
}
