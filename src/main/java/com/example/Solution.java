package com.example;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
char[] c1= s1.toCharArray();
   int count =0;
HashMap map1=charCount(s1);
  
HashMap map2=charCount(s2);


for(char c='A';c<='Z';c++){
    if(map1.containsKey(c) && map2.containsKey(c) ){
         int x=(Integer) map1.get(c);   int y=(Integer) map2.get(c);

         if(x==y){count+=x;}
         else if(x>y) { count+=y;}
         else {count+=x;}
    }
}
System.out.println(count);
return count;
    }

static HashMap charCount(String s){
char[] c1= s.toCharArray();
HashMap map= new HashMap();

for(char c:c1){
if(map.containsKey(c)){
    int x=(Integer) map.get(c);
    map.put(c,++x);
}
else{
map.put(c,1);
}
}
return map;
}


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
