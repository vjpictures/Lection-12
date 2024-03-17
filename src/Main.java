
import java.util.Scanner;
import java.util.concurrent.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> a * a);
        System.out.println(future1.get());
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> b * b);
        System.out.println(future2.get());
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> c * c);
        System.out.println(future3.get());
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);

        allFutures.thenRun(() -> {     // All futures completed
            Integer result1 = future1.join();
            Integer result2 = future2.join();
            Integer result3 = future3.join();
            System.out.println(result1 + result2 + result3);
        });
    }
}
