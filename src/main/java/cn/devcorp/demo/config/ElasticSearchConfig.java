package cn.devcorp.demo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticSearchConfig {

   private String host;
   private Integer port;

   public String getHost() {
       return host;
  }

   public void setHost(String host) {
       this.host = host;
  }

   public Integer getPort() {
       return port;
  }

   public void setPort(Integer port) {
       this.port = port;
  }

   @Bean
   public RestHighLevelClient restHighLevelClient(){
       RestHighLevelClient restHighLevelClient =
               new RestHighLevelClient(RestClient.builder(new HttpHost(host,port,"http")));
       return restHighLevelClient;
  }
}