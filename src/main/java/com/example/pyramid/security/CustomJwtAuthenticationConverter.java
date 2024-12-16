package com.example.pyramid.security;

import com.example.pyramid.entity.UserDetails;
import com.example.pyramid.repo.UserDetailsRepo;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class CustomJwtAuthenticationConverter {

    private final UserDetailsRepo userDetailsRepo;
    private final JwtGrantedAuthoritiesConverter defaultGrantedAuthoritiesConverter;

    public CustomJwtAuthenticationConverter(UserDetailsRepo userDetailsRepo) {
        this.userDetailsRepo = userDetailsRepo;
        this.defaultGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
    }

    public Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
        String userId = jwt.getClaim("email");
        String userName = jwt.getClaim("name");
        boolean isVerified = jwt.getClaim("email_verified");

        List<GrantedAuthority> authoritiesFromDb = null;

        Optional<UserDetails> userDetailsOptional =  userDetailsRepo.findById(userId);
        if(userDetailsOptional.isPresent()){
            UserDetails userDetails = userDetailsOptional.get();
            authoritiesFromDb = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + userDetails.getRoleDetails().getRoleName()));
        }else if(isVerified){
            UserDetails userDetails = new UserDetails();
            userDetails.setUserId(userId);
            userDetails.setUserName(userName);
            userDetails.setRole(0);
            userDetailsRepo.save(userDetails);
            authoritiesFromDb = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + "PUBLIC"));
        }
        Collection<GrantedAuthority> defaultAuthorities = defaultGrantedAuthoritiesConverter.convert(jwt);
        // Combine authorities
        assert authoritiesFromDb != null;
        List<GrantedAuthority> combinedAuthorities = new ArrayList<>(authoritiesFromDb);
        combinedAuthorities.addAll(defaultAuthorities);
        return combinedAuthorities;
    }

    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = extractAuthorities(jwt);
        return new JwtAuthenticationToken(jwt, authorities);
    }
}
