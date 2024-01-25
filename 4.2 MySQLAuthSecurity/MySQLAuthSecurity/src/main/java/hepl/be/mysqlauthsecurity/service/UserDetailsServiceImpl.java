package hepl.be.mysqlauthsecurity.service;

import hepl.be.mysqlauthsecurity.config.MyUserDetails;
import hepl.be.mysqlauthsecurity.model.User;
import hepl.be.mysqlauthsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        try {
            User user = userRepository.getUserByUsername(username);

            if (user == null) {
                System.out.println("User not found: " + username);
                throw new UsernameNotFoundException("User not found");
            }

            // Vos logs de détails sur l'utilisateur
            System.out.println("Loaded user: " + user.getUsername());

            // Vérifier si la phase de pré-authentification se termine correctement
            // ...

            return new MyUserDetails(user);
        } catch (Exception e) {
            System.out.println("Exception during user loading: " + e.getMessage());
            throw e;
        }
    }
}
