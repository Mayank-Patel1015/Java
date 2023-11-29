import java.util.Random;

public class Puzzling {
  public static Random randMachine = new Random();

  public static void main(String[] args) {
    int[] randomNums = getTenRolls();
    printNums(randomNums);

    char randomLetter = getRandomLetter();
    System.out.println(randomLetter);

    char[][] passwords = getNewPasswordSet(4);
    printArrayArray(passwords);
  }

  public static void printArrayArray(char[][] something) {
    for (int i = 0; i < something.length; i++) {
      System.out.println(something[i]);
    }
  }

  public static void printNums(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }

  public static int[] getTenRolls() {
    int[] something = new int[10];
    for (int i = 0; i < 10; i++) {
      int random = randMachine.nextInt(1, 21);
      something[i] = random;
    }
    return something;
  }

  public static char getRandomLetter() {
    char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
        't', 'u', 'v', 'w', 'x', 'y', 'z' };
    int randInt = randMachine.nextInt(0, 26);
    return alphabet[randInt];
  }

  public static char[] generatePassword() {
    char[] password = new char[8];
    for (int i = 0; i < 8; i++) {
      password[i] = getRandomLetter();
    }
    return password;
  }

  public static char[][] getNewPasswordSet(int num) {
    char[][] passwords = new char[num][8];
    for (int i = 0; i < num; i++) {
      passwords[i] = generatePassword();
    }
    return passwords;
  }
}
