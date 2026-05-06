package com.codedx.plugins.bamboo;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * Servlet-based replacement for the XWork/WebWork ServerConfigAction.
 *
 * The original ServerConfigAction extended GlobalAdminAction (a Bamboo XWork action),
 * which transitively pulled in com.opensymphony.module.propertyset via the OSGi
 * uses: constraint chain. Bamboo's DmzResolverHook marks that package as internal,
 * causing the plugin bundle to fail to resolve.
 *
 * By using a plain HttpServlet instead, we avoid the entire OpenSymphony dependency
 * chain and the plugin loads correctly.
 */
public class ServerConfigServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(ServerConfigServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        log.info("doGet() called - serving admin config page");

        String url = ServerConfigManager.getUrl();
        String apiKey = ServerConfigManager.getApiKey();
        String fingerprint = ServerConfigManager.getFingerprint();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("  <meta charset=\"UTF-8\">");
        out.println("  <title>Code Dx Plugin Configuration</title>");
        out.println("  <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\" "
                + "integrity=\"sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/\" "
                + "crossorigin=\"anonymous\"/>");
        out.println("  <style>");
        out.println("    body { font-family: Arial, sans-serif; margin: 20px; }");
        out.println("    h1 { font-size: 1.5em; margin-bottom: 20px; }");
        out.println("    .field-group { margin-bottom: 15px; }");
        out.println("    label { display: block; font-weight: bold; margin-bottom: 4px; }");
        out.println("    input[type=text], input[type=password] { width: 400px; padding: 5px; font-size: 1em; }");
        out.println("    .setting-section { display: flex; padding: 5px 0; align-items: flex-start; }");
        out.println("    .setting-help-textfield { opacity: 0.75; color: #205081; font-size: 1.25rem; cursor: pointer; padding: 5px; }");
        out.println("    .setting-content { display: none; border: 1px solid #CCC; border-radius: 3px; padding: 5px; background: #EEE; width: 90%; max-width: 740px; margin-top: 4px; }");
        out.println("    .buttons { margin-top: 20px; }");
        out.println("    input[type=submit] { padding: 6px 16px; font-size: 1em; cursor: pointer; }");
        out.println("    .success-msg { color: green; margin-top: 10px; display: none; }");
        out.println("    .error-msg { color: red; margin-top: 10px; display: none; }");
        out.println("  </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("  <h1>Code Dx Plugin Configuration</h1>");
        out.println("  <form id=\"codedx-config-form\" method=\"POST\" action=\"\">");

        // CSRF token (Bamboo uses atl_token)
        String atlToken = req.getParameter("atl_token");
        if (atlToken == null) atlToken = "";
        out.println("    <input type=\"hidden\" name=\"atl_token\" value=\"" + escapeHtml(atlToken) + "\"/>");

        // URL field
        out.println("    <div class=\"field-group\">");
        out.println("      <label for=\"url\">Default Code Dx API URL <span style=\"color:red\">*</span></label>");
        out.println("      <div class=\"setting-section\">");
        out.println("        <input type=\"text\" id=\"url\" name=\"url\" value=\"" + escapeHtml(url) + "\" required/>");
        out.println("        <span id=\"help-button-codedx-url\" class=\"setting-help-textfield\" onclick=\"toggleHelp(this)\">");
        out.println("          <i class=\"fas fa-question-circle\"></i>");
        out.println("        </span>");
        out.println("      </div>");
        out.println("      <div id=\"help-content-codedx-url\" class=\"setting-content\">");
        out.println("        <span>The format is as follows: https://&lt;host&gt;:&lt;port&gt;/&lt;webapp_path&gt;/</span><br/>");
        out.println("        <span>Can be overridden on Task Configuration page.</span>");
        out.println("      </div>");
        out.println("    </div>");

        // API Key field
        out.println("    <div class=\"field-group\">");
        out.println("      <label for=\"apiKey\">Default Code Dx API key <span style=\"color:red\">*</span></label>");
        out.println("      <div class=\"setting-section\">");
        out.println("        <input type=\"text\" id=\"apiKey\" name=\"apiKey\" value=\"" + escapeHtml(apiKey) + "\" required/>");
        out.println("        <span id=\"help-button-api-key\" class=\"setting-help-textfield\" onclick=\"toggleHelp(this)\">");
        out.println("          <i class=\"fas fa-question-circle\"></i>");
        out.println("        </span>");
        out.println("      </div>");
        out.println("      <div id=\"help-content-api-key\" class=\"setting-content\">");
        out.println("        <span>Verify that the API key you provide has the appropriate project permissions on the Code Dx admin page.</span><br/>");
        out.println("        <span>Can be overridden on Task Configuration page.</span>");
        out.println("      </div>");
        out.println("    </div>");

        // Fingerprint field
        out.println("    <div class=\"field-group\">");
        out.println("      <label for=\"fingerprint\">Default Self-Signed Certificate Fingerprint</label>");
        out.println("      <div class=\"setting-section\">");
        out.println("        <input type=\"text\" id=\"fingerprint\" name=\"fingerprint\" value=\"" + escapeHtml(fingerprint) + "\"/>");
        out.println("        <span id=\"help-button-self-signed\" class=\"setting-help-textfield\" onclick=\"toggleHelp(this)\">");
        out.println("          <i class=\"fas fa-question-circle\"></i>");
        out.println("        </span>");
        out.println("      </div>");
        out.println("      <div id=\"help-content-self-signed\" class=\"setting-content\">");
        out.println("        <span>If you're using a self-signed certificate, provide its SHA1 Fingerprint here.</span><br/>");
        out.println("        <span>Can be overridden on Task Configuration page.</span>");
        out.println("      </div>");
        out.println("    </div>");

        out.println("    <div class=\"buttons\">");
        out.println("      <input type=\"submit\" value=\"Update\"/>");
        out.println("    </div>");
        out.println("    <div class=\"success-msg\" id=\"success-msg\">Configuration saved successfully.</div>");
        out.println("    <div class=\"error-msg\" id=\"error-msg\"></div>");
        out.println("  </form>");

        out.println("  <script>");
        // String startsWith polyfill for IE
        out.println("    if (!String.prototype.startsWith) {");
        out.println("      Object.defineProperty(String.prototype, 'startsWith', {");
        out.println("        value: function(search, pos) {");
        out.println("          return this.substring(!pos || pos < 0 ? 0 : +pos, pos + search.length) === search;");
        out.println("        }");
        out.println("      });");
        out.println("    }");
        out.println("    function toggleHelp(event) {");
        out.println("      var buttonId = event.id;");
        out.println("      var prefix = 'help-button-';");
        out.println("      if (buttonId.startsWith(prefix)) {");
        out.println("        var suffix = buttonId.substring(prefix.length, buttonId.length);");
        out.println("        var content = document.getElementById('help-content-' + suffix);");
        out.println("        if (content) {");
        out.println("          var visible = content.style.display == 'block';");
        out.println("          content.style.display = visible ? 'none' : 'block';");
        out.println("        }");
        out.println("      }");
        out.println("    }");
        out.println("  </script>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        log.info("doPost() called - saving admin config");

        String url = req.getParameter("url");
        String apiKey = req.getParameter("apiKey");
        String fingerprint = req.getParameter("fingerprint");

        if (url != null) ServerConfigManager.setUrl(url.trim());
        if (apiKey != null) ServerConfigManager.setApiKey(apiKey.trim());
        if (fingerprint != null) ServerConfigManager.setFingerprint(fingerprint.trim());

        log.info("Configuration saved successfully");

        // Redirect back to GET to show the saved values (PRG pattern)
        resp.sendRedirect(req.getRequestURI());
    }

    private static String escapeHtml(String value) {
        if (value == null) return "";
        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#x27;");
    }
}
