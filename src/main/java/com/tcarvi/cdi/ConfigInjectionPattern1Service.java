package com.tcarvi.cdi;

import javax.enterprise.context.ApplicationScoped;

// import org.jboss.logging.Logger;

/**
 * CDI ApplicationScoped
 * Bean será gerado apenas 1 vez durante a execução da aplicação.
 * Bean se manterá em memória, para chamadas futuras.
 * Este Bean estará sempre disponível para ser injetado no Resource.
 * Poder-se-ia modificar escopo para session ou request scope. Mas o foco aqui é mantê-lo sempre disponível.
 */
@ApplicationScoped
public class ConfigInjectionPattern1Service {

    // private static final Logger LOG = Logger.getLogger(ConfigInjectionPattern1Service.class);

    public String exec(String config) {
        // try {
        //     // your code
        // } catch () {
        //     LOG.info(ex.getMessage()); // for logs or erros
        //     // your code
        // } finally {
        //     // your codee
        // }
        return "config received: " + config;
    }

}
