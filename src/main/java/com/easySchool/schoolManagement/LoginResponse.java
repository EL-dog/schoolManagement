package com.easySchool.schoolManagement;

public class LoginResponse {
    public String token;
   
    public String username;
    

    public LoginResponse(String token, String username) {
        this.token = token;
      
        this.username = username;
        
    }
     public String getToken() { return token; }
    public String getUsername() { return username; }
}



