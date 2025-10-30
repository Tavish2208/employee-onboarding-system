package com.example.employee.endpoint;

import com.example.common.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Endpoint
public class EmployeeEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/employee/ws";
    private final EmployeeService employeeService;

    public EmployeeEndpoint(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateEmployeeRequest")
    @ResponsePayload
    public CreateEmployeeResponse createEmployee(@RequestPayload CreateEmployeeRequest request) {
        Employee created = employeeService.create(request.getEmployee());
        CreateEmployeeResponse response = new CreateEmployeeResponse();
        response.setEmployee(created);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetEmployeeRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
        Employee e = employeeService.get(request.getId());
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setEmployee(e);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateEmployeeRequest")
    @ResponsePayload
    public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
        Employee updated = employeeService.update(request.getId(), request.getEmployee());
        UpdateEmployeeResponse response = new UpdateEmployeeResponse();
        response.setEmployee(updated);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteEmployeeRequest")
    @ResponsePayload
    public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
        employeeService.delete(request.getId());
        DeleteEmployeeResponse response = new DeleteEmployeeResponse();
        response.setResult("Employee deleted");
        return response;
    }

    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class CreateEmployeeRequest {
        @XmlElement(required=true)
        private EmployeeDto employee;
        public EmployeeDto getEmployee() { return employee; }
        public void setEmployee(EmployeeDto employee) { this.employee = employee; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class CreateEmployeeResponse {
        @XmlElement
        private Employee employee;
        public Employee getEmployee() { return employee; }
        public void setEmployee(Employee employee) { this.employee = employee; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class GetEmployeeRequest {
        @XmlElement
        private Long id;
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class GetEmployeeResponse {
        @XmlElement
        private Employee employee;
        public Employee getEmployee() { return employee; }
        public void setEmployee(Employee employee) { this.employee = employee; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class UpdateEmployeeRequest {
        @XmlElement
        private Long id;
        @XmlElement
        private EmployeeDto employee;
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public EmployeeDto getEmployee() { return employee; }
        public void setEmployee(EmployeeDto employee) { this.employee = employee; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class UpdateEmployeeResponse {
        @XmlElement
        private Employee employee;
        public Employee getEmployee() { return employee; }
        public void setEmployee(Employee employee) { this.employee = employee; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class DeleteEmployeeRequest {
        @XmlElement
        private Long id;
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class DeleteEmployeeResponse {
        @XmlElement
        private String result;
        public String getResult() { return result; }
        public void setResult(String result) { this.result = result; }
    }
}
