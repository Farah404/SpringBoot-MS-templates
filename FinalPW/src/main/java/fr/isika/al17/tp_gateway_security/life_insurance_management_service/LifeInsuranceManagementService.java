package fr.isika.al17.tp_gateway_security.life_insurance_management_service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.isika.al17.tp_gateway_security.dao.LifeInsuranceManagementRepository;
import fr.isika.al17.tp_gateway_security.dao.RoleRepository;
import fr.isika.al17.tp_gateway_security.model.LifeInsuranceManagement;
import fr.isika.al17.tp_gateway_security.model.Role;

@Service
public class LifeInsuranceManagementService implements UserDetailsService{

    @Autowired
    LifeInsuranceManagementRepository lifeInsuranceManagementRepository;
    
    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

	LifeInsuranceManagement lifeInsuranceManagement = lifeInsuranceManagementRepository.findByEmail(email);
        if(lifeInsuranceManagement != null) {
            List<GrantedAuthority> authorisations = getLifeInsuranceManagementAuthorisation(lifeInsuranceManagement.getRoles());
            return authoriseLifeInsuranceManagement(lifeInsuranceManagement, authorisations);
        } else {
            throw new UsernameNotFoundException("N/A");
        }
    }
    
    private List<GrantedAuthority> getLifeInsuranceManagementAuthorisation(Set<Role> lifeInsuranceManagementRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        lifeInsuranceManagementRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }
        
    
    private UserDetails authoriseLifeInsuranceManagement(LifeInsuranceManagement lifeInsuranceManagement, List<GrantedAuthority> authorisations) {
        return new org.springframework.security.core.userdetails.User(lifeInsuranceManagement.getEmail(), lifeInsuranceManagement.getPassword(), authorisations);
    }
    
    
    public void saveLifeInsuranceManagement(LifeInsuranceManagement lifeInsuranceManagement) {
	lifeInsuranceManagement.setPassword(bCryptPasswordEncoder.encode(lifeInsuranceManagement.getPassword()));
	lifeInsuranceManagement.setActive(true);
        Role lifeInsuranceManagementRole = roleRepository.findByRole("ADMIN");
        lifeInsuranceManagement.setRoles(new HashSet<>(Arrays.asList(lifeInsuranceManagementRole)));
        lifeInsuranceManagementRepository.save(lifeInsuranceManagement);t
    }
}
