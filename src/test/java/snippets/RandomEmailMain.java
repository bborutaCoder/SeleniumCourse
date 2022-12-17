package snippets;

import java.util.Random;

public class RandomEmailMain {

    public static void main(String[] args) {

        System.out.println(generateEmail());
    }

    public static String generateEmail() {
        Random random = new Random();

        String[] names = {"user", "jdoe", "jasFasola", "superman"};
        String name = names[random.nextInt(names.length)];

        String[] domains = {"mail.com", "gmail.com", "o2.pl", "wp.pl"};
        String domain = domains[random.nextInt(domains.length)];

        int randomNumber = random.nextInt(1000000);
        return name + "_" + randomNumber + "@" + domain;
    }
}
