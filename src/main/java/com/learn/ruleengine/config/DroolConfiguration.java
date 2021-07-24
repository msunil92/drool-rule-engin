package com.learn.ruleengine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
/**
 * @author sunil
 * @project drool-rule-engine
 * @created 2021/07/24 12:39 PM
 */

@Configuration
public class DroolConfiguration {


    Resource resource = ResourceFactory.newClassPathResource("rules/CustomerRules.xls", getClass());
    private KieServices kieServices=KieServices.Factory.get();

    @Bean
    public KieSession getKieSession() {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem()
                .write(resource);
        kieServices.newKieBuilder(kieFileSystem)
                .buildAll();

        KieRepository kieRepository = kieServices.getRepository();
        ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
        KieContainer kieContainer = kieServices.newKieContainer(krDefaultReleaseId);

        KieSession ksession = kieContainer.newKieSession();

        return ksession;
    }
}
