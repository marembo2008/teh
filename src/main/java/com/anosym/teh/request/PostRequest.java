/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request;

import com.anosym.teh.response.ErrorResponse;
import com.anosym.teh.response.Response;
import com.anosym.utilities.Utility;
import com.anosym.vjax.VXMLBindingException;
import com.anosym.vjax.v3.VObjectMarshaller;
import com.anosym.vjax.xml.VDocument;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marembo
 */
public abstract class PostRequest {

  private final String servletUrl;
  private final String siteUrl = "direct.mastermarts.com";  /*"203.92.33.2";*/

  private final Map<String, String> postParameters;

  protected PostRequest(String servletUrl) {
    this(servletUrl, null);
  }

  protected PostRequest(String servletUrl, String userId) {
    this(servletUrl, userId, null);
  }

  protected PostRequest(String servletUrl, String userId, String token) {
    this(servletUrl, userId, token, null);
  }

  protected PostRequest(String servletUrl, String userId, String token, String accountId) {
    this.servletUrl = servletUrl;
    this.postParameters = new HashMap<String, String>();
    addParameter("uid", userId);
    addParameter("token", token);
    addParameter("acId", accountId);
  }

  /**
   * We only consider the parameter value if it is not null nor empty
   *
   * @param paramName
   * @param paramValue
   */
  public final void addParameter(String paramName, String paramValue) {
    if (!Utility.isNullOrEmpty(paramName) && !Utility.isNullOrEmpty(paramValue)) {
      postParameters.put(paramName, paramValue);
    }
  }

  public String getParameter(String paramName) {
    return postParameters.get(paramName);
  }

  public void addParameter(String paramName, Object paramValue) {
    if (!Utility.isNullOrEmpty(paramName) && paramValue != null && !Utility.isNullOrEmpty(paramValue.toString())) {
      postParameters.put(paramName, paramValue.toString());
    }
  }

  public String getSiteUrl() {
    return siteUrl;
  }

  public String getServletUrl() {
    return servletUrl;
  }

  protected abstract Response getResponse(String response);

  private Response getResponse0(String response) {
    if (response.contains("<omneerror>") || response.contains("<error>")) {
      return processResponse(response, ErrorResponse.class);
    }
    return getResponse(response);
  }

  protected <T> T processResponse(String response, Class<T> reponseClass) {
    try {
      VObjectMarshaller<T> m = new VObjectMarshaller<T>(reponseClass);
      VDocument doc = VDocument.parseDocumentFromString(response);
      return m.unmarshall(doc);
    } catch (VXMLBindingException ex) {
      Logger.getLogger(PostRequest.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public Response doRequest() {
    String response = doRequest0();
    System.out.println("Response: " + response);
    if (!Utility.isNullOrEmpty(response)) {
      return getResponse0(response);
    }
    return null;
  }

  private String getRequestUrl() {
    return "https://" + siteUrl + (servletUrl.startsWith("/") ? servletUrl : ("/" + servletUrl));
  }

  private String getParameters() {
    String params = "";
    for (Entry<String, String> e : postParameters.entrySet()) {
      try {
        if (!params.isEmpty()) {
          params += "&";
        }
        params += (e.getKey() + "=" + URLEncoder.encode(e.getValue(), "UTF-8"));
      } catch (UnsupportedEncodingException ex) {
        Logger.getLogger(PostRequest.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return params;
  }

  private String doRequest0() {
    HttpURLConnection connection = null;
    DataOutputStream wr = null;
    BufferedReader reader = null;
    try {
      String urlParameters = getParameters();
      String url_ = getRequestUrl();
      System.out.println("Request Url: " + url_);
      System.out.println("Request Parameters (POST): " + urlParameters);
      URL url = new URL(url_);
      connection = (HttpURLConnection) url.openConnection();
      connection.setDoOutput(true);
      connection.setDoInput(true);
      connection.setInstanceFollowRedirects(false);
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      connection.setRequestProperty("charset", "utf-8");
      connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
      connection.setUseCaches(false);
      connection.setConnectTimeout(50000);
      connection.setReadTimeout(1200000);
      wr = new DataOutputStream(connection.getOutputStream());
      wr.writeBytes(urlParameters);
      wr.flush();
      String data = "";
      String line;
      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      while ((line = reader.readLine()) != null) {
        data += line;
      }
      return data;
    } catch (IOException ex) {
      Logger.getLogger(PostRequest.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (wr != null) {
        try {
          wr.close();
        } catch (IOException ex) {
          Logger.getLogger(PostRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException ex) {
          Logger.getLogger(PostRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      if (connection != null) {
        connection.disconnect();
      }
    }
    return null;
  }
}
