package pl.sda.springmvc.services.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.springmvc.entities.RoleEntity;
import pl.sda.springmvc.entities.UserEntity;
import pl.sda.springmvc.repositories.UserCrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {

    private final UserCrudRepository userCrudRepository;

    public UserServiceDetailsImpl(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityOptional = userCrudRepository.findByLogin(login);
        UserEntity userEntity = userEntityOptional.orElseThrow(() ->
                new UsernameNotFoundException("Not found user with login: " + login));
        return new User(userEntity.getLogin(), userEntity.getPassword(), getGrantedAuthorities(userEntity));
    }

    private List<GrantedAuthority> getGrantedAuthorities(UserEntity user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }
        return authorities;
    }
}
