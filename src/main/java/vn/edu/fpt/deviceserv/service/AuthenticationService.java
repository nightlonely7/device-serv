package vn.edu.fpt.deviceserv.service;

public interface AuthenticationService {
    boolean authenticate(String token, String functionSignature);
    String signIn(String basicAuth);
}
