package com.example.training.endpoint;

import com.example.common.dto.TrainingDto;
import com.example.training.entity.Training;
import com.example.training.service.TrainingAppService;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class TrainingEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/training/ws";
    private final TrainingAppService trainingAppService;

    public TrainingEndpoint(TrainingAppService trainingAppService) {
        this.trainingAppService = trainingAppService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AssignTrainingRequest")
    @ResponsePayload
    public AssignTrainingResponse assign(@RequestPayload AssignTrainingRequest request) {
        Training assigned = trainingAppService.assign(request.getTraining());
        AssignTrainingResponse response = new AssignTrainingResponse();
        response.setTraining(assigned);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ByEmployeeRequest")
    @ResponsePayload
    public ByEmployeeResponse byEmployee(@RequestPayload ByEmployeeRequest request) {
        List<Training> trainingList = trainingAppService.listByEmployee(request.getEmpId());
        ByEmployeeResponse response = new ByEmployeeResponse();
        response.setTrainings(trainingList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CompleteTrainingRequest")
    @ResponsePayload
    public CompleteTrainingResponse complete(@RequestPayload CompleteTrainingRequest request) {
        Training completed = trainingAppService.complete(request.getEmpId());
        CompleteTrainingResponse response = new CompleteTrainingResponse();
        response.setTraining(completed);
        return response;
    }

    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class AssignTrainingRequest {
        @XmlElement(required=true)
        private TrainingDto training;
        public TrainingDto getTraining() { return training; }
        public void setTraining(TrainingDto training) { this.training = training; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class AssignTrainingResponse {
        @XmlElement
        private Training training;
        public Training getTraining() { return training; }
        public void setTraining(Training training) { this.training = training; }
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
        @XmlElement(name="training")
        private List<Training> trainings;
        public List<Training> getTrainings() { return trainings; }
        public void setTrainings(List<Training> trainings) { this.trainings = trainings; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class CompleteTrainingRequest {
        @XmlElement
        private Long empId;
        public Long getEmpId() { return empId; }
        public void setEmpId(Long empId) { this.empId = empId; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class CompleteTrainingResponse {
        @XmlElement
        private Training training;
        public Training getTraining() { return training; }
        public void setTraining(Training training) { this.training = training; }
    }
}
