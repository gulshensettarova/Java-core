package Interview.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReportGeneratorWithExecutorService  {

    private static final int NUM_REPORTS = 10; // Hesabatların sayı

    public static void main(String[] args) {
        // Interview.Thread pool yaradılır
        ExecutorService executorService = Executors.newFixedThreadPool(4); // 4 thread ilə thread pool yaradılır

        // Hesabat tapşırıqlarının siyahısını yaradırıq
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 1; i <= NUM_REPORTS; i++) {
            final int reportId = i;
            tasks.add(() -> generateReport(reportId));
        }

        // Tapşırıqları paralel olaraq icra edirik
        try {
            List<Future<String>> results = executorService.invokeAll(tasks); // Bütün tapşırıqları paralel olaraq icra edir

            // Nəticələri toplayırıq və çap edirik
            for (Future<String> result : results) {
                try {
                    System.out.println(result.get()); // Nəticələri çap edirik
                } catch (InterruptedException | ExecutionException e) {
                    System.err.println("Error generating report: " + e.getMessage());
                }
            }
        } catch (InterruptedException e) {
            System.err.println("Task interrupted: " + e.getMessage());
        } finally {
            // ExecutorService bağlanır
            executorService.shutdown();
        }
    }

    // Hesabat yaradan metod
    private static String generateReport(int reportId) throws InterruptedException {
        // Simulyasiya etmək üçün 2 saniyəlik gecikmə
        Thread.sleep(2000);
        return "Report " + reportId + " generated successfully.";
    }
}
