
package com.example.orchestrator.wsclient.training;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.orchestrator.wsclient.training package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.orchestrator.wsclient.training
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AssignTrainingRequest }
     * 
     */
    public AssignTrainingRequest createAssignTrainingRequest() {
        return new AssignTrainingRequest();
    }

    /**
     * Create an instance of {@link TrainingDto }
     * 
     */
    public TrainingDto createTrainingDto() {
        return new TrainingDto();
    }

    /**
     * Create an instance of {@link AssignTrainingResponse }
     * 
     */
    public AssignTrainingResponse createAssignTrainingResponse() {
        return new AssignTrainingResponse();
    }

    /**
     * Create an instance of {@link TrainingEntity }
     * 
     */
    public TrainingEntity createTrainingEntity() {
        return new TrainingEntity();
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

    /**
     * Create an instance of {@link CompleteTrainingRequest }
     * 
     */
    public CompleteTrainingRequest createCompleteTrainingRequest() {
        return new CompleteTrainingRequest();
    }

    /**
     * Create an instance of {@link CompleteTrainingResponse }
     * 
     */
    public CompleteTrainingResponse createCompleteTrainingResponse() {
        return new CompleteTrainingResponse();
    }

}
