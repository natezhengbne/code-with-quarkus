package com.github.natezhengbne;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ServletSecurity(@HttpConstraint(rolesAllowed = { "user" }))
@WebServlet(name = "MySecureServlet", urlPatterns = "/secure-test", initParams = {
        @WebInitParam(name = "message", value = "A secured message") })
public class TestSecureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("==================="+req.getPathInfo());
    }

}