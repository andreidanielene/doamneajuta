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
 * <p>Java class for _linksType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="_linksType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="awayTeam" type="{}awayTeamType" minOccurs="0"/>
 *         &lt;element name="competition" type="{}competitionType"/>
 *         &lt;element name="homeTeam" type="{}homeTeamType" minOccurs="0"/>
 *         &lt;element name="self" type="{}selfType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "_linksType", propOrder = {
    "awayTeam",
    "competition",
    "homeTeam",
    "self"
})
public class LinksType
    implements Equals, HashCode, ToString
{

    protected AwayTeamType awayTeam;
    @XmlElement(required = true)
    protected CompetitionType competition;
    protected HomeTeamType homeTeam;
    @XmlElement(required = true)
    protected SelfType self;

    /**
     * Gets the value of the awayTeam property.
     * 
     * @return
     *     possible object is
     *     {@link AwayTeamType }
     *     
     */
    public AwayTeamType getAwayTeam() {
        return awayTeam;
    }

    /**
     * Sets the value of the awayTeam property.
     * 
     * @param value
     *     allowed object is
     *     {@link AwayTeamType }
     *     
     */
    public void setAwayTeam(AwayTeamType value) {
        this.awayTeam = value;
    }

    /**
     * Gets the value of the competition property.
     * 
     * @return
     *     possible object is
     *     {@link CompetitionType }
     *     
     */
    public CompetitionType getCompetition() {
        return competition;
    }

    /**
     * Sets the value of the competition property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompetitionType }
     *     
     */
    public void setCompetition(CompetitionType value) {
        this.competition = value;
    }

    /**
     * Gets the value of the homeTeam property.
     * 
     * @return
     *     possible object is
     *     {@link HomeTeamType }
     *     
     */
    public HomeTeamType getHomeTeam() {
        return homeTeam;
    }

    /**
     * Sets the value of the homeTeam property.
     * 
     * @param value
     *     allowed object is
     *     {@link HomeTeamType }
     *     
     */
    public void setHomeTeam(HomeTeamType value) {
        this.homeTeam = value;
    }

    /**
     * Gets the value of the self property.
     * 
     * @return
     *     possible object is
     *     {@link SelfType }
     *     
     */
    public SelfType getSelf() {
        return self;
    }

    /**
     * Sets the value of the self property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelfType }
     *     
     */
    public void setSelf(SelfType value) {
        this.self = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LinksType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LinksType that = ((LinksType) object);
        {
            AwayTeamType lhsAwayTeam;
            lhsAwayTeam = this.getAwayTeam();
            AwayTeamType rhsAwayTeam;
            rhsAwayTeam = that.getAwayTeam();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "awayTeam", lhsAwayTeam), LocatorUtils.property(thatLocator, "awayTeam", rhsAwayTeam), lhsAwayTeam, rhsAwayTeam)) {
                return false;
            }
        }
        {
            CompetitionType lhsCompetition;
            lhsCompetition = this.getCompetition();
            CompetitionType rhsCompetition;
            rhsCompetition = that.getCompetition();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "competition", lhsCompetition), LocatorUtils.property(thatLocator, "competition", rhsCompetition), lhsCompetition, rhsCompetition)) {
                return false;
            }
        }
        {
            HomeTeamType lhsHomeTeam;
            lhsHomeTeam = this.getHomeTeam();
            HomeTeamType rhsHomeTeam;
            rhsHomeTeam = that.getHomeTeam();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "homeTeam", lhsHomeTeam), LocatorUtils.property(thatLocator, "homeTeam", rhsHomeTeam), lhsHomeTeam, rhsHomeTeam)) {
                return false;
            }
        }
        {
            SelfType lhsSelf;
            lhsSelf = this.getSelf();
            SelfType rhsSelf;
            rhsSelf = that.getSelf();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "self", lhsSelf), LocatorUtils.property(thatLocator, "self", rhsSelf), lhsSelf, rhsSelf)) {
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
            AwayTeamType theAwayTeam;
            theAwayTeam = this.getAwayTeam();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "awayTeam", theAwayTeam), currentHashCode, theAwayTeam);
        }
        {
            CompetitionType theCompetition;
            theCompetition = this.getCompetition();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "competition", theCompetition), currentHashCode, theCompetition);
        }
        {
            HomeTeamType theHomeTeam;
            theHomeTeam = this.getHomeTeam();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "homeTeam", theHomeTeam), currentHashCode, theHomeTeam);
        }
        {
            SelfType theSelf;
            theSelf = this.getSelf();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "self", theSelf), currentHashCode, theSelf);
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
            AwayTeamType theAwayTeam;
            theAwayTeam = this.getAwayTeam();
            strategy.appendField(locator, this, "awayTeam", buffer, theAwayTeam);
        }
        {
            CompetitionType theCompetition;
            theCompetition = this.getCompetition();
            strategy.appendField(locator, this, "competition", buffer, theCompetition);
        }
        {
            HomeTeamType theHomeTeam;
            theHomeTeam = this.getHomeTeam();
            strategy.appendField(locator, this, "homeTeam", buffer, theHomeTeam);
        }
        {
            SelfType theSelf;
            theSelf = this.getSelf();
            strategy.appendField(locator, this, "self", buffer, theSelf);
        }
        return buffer;
    }

}
