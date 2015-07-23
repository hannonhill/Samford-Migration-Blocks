/**
 * Destination.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 12, 2007 (02:39:05 EDT) WSDL2Java emitter.
 */

package com.hannonhill.www.ws.ns.AssetOperationService;

public class Destination  extends com.hannonhill.www.ws.ns.AssetOperationService.NamedAsset  implements java.io.Serializable {
    private java.lang.String parentContainerId;

    private java.lang.String parentContainerPath;

    private java.lang.String transportId;

    private java.lang.String transportPath;

    private java.lang.String applicableGroups;

    private java.lang.String directory;

    private java.lang.Boolean enabled;

    private java.lang.Boolean checkedByDefault;

    private java.lang.Boolean publishASCII;

    private java.lang.Boolean usesScheduledPublishing;

    private com.hannonhill.www.ws.ns.AssetOperationService.ScheduledDestinationMode scheduledPublishDestinationMode;

    private com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] scheduledPublishDestinations;

    private org.apache.axis.types.Time timeToPublish;

    private org.apache.axis.types.NonNegativeInteger publishIntervalHours;

    private com.hannonhill.www.ws.ns.AssetOperationService.DayOfWeek[] publishDaysOfWeek;

    private java.lang.String cronExpression;

    private java.lang.String sendReportToUsers;

    private java.lang.String sendReportToGroups;

    private java.lang.Boolean sendReportOnErrorOnly;

    private java.lang.String webUrl;

    private java.lang.String siteId;

    private java.lang.String siteName;

    public Destination() {
    }

    public Destination(
           java.lang.String id,
           java.lang.String name,
           java.lang.String parentContainerId,
           java.lang.String parentContainerPath,
           java.lang.String transportId,
           java.lang.String transportPath,
           java.lang.String applicableGroups,
           java.lang.String directory,
           java.lang.Boolean enabled,
           java.lang.Boolean checkedByDefault,
           java.lang.Boolean publishASCII,
           java.lang.Boolean usesScheduledPublishing,
           com.hannonhill.www.ws.ns.AssetOperationService.ScheduledDestinationMode scheduledPublishDestinationMode,
           com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] scheduledPublishDestinations,
           org.apache.axis.types.Time timeToPublish,
           org.apache.axis.types.NonNegativeInteger publishIntervalHours,
           com.hannonhill.www.ws.ns.AssetOperationService.DayOfWeek[] publishDaysOfWeek,
           java.lang.String cronExpression,
           java.lang.String sendReportToUsers,
           java.lang.String sendReportToGroups,
           java.lang.Boolean sendReportOnErrorOnly,
           java.lang.String webUrl,
           java.lang.String siteId,
           java.lang.String siteName) {
        super(
            id,
            name);
        this.parentContainerId = parentContainerId;
        this.parentContainerPath = parentContainerPath;
        this.transportId = transportId;
        this.transportPath = transportPath;
        this.applicableGroups = applicableGroups;
        this.directory = directory;
        this.enabled = enabled;
        this.checkedByDefault = checkedByDefault;
        this.publishASCII = publishASCII;
        this.usesScheduledPublishing = usesScheduledPublishing;
        this.scheduledPublishDestinationMode = scheduledPublishDestinationMode;
        this.scheduledPublishDestinations = scheduledPublishDestinations;
        this.timeToPublish = timeToPublish;
        this.publishIntervalHours = publishIntervalHours;
        this.publishDaysOfWeek = publishDaysOfWeek;
        this.cronExpression = cronExpression;
        this.sendReportToUsers = sendReportToUsers;
        this.sendReportToGroups = sendReportToGroups;
        this.sendReportOnErrorOnly = sendReportOnErrorOnly;
        this.webUrl = webUrl;
        this.siteId = siteId;
        this.siteName = siteName;
    }


    /**
     * Gets the parentContainerId value for this Destination.
     * 
     * @return parentContainerId
     */
    public java.lang.String getParentContainerId() {
        return parentContainerId;
    }


    /**
     * Sets the parentContainerId value for this Destination.
     * 
     * @param parentContainerId
     */
    public void setParentContainerId(java.lang.String parentContainerId) {
        this.parentContainerId = parentContainerId;
    }


    /**
     * Gets the parentContainerPath value for this Destination.
     * 
     * @return parentContainerPath
     */
    public java.lang.String getParentContainerPath() {
        return parentContainerPath;
    }


    /**
     * Sets the parentContainerPath value for this Destination.
     * 
     * @param parentContainerPath
     */
    public void setParentContainerPath(java.lang.String parentContainerPath) {
        this.parentContainerPath = parentContainerPath;
    }


    /**
     * Gets the transportId value for this Destination.
     * 
     * @return transportId
     */
    public java.lang.String getTransportId() {
        return transportId;
    }


    /**
     * Sets the transportId value for this Destination.
     * 
     * @param transportId
     */
    public void setTransportId(java.lang.String transportId) {
        this.transportId = transportId;
    }


    /**
     * Gets the transportPath value for this Destination.
     * 
     * @return transportPath
     */
    public java.lang.String getTransportPath() {
        return transportPath;
    }


    /**
     * Sets the transportPath value for this Destination.
     * 
     * @param transportPath
     */
    public void setTransportPath(java.lang.String transportPath) {
        this.transportPath = transportPath;
    }


    /**
     * Gets the applicableGroups value for this Destination.
     * 
     * @return applicableGroups
     */
    public java.lang.String getApplicableGroups() {
        return applicableGroups;
    }


    /**
     * Sets the applicableGroups value for this Destination.
     * 
     * @param applicableGroups
     */
    public void setApplicableGroups(java.lang.String applicableGroups) {
        this.applicableGroups = applicableGroups;
    }


    /**
     * Gets the directory value for this Destination.
     * 
     * @return directory
     */
    public java.lang.String getDirectory() {
        return directory;
    }


    /**
     * Sets the directory value for this Destination.
     * 
     * @param directory
     */
    public void setDirectory(java.lang.String directory) {
        this.directory = directory;
    }


    /**
     * Gets the enabled value for this Destination.
     * 
     * @return enabled
     */
    public java.lang.Boolean getEnabled() {
        return enabled;
    }


    /**
     * Sets the enabled value for this Destination.
     * 
     * @param enabled
     */
    public void setEnabled(java.lang.Boolean enabled) {
        this.enabled = enabled;
    }


    /**
     * Gets the checkedByDefault value for this Destination.
     * 
     * @return checkedByDefault
     */
    public java.lang.Boolean getCheckedByDefault() {
        return checkedByDefault;
    }


    /**
     * Sets the checkedByDefault value for this Destination.
     * 
     * @param checkedByDefault
     */
    public void setCheckedByDefault(java.lang.Boolean checkedByDefault) {
        this.checkedByDefault = checkedByDefault;
    }


    /**
     * Gets the publishASCII value for this Destination.
     * 
     * @return publishASCII
     */
    public java.lang.Boolean getPublishASCII() {
        return publishASCII;
    }


    /**
     * Sets the publishASCII value for this Destination.
     * 
     * @param publishASCII
     */
    public void setPublishASCII(java.lang.Boolean publishASCII) {
        this.publishASCII = publishASCII;
    }


    /**
     * Gets the usesScheduledPublishing value for this Destination.
     * 
     * @return usesScheduledPublishing
     */
    public java.lang.Boolean getUsesScheduledPublishing() {
        return usesScheduledPublishing;
    }


    /**
     * Sets the usesScheduledPublishing value for this Destination.
     * 
     * @param usesScheduledPublishing
     */
    public void setUsesScheduledPublishing(java.lang.Boolean usesScheduledPublishing) {
        this.usesScheduledPublishing = usesScheduledPublishing;
    }


    /**
     * Gets the scheduledPublishDestinationMode value for this Destination.
     * 
     * @return scheduledPublishDestinationMode
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.ScheduledDestinationMode getScheduledPublishDestinationMode() {
        return scheduledPublishDestinationMode;
    }


    /**
     * Sets the scheduledPublishDestinationMode value for this Destination.
     * 
     * @param scheduledPublishDestinationMode
     */
    public void setScheduledPublishDestinationMode(com.hannonhill.www.ws.ns.AssetOperationService.ScheduledDestinationMode scheduledPublishDestinationMode) {
        this.scheduledPublishDestinationMode = scheduledPublishDestinationMode;
    }


    /**
     * Gets the scheduledPublishDestinations value for this Destination.
     * 
     * @return scheduledPublishDestinations
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] getScheduledPublishDestinations() {
        return scheduledPublishDestinations;
    }


    /**
     * Sets the scheduledPublishDestinations value for this Destination.
     * 
     * @param scheduledPublishDestinations
     */
    public void setScheduledPublishDestinations(com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] scheduledPublishDestinations) {
        this.scheduledPublishDestinations = scheduledPublishDestinations;
    }


    /**
     * Gets the timeToPublish value for this Destination.
     * 
     * @return timeToPublish
     */
    public org.apache.axis.types.Time getTimeToPublish() {
        return timeToPublish;
    }


    /**
     * Sets the timeToPublish value for this Destination.
     * 
     * @param timeToPublish
     */
    public void setTimeToPublish(org.apache.axis.types.Time timeToPublish) {
        this.timeToPublish = timeToPublish;
    }


    /**
     * Gets the publishIntervalHours value for this Destination.
     * 
     * @return publishIntervalHours
     */
    public org.apache.axis.types.NonNegativeInteger getPublishIntervalHours() {
        return publishIntervalHours;
    }


    /**
     * Sets the publishIntervalHours value for this Destination.
     * 
     * @param publishIntervalHours
     */
    public void setPublishIntervalHours(org.apache.axis.types.NonNegativeInteger publishIntervalHours) {
        this.publishIntervalHours = publishIntervalHours;
    }


    /**
     * Gets the publishDaysOfWeek value for this Destination.
     * 
     * @return publishDaysOfWeek
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.DayOfWeek[] getPublishDaysOfWeek() {
        return publishDaysOfWeek;
    }


    /**
     * Sets the publishDaysOfWeek value for this Destination.
     * 
     * @param publishDaysOfWeek
     */
    public void setPublishDaysOfWeek(com.hannonhill.www.ws.ns.AssetOperationService.DayOfWeek[] publishDaysOfWeek) {
        this.publishDaysOfWeek = publishDaysOfWeek;
    }


    /**
     * Gets the cronExpression value for this Destination.
     * 
     * @return cronExpression
     */
    public java.lang.String getCronExpression() {
        return cronExpression;
    }


    /**
     * Sets the cronExpression value for this Destination.
     * 
     * @param cronExpression
     */
    public void setCronExpression(java.lang.String cronExpression) {
        this.cronExpression = cronExpression;
    }


    /**
     * Gets the sendReportToUsers value for this Destination.
     * 
     * @return sendReportToUsers
     */
    public java.lang.String getSendReportToUsers() {
        return sendReportToUsers;
    }


    /**
     * Sets the sendReportToUsers value for this Destination.
     * 
     * @param sendReportToUsers
     */
    public void setSendReportToUsers(java.lang.String sendReportToUsers) {
        this.sendReportToUsers = sendReportToUsers;
    }


    /**
     * Gets the sendReportToGroups value for this Destination.
     * 
     * @return sendReportToGroups
     */
    public java.lang.String getSendReportToGroups() {
        return sendReportToGroups;
    }


    /**
     * Sets the sendReportToGroups value for this Destination.
     * 
     * @param sendReportToGroups
     */
    public void setSendReportToGroups(java.lang.String sendReportToGroups) {
        this.sendReportToGroups = sendReportToGroups;
    }


    /**
     * Gets the sendReportOnErrorOnly value for this Destination.
     * 
     * @return sendReportOnErrorOnly
     */
    public java.lang.Boolean getSendReportOnErrorOnly() {
        return sendReportOnErrorOnly;
    }


    /**
     * Sets the sendReportOnErrorOnly value for this Destination.
     * 
     * @param sendReportOnErrorOnly
     */
    public void setSendReportOnErrorOnly(java.lang.Boolean sendReportOnErrorOnly) {
        this.sendReportOnErrorOnly = sendReportOnErrorOnly;
    }


    /**
     * Gets the webUrl value for this Destination.
     * 
     * @return webUrl
     */
    public java.lang.String getWebUrl() {
        return webUrl;
    }


    /**
     * Sets the webUrl value for this Destination.
     * 
     * @param webUrl
     */
    public void setWebUrl(java.lang.String webUrl) {
        this.webUrl = webUrl;
    }


    /**
     * Gets the siteId value for this Destination.
     * 
     * @return siteId
     */
    public java.lang.String getSiteId() {
        return siteId;
    }


    /**
     * Sets the siteId value for this Destination.
     * 
     * @param siteId
     */
    public void setSiteId(java.lang.String siteId) {
        this.siteId = siteId;
    }


    /**
     * Gets the siteName value for this Destination.
     * 
     * @return siteName
     */
    public java.lang.String getSiteName() {
        return siteName;
    }


    /**
     * Sets the siteName value for this Destination.
     * 
     * @param siteName
     */
    public void setSiteName(java.lang.String siteName) {
        this.siteName = siteName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Destination)) return false;
        Destination other = (Destination) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.parentContainerId==null && other.getParentContainerId()==null) || 
             (this.parentContainerId!=null &&
              this.parentContainerId.equals(other.getParentContainerId()))) &&
            ((this.parentContainerPath==null && other.getParentContainerPath()==null) || 
             (this.parentContainerPath!=null &&
              this.parentContainerPath.equals(other.getParentContainerPath()))) &&
            ((this.transportId==null && other.getTransportId()==null) || 
             (this.transportId!=null &&
              this.transportId.equals(other.getTransportId()))) &&
            ((this.transportPath==null && other.getTransportPath()==null) || 
             (this.transportPath!=null &&
              this.transportPath.equals(other.getTransportPath()))) &&
            ((this.applicableGroups==null && other.getApplicableGroups()==null) || 
             (this.applicableGroups!=null &&
              this.applicableGroups.equals(other.getApplicableGroups()))) &&
            ((this.directory==null && other.getDirectory()==null) || 
             (this.directory!=null &&
              this.directory.equals(other.getDirectory()))) &&
            ((this.enabled==null && other.getEnabled()==null) || 
             (this.enabled!=null &&
              this.enabled.equals(other.getEnabled()))) &&
            ((this.checkedByDefault==null && other.getCheckedByDefault()==null) || 
             (this.checkedByDefault!=null &&
              this.checkedByDefault.equals(other.getCheckedByDefault()))) &&
            ((this.publishASCII==null && other.getPublishASCII()==null) || 
             (this.publishASCII!=null &&
              this.publishASCII.equals(other.getPublishASCII()))) &&
            ((this.usesScheduledPublishing==null && other.getUsesScheduledPublishing()==null) || 
             (this.usesScheduledPublishing!=null &&
              this.usesScheduledPublishing.equals(other.getUsesScheduledPublishing()))) &&
            ((this.scheduledPublishDestinationMode==null && other.getScheduledPublishDestinationMode()==null) || 
             (this.scheduledPublishDestinationMode!=null &&
              this.scheduledPublishDestinationMode.equals(other.getScheduledPublishDestinationMode()))) &&
            ((this.scheduledPublishDestinations==null && other.getScheduledPublishDestinations()==null) || 
             (this.scheduledPublishDestinations!=null &&
              java.util.Arrays.equals(this.scheduledPublishDestinations, other.getScheduledPublishDestinations()))) &&
            ((this.timeToPublish==null && other.getTimeToPublish()==null) || 
             (this.timeToPublish!=null &&
              this.timeToPublish.equals(other.getTimeToPublish()))) &&
            ((this.publishIntervalHours==null && other.getPublishIntervalHours()==null) || 
             (this.publishIntervalHours!=null &&
              this.publishIntervalHours.equals(other.getPublishIntervalHours()))) &&
            ((this.publishDaysOfWeek==null && other.getPublishDaysOfWeek()==null) || 
             (this.publishDaysOfWeek!=null &&
              java.util.Arrays.equals(this.publishDaysOfWeek, other.getPublishDaysOfWeek()))) &&
            ((this.cronExpression==null && other.getCronExpression()==null) || 
             (this.cronExpression!=null &&
              this.cronExpression.equals(other.getCronExpression()))) &&
            ((this.sendReportToUsers==null && other.getSendReportToUsers()==null) || 
             (this.sendReportToUsers!=null &&
              this.sendReportToUsers.equals(other.getSendReportToUsers()))) &&
            ((this.sendReportToGroups==null && other.getSendReportToGroups()==null) || 
             (this.sendReportToGroups!=null &&
              this.sendReportToGroups.equals(other.getSendReportToGroups()))) &&
            ((this.sendReportOnErrorOnly==null && other.getSendReportOnErrorOnly()==null) || 
             (this.sendReportOnErrorOnly!=null &&
              this.sendReportOnErrorOnly.equals(other.getSendReportOnErrorOnly()))) &&
            ((this.webUrl==null && other.getWebUrl()==null) || 
             (this.webUrl!=null &&
              this.webUrl.equals(other.getWebUrl()))) &&
            ((this.siteId==null && other.getSiteId()==null) || 
             (this.siteId!=null &&
              this.siteId.equals(other.getSiteId()))) &&
            ((this.siteName==null && other.getSiteName()==null) || 
             (this.siteName!=null &&
              this.siteName.equals(other.getSiteName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getParentContainerId() != null) {
            _hashCode += getParentContainerId().hashCode();
        }
        if (getParentContainerPath() != null) {
            _hashCode += getParentContainerPath().hashCode();
        }
        if (getTransportId() != null) {
            _hashCode += getTransportId().hashCode();
        }
        if (getTransportPath() != null) {
            _hashCode += getTransportPath().hashCode();
        }
        if (getApplicableGroups() != null) {
            _hashCode += getApplicableGroups().hashCode();
        }
        if (getDirectory() != null) {
            _hashCode += getDirectory().hashCode();
        }
        if (getEnabled() != null) {
            _hashCode += getEnabled().hashCode();
        }
        if (getCheckedByDefault() != null) {
            _hashCode += getCheckedByDefault().hashCode();
        }
        if (getPublishASCII() != null) {
            _hashCode += getPublishASCII().hashCode();
        }
        if (getUsesScheduledPublishing() != null) {
            _hashCode += getUsesScheduledPublishing().hashCode();
        }
        if (getScheduledPublishDestinationMode() != null) {
            _hashCode += getScheduledPublishDestinationMode().hashCode();
        }
        if (getScheduledPublishDestinations() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getScheduledPublishDestinations());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getScheduledPublishDestinations(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTimeToPublish() != null) {
            _hashCode += getTimeToPublish().hashCode();
        }
        if (getPublishIntervalHours() != null) {
            _hashCode += getPublishIntervalHours().hashCode();
        }
        if (getPublishDaysOfWeek() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPublishDaysOfWeek());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPublishDaysOfWeek(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCronExpression() != null) {
            _hashCode += getCronExpression().hashCode();
        }
        if (getSendReportToUsers() != null) {
            _hashCode += getSendReportToUsers().hashCode();
        }
        if (getSendReportToGroups() != null) {
            _hashCode += getSendReportToGroups().hashCode();
        }
        if (getSendReportOnErrorOnly() != null) {
            _hashCode += getSendReportOnErrorOnly().hashCode();
        }
        if (getWebUrl() != null) {
            _hashCode += getWebUrl().hashCode();
        }
        if (getSiteId() != null) {
            _hashCode += getSiteId().hashCode();
        }
        if (getSiteName() != null) {
            _hashCode += getSiteName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Destination.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "destination"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentContainerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "parentContainerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentContainerPath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "parentContainerPath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "transportId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportPath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "transportPath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicableGroups");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "applicableGroups"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("directory");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "directory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enabled");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "enabled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkedByDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "checkedByDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publishASCII");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "publishASCII"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usesScheduledPublishing");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "usesScheduledPublishing"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduledPublishDestinationMode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "scheduledPublishDestinationMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "scheduledDestinationMode"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduledPublishDestinations");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "scheduledPublishDestinations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "destination"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeToPublish");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "timeToPublish"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "time"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publishIntervalHours");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "publishIntervalHours"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "nonNegativeInteger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publishDaysOfWeek");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "publishDaysOfWeek"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "dayOfWeek"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "dayOfWeek"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cronExpression");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "cronExpression"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendReportToUsers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "sendReportToUsers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendReportToGroups");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "sendReportToGroups"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendReportOnErrorOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "sendReportOnErrorOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("webUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "webUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siteId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "siteId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siteName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "siteName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
