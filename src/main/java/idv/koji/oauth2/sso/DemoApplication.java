package idv.koji.oauth2.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class DemoApplication {

  @RequestMapping("/hello")
  public String hello(OAuth2Authentication authentication) {
    return "hello:" + authentication.getName();
  }

  @RequestMapping("/details")
  public Object details(OAuth2Authentication authentication) {
    return authentication.getUserAuthentication();
  }

  
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}
