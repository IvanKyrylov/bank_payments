package com.cursach.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Configuration
@PropertySource(value = "classpath:email.properties")
public class SenderMailConfig {

    @Autowired
    private Environment environment;

    private Properties properties() {
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", environment.getRequiredProperty("mail.smtp.auth"));
        properties.put("mail.smtp.starttls.enable", environment.getRequiredProperty("mail.smtp.starttls.enable"));
        properties.put("mail.smtp.host", environment.getRequiredProperty("mail.smtp.host"));
        properties.put("mail.smtp.port", environment.getRequiredProperty("mail.smtp.port"));
        properties.put("mail.smtp.ssl.trust", environment.getRequiredProperty("mail.smtp.ssl.trust"));

        return properties;
    }

    @Bean
    public Session session() {
        return Session.getInstance(properties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(environment.getRequiredProperty("mail.username"), environment.getRequiredProperty("mail.password"));
            }
        });

    }
}
