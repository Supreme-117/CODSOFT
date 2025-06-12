import java.util.*;

class test {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        System.out.flush(); // optional, for safe output display
        String name = sc.nextLine();
        System.out.println("Welcome, " + name + "!");

        // sc.close(); // Only if you're sure you're done with System.in
    }
}
