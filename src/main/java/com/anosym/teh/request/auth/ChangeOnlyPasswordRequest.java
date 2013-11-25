/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth;

/**
 *
 * @author marembo
 */
public class ChangeOnlyPasswordRequest extends EnableAndChangePasswordRequest {

  public ChangeOnlyPasswordRequest(String userId, String securityKey, String panNumber, String token) {
    super("/XMLServlets/servlet/ChangeOnlyPassword", userId, securityKey, panNumber, token);
  }
}
