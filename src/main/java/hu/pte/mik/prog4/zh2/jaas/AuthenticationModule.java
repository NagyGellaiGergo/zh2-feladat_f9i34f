package hu.pte.mik.prog4.zh2.jaas;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.util.Map;

public class AuthenticationModule implements LoginModule {

    @Override
    public void initialize(Subject subject,
                           CallbackHandler callbackHandler,
                           Map<String, ?> sharedState,
                           Map<String, ?> options) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean login() throws LoginException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean commit() throws LoginException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean abort() throws LoginException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean logout() throws LoginException {
        throw new UnsupportedOperationException();
    }

}
