public class q4{

    String encode(String str){

        int count = 1;
        char ch = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==ch){
                count++;
            }else{
                sb.append(ch);
                sb.append(count);
                count = 1;
                ch = str.charAt(i);
            }
        }

        return sb.toString();
    }
}