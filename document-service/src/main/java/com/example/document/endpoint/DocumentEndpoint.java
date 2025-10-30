package com.example.document.endpoint;

import com.example.common.dto.DocumentDto;
import com.example.document.entity.Document;
import com.example.document.repository.DocumentRepository;
import com.example.document.service.DocumentService;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class DocumentEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/document/ws";
    private final DocumentService documentService;
    private final DocumentRepository repository;

    public DocumentEndpoint(DocumentService documentService, DocumentRepository repository) {
        this.documentService = documentService;
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UploadDocumentRequest")
    @ResponsePayload
    public UploadDocumentResponse upload(@RequestPayload UploadDocumentRequest request) {
        Document uploaded = documentService.upload(request.getDocument());
        UploadDocumentResponse response = new UploadDocumentResponse();
        response.setDocument(uploaded);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "VerifyDocumentRequest")
    @ResponsePayload
    public VerifyDocumentResponse verify(@RequestPayload VerifyDocumentRequest request) {
        Document verified = documentService.verify(request.getId());
        VerifyDocumentResponse response = new VerifyDocumentResponse();
        response.setDocument(verified);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetDocumentRequest")
    @ResponsePayload
    public GetDocumentResponse get(@RequestPayload GetDocumentRequest request) {
        Document d = documentService.get(request.getId());
        GetDocumentResponse response = new GetDocumentResponse();
        response.setDocument(d);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ByEmployeeRequest")
    @ResponsePayload
    public ByEmployeeResponse byEmployee(@RequestPayload ByEmployeeRequest request) {
        List<Document> docs = repository.findByEmployeeId(request.getEmpId());
        ByEmployeeResponse response = new ByEmployeeResponse();
        response.setDocuments(docs);
        return response;
    }

    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class UploadDocumentRequest {
        @XmlElement(required=true)
        private DocumentDto document;
        public DocumentDto getDocument() { return document; }
        public void setDocument(DocumentDto document) { this.document = document; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class UploadDocumentResponse {
        @XmlElement
        private Document document;
        public Document getDocument() { return document; }
        public void setDocument(Document document) { this.document = document; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class VerifyDocumentRequest {
        @XmlElement
        private Long id;
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class VerifyDocumentResponse {
        @XmlElement
        private Document document;
        public Document getDocument() { return document; }
        public void setDocument(Document document) { this.document = document; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class GetDocumentRequest {
        @XmlElement
        private Long id;
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
    }
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class GetDocumentResponse {
        @XmlElement
        private Document document;
        public Document getDocument() { return document; }
        public void setDocument(Document document) { this.document = document; }
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
        @XmlElement(name="document")
        private List<Document> documents;
        public List<Document> getDocuments() { return documents; }
        public void setDocuments(List<Document> documents) { this.documents = documents; }
    }
}
