package com.github.natezhengbne;

import io.quarkus.security.credential.PasswordCredential;
import io.quarkus.security.identity.AuthenticationRequestContext;
import io.quarkus.security.identity.IdentityProvider;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.identity.request.UsernamePasswordAuthenticationRequest;
import io.quarkus.security.runtime.QuarkusPrincipal;
import io.quarkus.security.runtime.QuarkusSecurityIdentity;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.Set;

@ApplicationScoped
public class FormIdentityProvider implements IdentityProvider<UsernamePasswordAuthenticationRequest> {

    @Override
    public Class<UsernamePasswordAuthenticationRequest> getRequestType() {
        System.out.println("  Class<UsernamePasswordAuthenticationRequest> getRequestType()  ");
        return UsernamePasswordAuthenticationRequest.class;
    }

    @Override
    public Uni<SecurityIdentity> authenticate(UsernamePasswordAuthenticationRequest req, AuthenticationRequestContext context) {
        System.out.println("  Uni<SecurityIdentity> authenticate  ");
        System.out.println("  Uni<SecurityIdentity> authenticate  "+req.getUsername());
        if(!req.getUsername().equalsIgnoreCase("admin")){
            return Uni.createFrom().item(null);
        }
        QuarkusSecurityIdentity identity = QuarkusSecurityIdentity.builder()
                .setPrincipal(new QuarkusPrincipal("nateusername"))
                .addRoles(Collections.singleton("user"))
                .addCredential(new PasswordCredential("1".toCharArray()))
                .build();
        return Uni.createFrom().item(identity);
    }

}
