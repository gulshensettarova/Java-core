package Thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WebPageTitleFetcher {

    // URL-lərin siyahısını təyin edirik
    private static final List<String> URLS = List.of(
            "https://www.example.com",
            "https://www.google.com",
            "https://www.wikipedia.org",
            "https://www.github.com"
    );

    public static void main(String[] args) {
        // Thread pool yaradılır
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Future obyektlərinin siyahısını yaradırıq
        List<Future<String>> futures = new ArrayList<>();

        // URL-ləri paralel olaraq işləmək üçün tapşırıqlar yaradılır
        for (String url : URLS) {
            Callable<String> task = () -> fetchTitle(url);
            Future<String> future = executorService.submit(task);
            futures.add(future);
        }

        // Nəticələri toplayırıq və çap edirik
        for (int i = 0; i < URLS.size(); i++) {
            try {
                String title = futures.get(i).get(); // Tapşırıq tamamlandıqdan sonra nəticəni əldə edirik
                System.out.println("Title of " + URLS.get(i) + ": " + title);
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error fetching title for URL: " + URLS.get(i));
                e.printStackTrace();
            }
        }

        // ExecutorService bağlanır
        executorService.shutdown();
    }

    // Web səhifəsinin başlığını əldə edən metod
    private static String fetchTitle(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // HTML məzmunundan başlığı çıxarırıq
            return extractTitle(content.toString());
        }
    }

    // HTML məzmunundan başlıq çıxaran metod
    private static String extractTitle(String htmlContent) {
        String titleTagStart = "<title>";
        String titleTagEnd = "</title>";
        int startIndex = htmlContent.indexOf(titleTagStart);
        int endIndex = htmlContent.indexOf(titleTagEnd);
        if (startIndex != -1 && endIndex != -1) {
            startIndex += titleTagStart.length();
            return htmlContent.substring(startIndex, endIndex).trim();
        }
        return "No title found";
    }
}
