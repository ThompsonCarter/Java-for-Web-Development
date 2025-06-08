<dependency>
  <groupId>org.springframework.security</groupId>
  <artifactId>spring-security-oauth2-authorization-server</artifactId>
  <version>1.0.0</version>
</dependency>

http.oauth2ResourceServer(oauth2 -> oauth2
  .jwt(jwt -> jwt.jwtDecoder(jwtDecoder())));