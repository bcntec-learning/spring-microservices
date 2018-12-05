package bcntec.training.springboot.microservices.config.search.apigateway;

import com.netflix.appinfo.AmazonInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
class EurekaConfig {


    @Bean
    public EurekaInstanceConfigBean eurekaInstanceConfigBean() {
        InetUtils instance = new InetUtils(new InetUtilsProperties());
        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(instance);
        try {
            log.info("Ereka Pre Configuring-3");
            AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
            config.setDataCenterInfo(info);
            info.getMetadata().put(AmazonInfo.MetaDataKey.publicHostname.getName(), info.get(AmazonInfo.MetaDataKey.publicIpv4));
            config.setHostname(info.get(AmazonInfo.MetaDataKey.localHostname));

            log.info("hostname" + info.get(AmazonInfo.MetaDataKey.localHostname));
            log.info("IP" + info.get(AmazonInfo.MetaDataKey.publicIpv4));

            //    config.setIpAddress(info.get(AmazonInfo.MetaDataKey.publicIpv4));

            config.setNonSecurePortEnabled(true);
            config.setNonSecurePort(0); //change this later
            //    config.setPreferIpAddress(true);

            // config.setIpAddress("54.85.107.37");
            config.getMetadataMap().put("instanceId", info.get(AmazonInfo.MetaDataKey.localHostname));

            // log.info("info" + info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }
}
