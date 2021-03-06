//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.22 at 04:38:55 PM IST 
//


package AllipcClassificationSymbol;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="classifications">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="classification" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="symbol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="level" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="qTime" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                 &lt;attribute name="numFound" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="elapsedTime" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="start" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                 &lt;attribute name="rows" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                 &lt;attribute name="query" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
    "classifications"
})
@XmlRootElement(name = "WIPO-Classifications")
public class WIPOSymbolsOfVersion {

    @XmlElement(required = true)
    protected WIPOSymbolsOfVersion.Classifications classifications;

    /**
     * Gets the value of the classifications property.
     * 
     * @return
     *     possible object is
     *     {@link WIPOSymbolsOfVersion.Classifications }
     *     
     */
    public WIPOSymbolsOfVersion.Classifications getClassifications() {
        return classifications;
    }

    /**
     * Sets the value of the classifications property.
     * 
     * @param value
     *     allowed object is
     *     {@link WIPOSymbolsOfVersion.Classifications }
     *     
     */
    public void setClassifications(WIPOSymbolsOfVersion.Classifications value) {
        this.classifications = value;
    }


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
     *         &lt;element name="classification" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="symbol" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="level" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="qTime" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *       &lt;attribute name="numFound" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="elapsedTime" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="start" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *       &lt;attribute name="rows" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *       &lt;attribute name="query" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "classification"
    })
    public static class Classifications {

        protected List<WIPOSymbolsOfVersion.Classifications.Classification> classification;
        @XmlAttribute
        protected Byte qTime;
        @XmlAttribute
        protected Integer numFound;
        @XmlAttribute
        protected Byte elapsedTime;
        @XmlAttribute
        protected String type;
        @XmlAttribute
        protected Byte start;
        @XmlAttribute
        protected Byte rows;
        @XmlAttribute
        protected Byte query;

        /**
         * Gets the value of the classification property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the classification property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getClassification().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link WIPOSymbolsOfVersion.Classifications.Classification }
         * 
         * 
         */
        public List<WIPOSymbolsOfVersion.Classifications.Classification> getClassification() {
            if (classification == null) {
                classification = new ArrayList<WIPOSymbolsOfVersion.Classifications.Classification>();
            }
            return this.classification;
        }

        /**
         * Gets the value of the qTime property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getQTime() {
            return qTime;
        }

        /**
         * Sets the value of the qTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setQTime(Byte value) {
            this.qTime = value;
        }

        /**
         * Gets the value of the numFound property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getNumFound() {
            return numFound;
        }

        /**
         * Sets the value of the numFound property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setNumFound(Integer value) {
            this.numFound = value;
        }

        /**
         * Gets the value of the elapsedTime property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getElapsedTime() {
            return elapsedTime;
        }

        /**
         * Sets the value of the elapsedTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setElapsedTime(Byte value) {
            this.elapsedTime = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * Gets the value of the start property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getStart() {
            return start;
        }

        /**
         * Sets the value of the start property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setStart(Byte value) {
            this.start = value;
        }

        /**
         * Gets the value of the rows property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getRows() {
            return rows;
        }

        /**
         * Sets the value of the rows property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setRows(Byte value) {
            this.rows = value;
        }

        /**
         * Gets the value of the query property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getQuery() {
            return query;
        }

        /**
         * Sets the value of the query property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setQuery(Byte value) {
            this.query = value;
        }


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
         *         &lt;element name="symbol" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *       &lt;attribute name="level" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "symbol"
        })
        public static class Classification {

            @XmlElement(required = true)
            protected String symbol;
            @XmlAttribute
            protected String level;

            /**
             * Gets the value of the symbol property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSymbol() {
                return symbol;
            }

            /**
             * Sets the value of the symbol property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSymbol(String value) {
                this.symbol = value;
            }

            /**
             * Gets the value of the level property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLevel() {
                return level;
            }

            /**
             * Sets the value of the level property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLevel(String value) {
                this.level = value;
            }

        }

    }

}
