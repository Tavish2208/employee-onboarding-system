package com.example.notification.endpoint;

import com.example.common.dto.NotificationDto;
import com.example.notification.entity.Notification;
import com.example.notification.service.NotificationAppService;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class NotificationEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/notification/ws";
    private final NotificationAppService notificationAppService;

    public NotificationEndpoint(NotificationAppService notificationAppService) {
        this.notificationAppService = notificationAppService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SendNotificationRequest")
    @ResponsePayload
    public SendNotificationResponse send(@RequestPayload SendNotificationRequest request) {
        Notification n = notificationAppService.send(request.getNotification());
        SendNotificationResponse response = new SendNotificationResponse();
        response.setNotification(n);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ByEmployeeRequest")
    @ResponsePayload
    public ByEmployeeResponse byEmployee(@RequestPayload ByEmployeeRequest request) {
        List<Notification> notifications = notificationAppService.listByEmployee(request.getEmpId());
        ByEmployeeResponse response = new ByEmployeeResponse();
        response.setNotifications(notifications);
        return response;
    }

    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class SendNotificationRequest {
        @XmlElement(required=true)
        private NotificationDto notification;
        public NotificationDto getNotification() { return notification; }
        public void setNotification(NotificationDto notification) { this.notification = notification; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class SendNotificationResponse {
        @XmlElement
        private Notification notification;
        public Notification getNotification() { return notification; }
        public void setNotification(Notification notification) { this.notification = notification; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class ByEmployeeRequest {
        @XmlElement
        private Long empId;
        public Long getEmpId() { return empId; }
        public void setEmpId(Long empId) { this.empId = empId; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class ByEmployeeResponse {
        @XmlElement(name="notification")
        private List<Notification> notifications;
        public List<Notification> getNotifications() { return notifications; }
        public void setNotifications(List<Notification> notifications) { this.notifications = notifications; }
    }
}
