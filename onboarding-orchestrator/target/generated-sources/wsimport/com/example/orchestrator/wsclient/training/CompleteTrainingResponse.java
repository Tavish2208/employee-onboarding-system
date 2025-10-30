
package com.example.orchestrator.wsclient.training;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="training" type="{http://example.com/training/ws}trainingEntity"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "training"
})
@XmlRootElement(name = "CompleteTrainingResponse")
public class CompleteTrainingResponse {

    @XmlElement(required = true)
    protected TrainingEntity training;

    /**
     * Gets the value of the training property.
     * 
     * @return
     *     possible object is
     *     {@link TrainingEntity }
     *     
     */
    public TrainingEntity getTraining() {
        return training;
    }

    /**
     * Sets the value of the training property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrainingEntity }
     *     
     */
    public void setTraining(TrainingEntity value) {
        this.training = value;
    }

}
