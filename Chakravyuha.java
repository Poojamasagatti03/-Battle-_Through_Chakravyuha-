package Myprojects;

public class Chakravyuha {

    public static boolean canAbhimanyuCross(int p, int a, int b, int[] enemyPowers) {
        int currentPower = p;
        int skipsRemaining = a;
        int rechargePower = b;

        for (int i = 0; i < enemyPowers.length; i++) {
            int enemyPower = enemyPowers[i];

            if (skipsRemaining > 0) {
                skipsRemaining--;
                continue;
            }

            if (currentPower < enemyPower) {
                return false;
            }

            // Deduct enemy power from current power
            currentPower -= enemyPower;

            // Special case for k3 and k7 (indices 2 and 6)
            if (i == 2 || i == 6) {
                int regeneratedPower = enemyPower / 2;
                if (currentPower < regeneratedPower) {
                    return false;
                }
                currentPower -= regeneratedPower;
            }

            // Recharge after the battle
            currentPower += rechargePower;
        }

        return true;
    }

    public static void main(String[] args) {
        int p = 50;  // Initial power
        int a = 2;   // Skips
        int b = 10;  // Recharge power
   int[] enemyPowers = {5, 10, 20, 10, 5, 15, 20, 15, 10, 5, 30};

    // Test case 1
    System.out.println(canAbhimanyuCross(p, a, b, enemyPowers));  // Example output: true or false based on power and enemy powers

 // Modify enemy powers or initial conditions for a second test case
int[] enemyPowers2 = {10, 20, 30, 20, 10, 25, 30, 25, 20, 10,35};


    // Test case 2
    System.out.println(canAbhimanyuCross(p, a, b, enemyPowers2));  // Example output: true or false based on power and enemy powers
    }
}