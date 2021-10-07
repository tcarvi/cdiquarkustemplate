package com.tcarvi.cdi;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.enterprise.context.SessionScoped;

/**
 * CDI SessionScoped
 * Bean será gerado no momento da criação de uma session. Bean manterá sua existência atual apenas durante a sessão.
 * Bean não se manterá em memória, depois da conclusão da sessão.
 * Poder-se-ia modifiar escopo para request scope. Mas o foco aqui é não gastar o processamento e o tempo deste processmanto, durante uma mesma sessão.
 * O bean injetado, configInjectionPattern1Service, entretanto, sempre estará disponível para utilização.
 */
@SessionScoped
@Path("/endpointForConfigInjectionPattern1")
public class ConfigInjectionPattern1Resource {

    // Padrão 1 para injeção de propriedade de configuração
    @ConfigProperty(name = "injected.value")
    String injectedValue;

    @Inject
    ConfigInjectionPattern1Service configInjectionPattern1Service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String configInjectionPattern1ResourceExecution(){

        // Uso de bean recebido em injeção com escopo @AplicationScoped, para maior agilidade no processamento.
        return configInjectionPattern1Service.exec(getInjectedConfigValue());
    }

    public String getInjectedConfigValue() {
        return "Value injected by pattern 1 is = " + injectedValue;
    }

}
