package com.tcarvi;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * CDI ApplicationScoped
 * Bean será gerado apenas 1 vez durante a execução da aplicação.
 * Bean se manterá em memória, para chamadas futuras.
 */
@ApplicationScoped
@ApplicationPath("/applicationName")
public class CdiQuarkusTemplateAplication extends Application {
    // Scripts adicionais.
}
