/**
 * PublishSet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 12, 2007 (02:39:05 EDT) WSDL2Java emitter.
 */

package com.hannonhill.www.ws.ns.AssetOperationService;

public class PublishSet  extends com.hannonhill.www.ws.ns.AssetOperationService.ContaineredAsset  implements java.io.Serializable {
    private com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] files;

    private com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] folders;

    private com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] pages;

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

    public PublishSet() {
    }

    public PublishSet(
           java.lang.String id,
           java.lang.String name,
           java.lang.String parentContainerId,
           java.lang.String parentContainerPath,
           java.lang.String path,
           java.lang.String siteId,
           java.lang.String siteName,
           com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] files,
           com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] folders,
           com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] pages,
           java.lang.Boolean usesScheduledPublishing,
           com.hannonhill.www.ws.ns.AssetOperationService.ScheduledDestinationMode scheduledPublishDestinationMode,
           com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] scheduledPublishDestinations,
           org.apache.axis.types.Time timeToPublish,
           org.apache.axis.types.NonNegativeInteger publishIntervalHours,
           com.hannonhill.www.ws.ns.AssetOperationService.DayOfWeek[] publishDaysOfWeek,
           java.lang.String cronExpression,
           java.lang.String sendReportToUsers,
           java.lang.String sendReportToGroups,
           java.lang.Boolean sendReportOnErrorOnly) {
        super(
            id,
            name,
            parentContainerId,
            parentContainerPath,
            path,
            siteId,
            siteName);
        this.files = files;
        this.folders = folders;
        this.pages = pages;
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
    }


    /**
     * Gets the files value for this PublishSet.
     * 
     * @return files
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] getFiles() {
        return files;
    }


    /**
     * Sets the files value for this PublishSet.
     * 
     * @param files
     */
    public void setFiles(com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] files) {
        this.files = files;
    }


    /**
     * Gets the folders value for this PublishSet.
     * 
     * @return folders
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] getFolders() {
        return folders;
    }


    /**
     * Sets the folders value for this PublishSet.
     * 
     * @param folders
     */
    public void setFolders(com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] folders) {
        this.folders = folders;
    }


    /**
     * Gets the pages value for this PublishSet.
     * 
     * @return pages
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] getPages() {
        return pages;
    }


    /**
     * Sets the pages value for this PublishSet.
     * 
     * @param pages
     */
    public void setPages(com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] pages) {
        this.pages = pages;
    }


    /**
     * Gets the usesScheduledPublishing value for this PublishSet.
     * 
     * @return usesScheduledPublishing
     */
    public java.lang.Boolean getUsesScheduledPublishing() {
        return usesScheduledPublishing;
    }


    /**
     * Sets the usesScheduledPublishing value for this PublishSet.
     * 
     * @param usesScheduledPublishing
     */
    public void setUsesScheduledPublishing(java.lang.Boolean usesScheduledPublishing) {
        this.usesScheduledPublishing = usesScheduledPublishing;
    }


    /**
     * Gets the scheduledPublishDestinationMode value for this PublishSet.
     * 
     * @return scheduledPublishDestinationMode
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.ScheduledDestinationMode getScheduledPublishDestinationMode() {
        return scheduledPublishDestinationMode;
    }


    /**
     * Sets the scheduledPublishDestinationMode value for this PublishSet.
     * 
     * @param scheduledPublishDestinationMode
     */
    public void setScheduledPublishDestinationMode(com.hannonhill.www.ws.ns.AssetOperationService.ScheduledDestinationMode scheduledPublishDestinationMode) {
        this.scheduledPublishDestinationMode = scheduledPublishDestinationMode;
    }


    /**
     * Gets the scheduledPublishDestinations value for this PublishSet.
     * 
     * @return scheduledPublishDestinations
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] getScheduledPublishDestinations() {
        return scheduledPublishDestinations;
    }


    /**
     * Sets the scheduledPublishDestinations value for this PublishSet.
     * 
     * @param scheduledPublishDestinations
     */
    public void setScheduledPublishDestinations(com.hannonhill.www.ws.ns.AssetOperationService.Identifier[] scheduledPublishDestinations) {
        this.scheduledPublishDestinations = scheduledPublishDestinations;
    }


    /**
     * Gets the timeToPublish value for this PublishSet.
     * 
     * @return timeToPublish
     */
    public org.apache.axis.types.Time getTimeToPublish() {
        return timeToPublish;
    }


    /**
     * Sets the timeToPublish value for this PublishSet.
     * 
     * @param timeToPublish
     */
    public void setTimeToPublish(org.apache.axis.types.Time timeToPublish) {
        this.timeToPublish = timeToPublish;
    }


    /**
     * Gets the publishIntervalHours value for this PublishSet.
     * 
     * @return publishIntervalHours
     */
    public org.apache.axis.types.NonNegativeInteger getPublishIntervalHours() {
        return publishIntervalHours;
    }


    /**
     * Sets the publishIntervalHours value for this PublishSet.
     * 
     * @param publishIntervalHours
     */
    public void setPublishIntervalHours(org.apache.axis.types.NonNegativeInteger publishIntervalHours) {
        this.publishIntervalHours = publishIntervalHours;
    }


    /**
     * Gets the publishDaysOfWeek value for this PublishSet.
     * 
     * @return publishDaysOfWeek
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.DayOfWeek[] getPublishDaysOfWeek() {
        return publishDaysOfWeek;
    }


    /**
     * Sets the publishDaysOfWeek value for this PublishSet.
     * 
     * @param publishDaysOfWeek
     */
    public void setPublishDaysOfWeek(com.hannonhill.www.ws.ns.AssetOperationService.DayOfWeek[] publishDaysOfWeek) {
        this.publishDaysOfWeek = publishDaysOfWeek;
    }


    /**
     * Gets the cronExpression value for this PublishSet.
     * 
     * @return cronExpression
     */
    public java.lang.String getCronExpression() {
        return cronExpression;
    }


    /**
     * Sets the cronExpression value for this PublishSet.
     * 
     * @param cronExpression
     */
    public void setCronExpression(java.lang.String cronExpression) {
        this.cronExpression = cronExpression;
    }


    /**
     * Gets the sendReportToUsers value for this PublishSet.
     * 
     * @return sendReportToUsers
     */
    public java.lang.String getSendReportToUsers() {
        return sendReportToUsers;
    }


    /**
     * Sets the sendReportToUsers value for this PublishSet.
     * 
     * @param sendReportToUsers
     */
    public void setSendReportToUsers(java.lang.String sendReportToUsers) {
        this.sendReportToUsers = sendReportToUsers;
    }


    /**
     * Gets the sendReportToGroups value for this PublishSet.
     * 
     * @return sendReportToGroups
     */
    public java.lang.String getSendReportToGroups() {
        return sendReportToGroups;
    }


    /**
     * Sets the sendReportToGroups value for this PublishSet.
     * 
     * @param sendReportToGroups
     */
    public void setSendReportToGroups(java.lang.String sendReportToGroups) {
        this.sendReportToGroups = sendReportToGroups;
    }


    /**
     * Gets the sendReportOnErrorOnly value for this PublishSet.
     * 
     * @return sendReportOnErrorOnly
     */
    public java.lang.Boolean getSendReportOnErrorOnly() {
        return sendReportOnErrorOnly;
    }


    /**
     * Sets the sendReportOnErrorOnly value for this PublishSet.
     * 
     * @param sendReportOnErrorOnly
     */
    public void setSendReportOnErrorOnly(java.lang.Boolean sendReportOnErrorOnly) {
        this.sendReportOnErrorOnly = sendReportOnErrorOnly;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PublishSet)) return false;
        PublishSet other = (PublishSet) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.files==null && other.getFiles()==null) || 
             (this.files!=null &&
              java.util.Arrays.equals(this.files, other.getFiles()))) &&
            ((this.folders==null && other.getFolders()==null) || 
             (this.folders!=null &&
              java.util.Arrays.equals(this.folders, other.getFolders()))) &&
            ((this.pages==null && other.getPages()==null) || 
             (this.pages!=null &&
              java.util.Arrays.equals(this.pages, other.getPages()))) &&
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
              this.sendReportOnErrorOnly.equals(other.getSendReportOnErrorOnly())));
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
        if (getFiles() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFiles());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFiles(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFolders() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFolders());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFolders(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPages() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPages());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPages(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PublishSet.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "publishSet"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("files");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "files"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "publishableAssetIdentifier"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folders");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "folders"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "publishableAssetIdentifier"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pages");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "pages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "publishableAssetIdentifier"));
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
