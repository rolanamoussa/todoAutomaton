package utils;

public class RandomEmailGenerator {

    public static void main(String[] args) {
        long timestamp = System.currentTimeMillis();
        String randomEmail = "user" + timestamp + "@demo.com";
        System.out.println(randomEmail);
    }

    public static String generateRandomEmail(){
        long timestamp = System.currentTimeMillis();
        String randomEmail = "user" + timestamp + "@demo.com";
        return randomEmail;
    }
}

//user1771014280845@demo.com
//user1771014296380@demo.com