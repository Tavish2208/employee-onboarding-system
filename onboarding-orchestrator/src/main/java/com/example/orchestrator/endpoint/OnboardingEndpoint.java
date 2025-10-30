package com.example.orchestrator.endpoint;

import com.example.common.dto.EmployeeDto;
import com.example.common.dto.DocumentDto;
import com.example.common.dto.TrainingDto;
import com.example.common.dto.NotificationDto;
import com.example.orchestrator.wsclient.employee.*;
import com.example.orchestrator.wsclient.document.*;
import com.example.orchestrator.wsclient.training.*;
import com.example.orchestrator.wsclient.notification.*;
import jakarta.xml.bind.JAXBElement;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class OnboardingEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/onboarding/ws";
    private final EmployeePortType employeeClient;
    private final DocumentPortType documentClient;
    private final TrainingPortType trainingClient;
    private final NotificationPortType notificationClient;

    public OnboardingEndpoint(EmployeePortType employeeClient, DocumentPortType documentClient, TrainingPortType trainingClient, NotificationPortType notificationClient) {
        this.employeeClient = employeeClient;
        this.documentClient = documentClient;
        this.trainingClient = trainingClient;
        this.notificationClient = notificationClient;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StartOnboardingRequest")
    @ResponsePayload
    public StartOnboardingResponse startOnboarding(@RequestPayload StartOnboardingRequest request) {
        // Create employee (SOAP call)
        ObjectFactory ef = new ObjectFactory();
        CreateEmployeeRequest empReq = ef.createCreateEmployeeRequest();
        empReq.setEmployee(request.getEmployee());
        CreateEmployeeResponse empResp = employeeClient.createEmployee(empReq);
        Long empId = empResp.getEmployee().getId();

        // Send notification (welcome)
        NotificationDto n = new NotificationDto();
        n.setEmployeeId(empId);
        n.setSubject("Welcome to the company");
        n.setBody("Your onboarding has started.");
        com.example.orchestrator.wsclient.notification.ObjectFactory nf = new com.example.orchestrator.wsclient.notification.ObjectFactory();
        SendNotificationRequest noteReq = nf.createSendNotificationRequest();
        noteReq.setNotification(n);
        notificationClient.sendNotification(noteReq);

        StartOnboardingResponse resp = new StartOnboardingResponse();
        resp.setEmployeeId(empId);
        return resp;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UploadAndVerifyDocumentRequest")
    @ResponsePayload
    public UploadAndVerifyDocumentResponse uploadAndVerifyDocument(@RequestPayload UploadAndVerifyDocumentRequest request) {
        // Upload document
        com.example.orchestrator.wsclient.document.ObjectFactory docf = new com.example.orchestrator.wsclient.document.ObjectFactory();
        UploadDocumentRequest uploadReq = docf.createUploadDocumentRequest();
        uploadReq.setDocument(request.getDocument());
        UploadDocumentResponse uploadResp = documentClient.upload(uploadReq);
        Long docId = uploadResp.getDocument().getId();

        // Verify document
        VerifyDocumentRequest verifyReq = docf.createVerifyDocumentRequest();
        verifyReq.setId(docId);
        documentClient.verify(verifyReq);

        // Send notification
        NotificationDto n = new NotificationDto();
        n.setEmployeeId(request.getDocument().getEmployeeId());
        n.setSubject("Document verified");
        n.setBody("Your document has been verified.");
        com.example.orchestrator.wsclient.notification.ObjectFactory nf = new com.example.orchestrator.wsclient.notification.ObjectFactory();
        SendNotificationRequest noteReq = nf.createSendNotificationRequest();
        noteReq.setNotification(n);
        notificationClient.sendNotification(noteReq);

        UploadAndVerifyDocumentResponse resp = new UploadAndVerifyDocumentResponse();
        resp.setDocId(docId);
        return resp;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AssignTrainingRequest")
    @ResponsePayload
    public AssignTrainingResponse assignTraining(@RequestPayload AssignTrainingRequest request) {
        com.example.orchestrator.wsclient.training.ObjectFactory tf = new com.example.orchestrator.wsclient.training.ObjectFactory();
        AssignTrainingRequest trainReq = tf.createAssignTrainingRequest();
        trainReq.setTraining(request.getTraining());
        AssignTrainingResponse assignResp = trainingClient.assign(trainReq);
        Long empId = request.getTraining().getEmployeeId();

        NotificationDto n = new NotificationDto();
        n.setEmployeeId(empId);
        n.setSubject("Training assigned");
        n.setBody("Please complete your onboarding training.");
        com.example.orchestrator.wsclient.notification.ObjectFactory nf = new com.example.orchestrator.wsclient.notification.ObjectFactory();
        SendNotificationRequest noteReq = nf.createSendNotificationRequest();
        noteReq.setNotification(n);
        notificationClient.sendNotification(noteReq);

        AssignTrainingResponse resp = new AssignTrainingResponse();
        resp.setAssignmentId(assignResp.getTraining().getId());
        return resp;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CompleteTrainingRequest")
    @ResponsePayload
    public CompleteTrainingResponse completeTraining(@RequestPayload CompleteTrainingRequest request) {
        com.example.orchestrator.wsclient.training.ObjectFactory tf = new com.example.orchestrator.wsclient.training.ObjectFactory();
        CompleteTrainingRequest completeReq = tf.createCompleteTrainingRequest();
        completeReq.setEmpId(request.getEmpId());
        trainingClient.complete(completeReq);

        NotificationDto n = new NotificationDto();
        n.setEmployeeId(request.getEmpId());
        n.setSubject("Training completed");
        n.setBody("Congrats! Your onboarding training is complete.");
        com.example.orchestrator.wsclient.notification.ObjectFactory nf = new com.example.orchestrator.wsclient.notification.ObjectFactory();
        SendNotificationRequest noteReq = nf.createSendNotificationRequest();
        noteReq.setNotification(n);
        notificationClient.sendNotification(noteReq);

        CompleteTrainingResponse resp = new CompleteTrainingResponse();
        resp.setStatus("Training completed");
        return resp;
    }
    // Define simple request/response classes for each operation to be used for marshalling/unmarshalling.
    // ... (these would normally be generated from onboarding.xsd, to be implemented in next step) ...
}
