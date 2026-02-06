package com.codebaithak;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class App {

    // 🔴 Security hotspot (intentional)
    private static final String API_KEY = "CVWJ_DEMO_SECRET";

    public static void main(String[] args) throws Exception {

        System.out.println("Starting CVWJ DevSecOps Demo...");

        // Username logic
        String username = readUsername();
        greetUser(username);

        // HTTP server
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", App::handleRequest);

        System.out.println("🚀 CVWJ app running on http://localhost:" + port);
        server.start();
    }

    // ❌ Scanner leak (intentional Sonar issue)
    static String readUsername() {
        String username = "guest";
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter username: ");
            if (sc.hasNextLine()) {
                username = sc.nextLine();
            }
        } catch (Exception e) {
            // ignore
        }
        return username;
    }

    // ❌ Wrong string comparison (intentional bug)
    static String greetUser(String username) {
        if (username == "admin") { // Sonar + bug
            return "Welcome, admin!";
        }
        return "Hello, " + username;
    }

    // ---------- HTTP PART ----------

    private static void handleRequest(HttpExchange exchange) {
        try {
            String path = exchange.getRequestURI().getPath();
            if (path.equals("/")) path = "/index.html";

            InputStream resource =
                    App.class.getResourceAsStream("/static" + path);

            if (resource == null) {
                exchange.sendResponseHeaders(404, -1);
                return;
            }

            byte[] bytes = resource.readAllBytes();
            exchange.getResponseHeaders()
                    .add("Content-Type", contentType(path));
            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String contentType(String path) {
        if (path.endsWith(".html")) return "text/html";
        if (path.endsWith(".css")) return "text/css";
        if (path.endsWith(".js")) return "application/javascript";
        if (path.endsWith(".png")) return "image/png";
        return "application/octet-stream";
    }
}