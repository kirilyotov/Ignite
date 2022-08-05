package digital.lights.firstweek.monday.first;

public class Math {
    public static int fibonacci(int n) {

        if (n < 0)
            return fibonacci(n + 1) * (-1) + fibonacci(n + 2);

        if (n == 0 || n == 1)
            return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int factorial(int n) {
        int result = 1;

        if (n < 0) {
            n *= -1;
            result *= -1;
        }


        for (; n > 1; --n)
            result *= n;
        return result;
    }
}
