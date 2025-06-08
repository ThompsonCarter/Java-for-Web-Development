@Autowired DataSource dataSource;

@Bean
public UserDetailsService jdbcUsers() {
  JdbcUserDetailsManager mgr = new JdbcUserDetailsManager(dataSource);
  mgr.setUsersByUsernameQuery("SELECT username,password,enabled FROM users WHERE username=?");
  mgr.setAuthoritiesByUsernameQuery("SELECT username,authority FROM authorities WHERE username=?");
  return mgr;
}