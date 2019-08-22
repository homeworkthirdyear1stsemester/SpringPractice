package com.kkh.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.kkh.springdemo") // 해당 package에서 default scope를 전부 객체를 생성 하게 된다
@PropertySource("classpath:sport.properties") // src 에 있는 파일을 읽어 드린 것이다.
public class SportConfig {

    // define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    } // method name is bean id

    // define bean for our swim coac AND inject dependency
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(this.sadFortuneService());
    } // inject the sadFortune obj

    /*
     * 만약 Scope를 prototype으로 변경시에는 ComponentScan에서 객체 생성이 따로 하지 않는다
     * 만약 default일 경우 객체 생성을 하게 된다
     */
}
