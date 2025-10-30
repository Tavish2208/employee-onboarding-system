package com.example.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import java.io.Serializable;

@XmlRootElement(name = "Notification")
public class NotificationDto implements Serializable {
    private Long id;

    @NotNull
    private Long employeeId;

    @NotBlank
    private String subject;

    @NotBlank
    private String body;

    private String channel = "EMAIL";

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }
}


