
package com.example.orchestrator.wsclient.document;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.orchestrator.wsclient.document package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.orchestrator.wsclient.document
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UploadDocumentRequest }
     * 
     */
    public UploadDocumentRequest createUploadDocumentRequest() {
        return new UploadDocumentRequest();
    }

    /**
     * Create an instance of {@link DocumentDto }
     * 
     */
    public DocumentDto createDocumentDto() {
        return new DocumentDto();
    }

    /**
     * Create an instance of {@link UploadDocumentResponse }
     * 
     */
    public UploadDocumentResponse createUploadDocumentResponse() {
        return new UploadDocumentResponse();
    }

    /**
     * Create an instance of {@link DocumentEntity }
     * 
     */
    public DocumentEntity createDocumentEntity() {
        return new DocumentEntity();
    }

    /**
     * Create an instance of {@link VerifyDocumentRequest }
     * 
     */
    public VerifyDocumentRequest createVerifyDocumentRequest() {
        return new VerifyDocumentRequest();
    }

    /**
     * Create an instance of {@link VerifyDocumentResponse }
     * 
     */
    public VerifyDocumentResponse createVerifyDocumentResponse() {
        return new VerifyDocumentResponse();
    }

    /**
     * Create an instance of {@link GetDocumentRequest }
     * 
     */
    public GetDocumentRequest createGetDocumentRequest() {
        return new GetDocumentRequest();
    }

    /**
     * Create an instance of {@link GetDocumentResponse }
     * 
     */
    public GetDocumentResponse createGetDocumentResponse() {
        return new GetDocumentResponse();
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
