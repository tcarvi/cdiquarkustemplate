package com.tcarvi.cdi;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.enterprise.context.RequestScoped;

/**
 * CDI RequestScoped
 * Bean será gerado no momento da requisição e existirá apenas durante o processamento da requisição.
 * Bean não se manterá em memória, para chamadas futuras.
 * Poder-se-ia modifiar escopo para session ou request scope. Mas o foco aqui é não gastar memória e tornar a execução dinâmica.
 * O bean injetado, configInclusionPattern2Service, entretanto, sempre estará disponível para utilização.
 */
@RequestScoped
@Path("/endpointForConfigInjectionPattern2")
public class ConfigInclusionPattern2Resource {

    @Inject
    ConfigInclusionPattern2Service configInclusionPattern2Service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String configInjectionPattern2ResourceExecution() {

        // Padrão 2 para inclusão de propriedade de configuração. (sem injeção de dependência)
        Config config = ConfigProvider.getConfig();
        String includedValue = config.getValue("included.value", String.class);

        // Uso de injeção com escopo @AplicationScoped, para maior agilidade no processamento.
        return configInclusionPattern2Service.exec("Value included by pattern 2 is = " + includedValue);
        
    }
}
