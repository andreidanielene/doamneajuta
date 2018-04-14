//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.15 at 12:34:59 AM EEST 
//


package ro.bestem.doamneajuta.service.generated.fixtures;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for resultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="goalsAwayTeam" type="{}goalsAwayTeamType"/>
 *         &lt;element name="goalsHomeTeam" type="{}goalsHomeTeamType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultType", propOrder = {
    "goalsAwayTeam",
    "goalsHomeTeam"
})
public class ResultType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected GoalsAwayTeamType goalsAwayTeam;
    @XmlElement(required = true)
    protected GoalsHomeTeamType goalsHomeTeam;

    /**
     * Gets the value of the goalsAwayTeam property.
     * 
     * @return
     *     possible object is
     *     {@link GoalsAwayTeamType }
     *     
     */
    public GoalsAwayTeamType getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    /**
     * Sets the value of the goalsAwayTeam property.
     * 
     * @param value
     *     allowed object is
     *     {@link GoalsAwayTeamType }
     *     
     */
    public void setGoalsAwayTeam(GoalsAwayTeamType value) {
        this.goalsAwayTeam = value;
    }

    /**
     * Gets the value of the goalsHomeTeam property.
     * 
     * @return
     *     possible object is
     *     {@link GoalsHomeTeamType }
     *     
     */
    public GoalsHomeTeamType getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    /**
     * Sets the value of the goalsHomeTeam property.
     * 
     * @param value
     *     allowed object is
     *     {@link GoalsHomeTeamType }
     *     
     */
    public void setGoalsHomeTeam(GoalsHomeTeamType value) {
        this.goalsHomeTeam = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ResultType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ResultType that = ((ResultType) object);
        {
            GoalsAwayTeamType lhsGoalsAwayTeam;
            lhsGoalsAwayTeam = this.getGoalsAwayTeam();
            GoalsAwayTeamType rhsGoalsAwayTeam;
            rhsGoalsAwayTeam = that.getGoalsAwayTeam();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "goalsAwayTeam", lhsGoalsAwayTeam), LocatorUtils.property(thatLocator, "goalsAwayTeam", rhsGoalsAwayTeam), lhsGoalsAwayTeam, rhsGoalsAwayTeam)) {
                return false;
            }
        }
        {
            GoalsHomeTeamType lhsGoalsHomeTeam;
            lhsGoalsHomeTeam = this.getGoalsHomeTeam();
            GoalsHomeTeamType rhsGoalsHomeTeam;
            rhsGoalsHomeTeam = that.getGoalsHomeTeam();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "goalsHomeTeam", lhsGoalsHomeTeam), LocatorUtils.property(thatLocator, "goalsHomeTeam", rhsGoalsHomeTeam), lhsGoalsHomeTeam, rhsGoalsHomeTeam)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            GoalsAwayTeamType theGoalsAwayTeam;
            theGoalsAwayTeam = this.getGoalsAwayTeam();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "goalsAwayTeam", theGoalsAwayTeam), currentHashCode, theGoalsAwayTeam);
        }
        {
            GoalsHomeTeamType theGoalsHomeTeam;
            theGoalsHomeTeam = this.getGoalsHomeTeam();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "goalsHomeTeam", theGoalsHomeTeam), currentHashCode, theGoalsHomeTeam);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            GoalsAwayTeamType theGoalsAwayTeam;
            theGoalsAwayTeam = this.getGoalsAwayTeam();
            strategy.appendField(locator, this, "goalsAwayTeam", buffer, theGoalsAwayTeam);
        }
        {
            GoalsHomeTeamType theGoalsHomeTeam;
            theGoalsHomeTeam = this.getGoalsHomeTeam();
            strategy.appendField(locator, this, "goalsHomeTeam", buffer, theGoalsHomeTeam);
        }
        return buffer;
    }

}