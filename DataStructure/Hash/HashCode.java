package DataStructure.Hash;

// 문자열에 대한 해시 처리 보기 .hashCode()
public class HashCode {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello2";

        int hashCode1 = str1.hashCode();
        int hashCode2 = str2.hashCode();

        System.out.println("HashCode of \"hello\": " + hashCode1);
        System.out.println("HashCode of \"hello2\": " + hashCode2);
    }
}
