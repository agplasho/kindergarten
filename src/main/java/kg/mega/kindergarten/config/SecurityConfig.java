//package kg.mega.kindergarten.config;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin().permitAll();
//    }
//}