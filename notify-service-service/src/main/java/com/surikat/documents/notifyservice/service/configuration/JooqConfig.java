package com.surikat.documents.notifyservice.service.configuration;

import org.jooq.conf.MappedSchema;
import org.jooq.conf.RenderMapping;
import org.jooq.conf.Settings;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jooq.JooqExceptionTranslator;
import org.springframework.boot.autoconfigure.jooq.JooqProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class JooqConfig {

    @Value("{${app.config.jooq.input-schema:'notify-service'}")
    private String inputSchema;

    @Value("{${app.config.jooq.output-schema:'notify-service'}")
    private String outputSchema;

    private final DataSource dataSource;

    @Autowired
    public JooqConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
    }

    @Bean
    @Primary
    public DefaultDSLContext dslContext() {
        return new DefaultDSLContext(configuration());
    }

    @Bean
    public JooqProperties properties() {
        return new JooqProperties();
    }

    public DefaultConfiguration configuration() {
        DefaultConfiguration config = new DefaultConfiguration();
        config.set(connectionProvider());
        config.set(properties().determineSqlDialect(dataSource));
        config.set(new Settings()
                .withRenderSchema(true)
                .withRenderMapping(new RenderMapping()
                        .withSchemata(new MappedSchema()
                                .withInput(inputSchema)
                                .withOutput(outputSchema))));
        config.set(new DefaultExecuteListenerProvider(new JooqExceptionTranslator()));
        return config;
    }
}
