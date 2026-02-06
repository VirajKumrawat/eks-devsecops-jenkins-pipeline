package com.codebaithak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testAdminGreeting_shouldFailDueToBug() {
        // ❌ This test exposes the bug
        String result = App.greetUser(new String("admin"));
        assertNotEquals("Welcome, admin!", result);
    }

    @Test
    void testGuestGreeting() {
        String result = App.greetUser("guest");
        assertEquals("Hello, guest", result);
    }

    @Test
    void testContentTypeHtml() {
        assertEquals("text/html", App.contentType("index.html"));
    }

    @Test
    void testContentTypeCss() {
        assertEquals("text/css", App.contentType("style.css"));
    }

    @Test
    void testContentTypeUnknown() {
        assertEquals("application/octet-stream",
                App.contentType("file.bin"));
    }
}