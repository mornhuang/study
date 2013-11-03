package com.huang.j2ee.ch00.service;

import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.junit.Test;

/**
 * Date : 2013-11-02 20:00
 */
public class TestSayHiService {
    @Test
    public void testA1() throws Exception {
        Client client = new Client(new URL("http://localhost:8080/services/SayHiService?wsdl"));
        Object[] results11 = client.invoke("sayHi", new Object[]{"Jadyer22"});
        System.out.println(results11[0]);
    }

    @Test
    public void testA2() throws Exception {
        String serviceURL = "http://localhost:8080/services/SayHiService";
        Service serviceModel = new ObjectServiceFactory().create(SayHiService.class,
                null, "http://service.ch00.j2ee.huang.com", null);

        XFireProxyFactory serviceFactory = new XFireProxyFactory();

        try {
            SayHiService service = (SayHiService) serviceFactory.create(serviceModel, serviceURL);
            Client client = Client.getInstance(service);
            //client.addOutHandler(new OutHeaderHandler());

            // disable timeout
            client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, "1");

            String hello = service.sayHi("张山疯");
            System.out.println("服务器对[张山疯] 的回答是：" + hello);

            hello = service.sayHi(null);
            System.out.println("服务器胡言乱语说：" + hello);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testA3() throws Exception {
        Service srvcModel = new ObjectServiceFactory().create(SayHiService.class);
        XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
        String helloWorldURL = "http://localhost:8080/services/SayHiService";

        try {
            SayHiService srvc = (SayHiService) factory.create(srvcModel, helloWorldURL);
            String rtnStr = srvc.sayHi("dennis");
            System.out.println(rtnStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}



