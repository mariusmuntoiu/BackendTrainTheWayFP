package finalProject.security;

import finalProject.models.User;
import finalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import java.util.ArrayList;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebSecurityConfig wb;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (shouldAuthenticateAgainstThirdPartySystems(name,password)) {


            return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());

        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


    private boolean shouldAuthenticateAgainstThirdPartySystems(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if (user != null) {
            String encPassword=PasswordEncrypter.getEncoded(password);

            if (username.equals(user.getUsername()) && encPassword.equals(user.getPassword())) {
                // Collection<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(user);
                return true;
            } else {
                throw new UsernameNotFoundException("User name" + username + "not found");
            }
        }
        return false;
    }

}
