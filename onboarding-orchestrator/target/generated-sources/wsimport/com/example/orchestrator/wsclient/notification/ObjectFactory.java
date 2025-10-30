
package com.example.orchestrator.wsclient.notification;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.orchestrator.wsclient.notification package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.orchestrator.wsclient.notification
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendNotificationRequest }
     * 
     */
    public SendNotificationRequest createSendNotificationRequest() {
        return new SendNotificationRequest();
    }

    /**
     * Create an instance of {@link NotificationDto }
     * 
     */
    public NotificationDto createNotificationDto() {
        return new NotificationDto();
    }

    /**
     * Create an instance of {@link SendNotificationResponse }
     * 
     */
    public SendNotificationResponse createSendNotificationResponse() {
        return new SendNotificationResponse();
    }

    /**
     * Create an instance of {@link NotificationEntity }
     * 
     */
    public NotificationEntity createNotificationEntity() {
        return new NotificationEntity();
    }

    /**
     * Create an instance of {@link ByEmployeeRequest }
     * 
     */
    public ByEmployeeRequest createByEmployeeRequest() {
        return new ByEmployeeRequest();
    }

    /**
     * Create an instance of {@link ByEmployeeResponse }
     * 
     */
    public ByEmployeeResponse createByEmployeeResponse() {
        return new ByEmployeeResponse();
    }

}
