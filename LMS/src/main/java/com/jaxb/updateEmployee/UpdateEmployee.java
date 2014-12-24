//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.29 at 10:58:32 AM IST 
//


package com.jaxb.updateEmployee;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Emp_ID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[M,E]_[1-9]+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Password" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[A-Z,a-z,1-9]+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ManagerID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[M]_[1-9]+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Designation" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="ASSOCIATE"/>
 *               &lt;enumeration value="SENIOR_ASSOCIATE"/>
 *               &lt;enumeration value="MANAGER"/>
 *               &lt;enumeration value="SENIOR_MANAGER"/>
 *               &lt;enumeration value="DIRECTOR"/>
 *               &lt;enumeration value="VP"/>
 *               &lt;enumeration value="CEO"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "empID",
    "password",
    "managerID",
    "designation"
})
@XmlRootElement(name = "updateEmployee")
public class UpdateEmployee {

    @XmlElement(name = "Emp_ID", required = true)
    protected String empID;
    @XmlElement(name = "Password")
    protected String password;
    @XmlElement(name = "ManagerID")
    protected String managerID;
    @XmlElement(name = "Designation")
    protected String designation;

    /**
     * Gets the value of the empID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpID() {
        return empID;
    }

    /**
     * Sets the value of the empID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpID(String value) {
        this.empID = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the managerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagerID() {
        return managerID;
    }

    /**
     * Sets the value of the managerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagerID(String value) {
        this.managerID = value;
    }

    /**
     * Gets the value of the designation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Sets the value of the designation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesignation(String value) {
        this.designation = value;
    }

}
