import java.net.http.*;
import java.net.URI;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {

    // ✅ Fetch exchange rate using the new /convert API
    public static double getExchangeRate(String base, String target) {
        double result = 0.0;
        try {
            String url = "https://api.exchangerate.host/convert?from=" + base + "&to=" + target;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject obj = new JSONObject(response.body());
            result = obj.getDouble("result");

        } catch (Exception e) {
            System.out.println("Error fetching exchange rate: " + e.getMessage());
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Currency Converter ===");
        System.out.print("Enter base currency (e.g., USD): ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter target currency (e.g., INR): ");
        String target = sc.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = sc.nextDouble();

        double rate = getExchangeRate(base, target);

        if (rate > 0) {
            double converted = amount * rate;
            System.out.printf("Converted Amount: %.2f %s\n", converted, target);
        } else {
            System.out.println("Failed to convert. Try again.");
        }

        sc.close();
    }
}