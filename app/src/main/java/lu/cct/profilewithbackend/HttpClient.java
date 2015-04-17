package lu.cct.profilewithbackend;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ecborera on 4/13/15.
 * <p/>
 * This program connects to a REST API
 * server for:
 * - HTTP GET
 * - HTTP POST
 */
public class HttpClient {
    private String uri;
    private URL url;

    // -------------------------
    // Overloading constructor
    // --------------------------
    public HttpClient(String uri) {
        this.uri = uri;
        try {
            url = new URL(uri); // Creating a URL Object
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    // ----------------------
    // HTTP GET -- Retrieving
    // data from a server
    // -----------------------
    public String getData() {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            // Cleaning up
            reader.close();
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }


    // ------------------------------
    // HTTP POST -- Posting a JSON
    // data to a server
    // -----------------------------
    public void postData(JSONObject obj) {

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(obj.toString());
            wr.flush();
            wr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        HttpClient client = new HttpClient("http://216.120.248.192:6868/api/profiles");
        System.out.println(client.getData());
    }

}
