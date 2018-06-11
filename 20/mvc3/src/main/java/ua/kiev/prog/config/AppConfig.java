package ua.kiev.prog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("ua.kiev.prog")
@EnableTransactionManagement
@EnableWebMvc //вкл МВС фреймворк
public class AppConfig extends WebMvcConfigurerAdapter { //
    //конфигурацию наследуем от базового класса. в методах заложено поведение по умолчанию.
    //есть статические ресурсы.
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
    //последний бин, строится поверх всего, у него ссылка на фабрику
    //интерфейс, управляет транзакциями за нас. jpa... - реализация интерфейса


    @Bean
    //это фабрика. бин, который реализовывает фабрику, к которой Спринг будет обращаться за энтити менеджерами
    // дата сорс и вендор адаптер сюда назначаются, создается на их основе
    //пакеты - сканируются, там поиск энтити
    public LocalContainerEntityManagerFactoryBean entityManagerFactory
            (DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        Properties jpaProp = new Properties();
        jpaProp.put("hibernate.hbm2ddl.auto", "create-drop");

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactory.setJpaProperties(jpaProp);
        entityManagerFactory.setPackagesToScan("ua.kiev.prog");

        return entityManagerFactory;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        //adapter.setGenerateDdl(true); //создавать таблицы на основе Энтити класса
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
//JPA - следующий уровень над JDBC - его реализовывает Hibernate
        return adapter;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useUnicode=true");
        ds.setUsername("root");
        ds.setPassword("root");
//создать базу, ДатаСорс - интерфейс, дальше реализация
        return ds;
    }

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/dynamic/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setOrder(1);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/static/**") //если отправлен запрос сюда, то нужно
                // этот ресурс взять в этом каталоге. для этого мы наследуем конфиг класс от базового
                .addResourceLocations("/static/");
    }
}
