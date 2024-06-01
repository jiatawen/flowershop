package com.flowershop.config;

import javax.annotation.PostConstruct;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AliPayConfig {
    private String appId = "9021000131692704";
    private String appPrivateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQChDmiv0SmMyWLd3yGKYl2zWkG4a9kXxa7i2Ds3g7jIpDZAE6hMgjSDmw3YXDStuMjYVh4wCLgmDNJdIEsufJqB7JhyqFDm8njUJRLunxAyEmo0HXf1/5Jbka1Wfm1rSh+Hk+nV/AHm5xUq1/Pz2p/huNgKYr2KZwJeTbP1xpT8XOIJ3P6ek7wcQ3NDIPGN7+MONHFvaEWVtJU60byG5D7kfqujfu9bfu02ewTm+pVH4qQ3LaqeZzzBpd0yjaoqTSpIvudZ3swO3a68NIleIKQ7FRAbTV6ClJHk6NApLJz48xRvYdyVyTzVBG1GFjmOR5yHJVEWL1nB1HaT3lqQaJjPAgMBAAECggEAXKjWj/itiANBL1c1i9FmCU7vKrRZtTSVlotDHoBZKo5Xa+wjUslCf0kQ4R7DbAM5AkYhng8WK0YLLWrr9jXYCtHdL3IpAYYVADDIQKMhBT3U/mDJ6Kz+PlKEwJOCTkzZ8P2ndeZEDd17LygJgY2RmKLpIKiIVf1HvovD8q4qfznfO9J+CVaM59JDRMSE5O97BrLiw5ww7MVHfTsdruNoXjhl6+zTg/ME+me1LTifjVRJLbNzwkWtXMhLL5eOJfhJRiqbWzmrhC1HRALL3XoAS6hY3ccda6sifHQOGJrW5+bpi13oPBDq0evIWoLKvBGcodleZ3aqhEQFT0wYe34A4QKBgQD1PsAYGboxu+XW99KuZKoApwhsZbrLkMjp7IGqH0DjgtSfjyFWJWqQE+O4jVgn/TefC4or2jfzt43deH9NtjRvYSQVq2AsY5qCPQsn9INEBSt87eSrUJOcUIKCN2TyYWchFZhCsINu9/Iv1SIrDKsZBAX6WKu2IYOCKijfrnN6EQKBgQCoHoLD2kdYpbFPveT3K2OHH4JDolPRJlgacofqobHnvNRBwWtdXOYIS/t0KGJqpOHEhvlkuTd0o4h7TCDUmsfPggbwaYouaCDzk/UmO6TDr8YP35gVOW2AtsV9gDKvxHJ8mzxXKUoTV5WoHB+ry0FaOoWRPzpkxN/SxnxAnFkE3wKBgEwnu0EApDgTcBDsDglHix7+v3fhszrJcApr/evVHrJHiz0tFh4JKmkpM/q4MZrhX+dMjxCFCADvi+ctJuL75JZ9pNXxzMCcAXvV9uPmYui5bkKyIOMt91iAC7bh+r/ljT/R0+FJrNbFufguiBi0K2FuRWjzJgc9qve9ncmwA33xAoGAWJYDJ3pMH+znGnKgRJGLVzcGJ+dQLSP8RqtU7RCYsthwK9nkXgTGfVa0QAfLnBAXmrvYi/eAvigxkW6S2hRY9wG38FRcaImb2116TtQcxLRJNDIIbB6fkbQ9Kh00GCP2g6w0xmTOUJTVGgj/s0FdxVKS8O8VMOYAXosSC+WWjpcCgYAxx708/FG+GOPyNorHVUATzGdc9ZduvKNbSNtuyxXUjU++fwbh1xBlV8Uu6J4sVCAHDE3vzq5bc7JmXoT7jnbwAqt5uR7BBpZ0BFHCQAEudTVPzphUcvOPBOn2oQBjsI+rbT4foQTUgcc5/3EERsHPYgjJQzPzQD+PW33Cw7iu1A==";
    private String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnF/osTB1BJISPTM69nzKL8IX/HFAf/4N7/K+OHKMBeMAmKRR2RnKA/azN6TunirgoGkU5Pv90ytDWniWa7ZIcte6N/WBPZv77yByM/4TSKNlD4qMtOHhVY4ltNWbmxzWadVRbQ6eiB7Hvk0q36Gm846LZmXUYKt1j51IYmjFQKO/H6lAXtMCEG6pKuIdk9pFfDioUVi0pjo3GfjAtnPaV52SNYf2lozxGzQMeCx0lhAEMaOeg5KAcUdb9WRLK4V1G815J5B1jljJ1Izh2QWLZT8yaZ54dlENd7zAMK/t2Mu0S1qsnchnoLepsjVtnKDc+KamzVLJSzBwCtntuOY6WwIDAQAB";
    private String notifyUrl;


    @PostConstruct
    public void init() {
        // 设置参数（全局只需设置一次）
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipaydev.com";
        config.signType = "RSA2";
        config.appId = this.appId;
        config.merchantPrivateKey = this.appPrivateKey;
        config.alipayPublicKey = this.alipayPublicKey;
        config.notifyUrl = this.notifyUrl;
        Factory.setOptions(config);
    }
}
