package lk.ijse.dep.main;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:appilcation.properties")
public class JPAConfig {

    @Autowired
    private Environment env;


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter jv){
        var lefmb = new LocalContainerEntityManagerFactoryBean();
        lefmb.setPackagesToScan("lk.ijse.dep.entity");
        lefmb.setDataSource(ds);
        lefmb.setJpaVendorAdapter(jv);
        return lefmb;
    }


    @Bean
    public DataSource dataSource(){
        var bds = new BasicDataSource();
        bds.setDriverClassName(env.getRequiredProperty("hibernate.connection.driver_class"));
        bds.setUrl(env.getRequiredProperty("hibernate.connection.url"));
        bds.setUsername(env.getRequiredProperty("hibernate.connection.username"));
        bds.setPassword(env.getRequiredProperty("hibernate.connection.password"));
        bds.setInitialSize(env.getRequiredProperty("bds.initial_size",Integer.class));
        bds.setMaxTotal(env.getRequiredProperty("bds.max_total",Integer.class));
        bds.setMaxIdle((env.getRequiredProperty("bds.max_idel",Integer.class)));
        return bds;

    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        var jpa = new HibernateJpaVendorAdapter();
        jpa.setDatabase(Database.MYSQL);
        jpa.setGenerateDdl(true);
        jpa.setShowSql(true);
        jpa.setDatabasePlatform(env.getRequiredProperty("hibernate.dialect"));
        return jpa;
    }


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}
