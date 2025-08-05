public class Main {
    public static void main(String[] args) {
        String s1[] = {" "," "," "," "," "," "," "," "," ",",","r","'","\"","7"};
        String s2[] = {"r","`","-","_"," "," "," ",",","\'"," "," ",",","/"};
        String s3[] = {" ","\\","."," ","\"","."," ","L","_","r","'","",""};
        String s4[] = {" "," "," ","`","~","\\","/","","","","","",""};
        String s5[] = {" "," "," "," "," "," ","|","","","","","",""};
        String s6[] = {" "," "," "," "," "," ","|","","","","","",""};
        System.out.println(String.join("", s1));
        System.out.println(String.join("", s2));
        System.out.println(String.join("", s3));
        System.out.println(String.join("", s4));
        System.out.println(String.join("", s5));
        System.out.println(String.join("", s6));

    }
}
