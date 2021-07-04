package leetcode;

public class Lc1694Reformat {
    public static void main(String[] args) {
        System.out.println(reformatNumber("--17-5 229 35-39475"));
        System.out.println(reformatNumber1("--17-5 229 35-39475"));
    }
    public static String reformatNumber(String number) {
        number = number.replaceAll("\\s|-","");
        int len = number.length();
        int end,n;
        StringBuilder sb = new StringBuilder();

        if(len%3==1){
            end = 2;
            n = len/3-1;
        }else{
            end = len%3;
            n = len/3;
        }
        for(int i=0,j=0;i<n;i++,j+=3){
            sb.append(number, j, j+3).append("-");
        }
        if(len%3==1){
            sb.append(number,len-4,len-2).append("-");
            sb.append(number,len-2,len);
        }else {
            sb.append(number,len-end,len);
        }
        String s = sb.toString();
        if(s.endsWith("-")) s = s.substring(0,s.length()-1);
        return s;




    }

    public static String reformatNumber1(String number) {
        number = number.replaceAll("\\s|-", "");
        int len = number.length();
        StringBuilder sb = new StringBuilder();
        int end = 0;
        while(end+3 < len-1){
            sb.append(number, end, end+3);
            sb.append("-");
            end+=3;
        }
        if(end + 4 == len){
            sb.append(number, end, end+2).append("-");
            sb.append(number, end+2, end+4);
        }else{
            sb.append(number.substring(end));
        }
        return sb.toString();
        
    }


    }
