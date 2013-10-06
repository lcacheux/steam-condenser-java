package com.github.koraktor.steamcondenser.steam.community;

import com.github.koraktor.steamcondenser.exceptions.WebApiException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Used to retrieve some data from HTML pages, if not available from XML/Json
 *
 * @author Leo Cacheux
 */
public class HtmlData {
    private String htmlContent;

    /**
     * Execute a request to retrieve an HTML page
     *
     * @param url URL of the page
     * @throws WebApiException
     */
    public HtmlData(String url) throws WebApiException {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            httpClient.getParams().setBooleanParameter(ClientPNames.HANDLE_AUTHENTICATION, false);
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);

            Integer statusCode = response.getStatusLine().getStatusCode();
            if(!statusCode.toString().startsWith("20")) {
                throw new WebApiException(WebApiException.Cause.HTTP_ERROR, statusCode, response.getStatusLine().getReasonPhrase());
            }

            htmlContent = EntityUtils.toString(response.getEntity());
        } catch (WebApiException e) {
            throw e;
        } catch(Exception e) {
            throw new WebApiException("Could not retrieve the page.", e);
        }
    }

    /**
     * Retrieve the icon URL from the web page
     *
     * @return The icon URL
     */
    public String getIconUrl() {
        Pattern regex = Pattern.compile("<div class=\"apphub_AppIcon\"><img src=\"(.*)\"><div class=\"overlay\">", Pattern.MULTILINE);
        Matcher matcher = regex.matcher(htmlContent);
        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }
}
