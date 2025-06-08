@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public UserDetailsService users() {
    InMemoryUserDetailsManager mgr = new InMemoryUserDetailsManager();
    mgr.createUser(User.withUsername("alice")
      .password(passwordEncoder().encode("pass"))
      .roles("USER").build());
    mgr.createUser(User.withUsername("bob")
      .password(passwordEncoder().encode("admin"))
      .roles("ADMIN").build());
    return mgr;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/api/admin/**").hasRole("ADMIN")
        .requestMatchers("/api/**").authenticated())
      .formLogin(withDefaults())
      .httpBasic(withDefaults());
    return http.build();
  }
}