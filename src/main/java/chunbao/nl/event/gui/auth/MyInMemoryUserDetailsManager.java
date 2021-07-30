package chunbao.nl.event.gui.auth;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

// this is important!!!
// https://stackoverflow.com/questions/25869260/how-can-i-add-users-to-the-inmemoryauthentication-builder-after-it-has-been-buil
// https://spring.io/guides/gs/securing-web/
@Component
public class MyInMemoryUserDetailsManager extends InMemoryUserDetailsManager {}
