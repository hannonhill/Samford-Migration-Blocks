/**
 * Operation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 12, 2007 (02:39:05 EDT) WSDL2Java emitter.
 */

package com.hannonhill.www.ws.ns.AssetOperationService;

public class Operation  implements java.io.Serializable {
    private com.hannonhill.www.ws.ns.AssetOperationService.Create create;

    private com.hannonhill.www.ws.ns.AssetOperationService.Delete delete;

    private com.hannonhill.www.ws.ns.AssetOperationService.Edit edit;

    private com.hannonhill.www.ws.ns.AssetOperationService.Move move;

    private com.hannonhill.www.ws.ns.AssetOperationService.Publish publish;

    private com.hannonhill.www.ws.ns.AssetOperationService.Read read;

    private com.hannonhill.www.ws.ns.AssetOperationService.ReadAccessRights readAccessRights;

    private com.hannonhill.www.ws.ns.AssetOperationService.EditAccessRights editAccessRights;

    private com.hannonhill.www.ws.ns.AssetOperationService.ReadWorkflowSettings readWorkflowSettings;

    private com.hannonhill.www.ws.ns.AssetOperationService.EditWorkflowSettings editWorkflowSettings;

    private com.hannonhill.www.ws.ns.AssetOperationService.ListSubscribers listSubscribers;

    private com.hannonhill.www.ws.ns.AssetOperationService.CheckOut checkOut;

    private com.hannonhill.www.ws.ns.AssetOperationService.CheckIn checkIn;

    private com.hannonhill.www.ws.ns.AssetOperationService.Copy copy;

    private com.hannonhill.www.ws.ns.AssetOperationService.SiteCopy siteCopy;

    public Operation() {
    }

    public Operation(
           com.hannonhill.www.ws.ns.AssetOperationService.Create create,
           com.hannonhill.www.ws.ns.AssetOperationService.Delete delete,
           com.hannonhill.www.ws.ns.AssetOperationService.Edit edit,
           com.hannonhill.www.ws.ns.AssetOperationService.Move move,
           com.hannonhill.www.ws.ns.AssetOperationService.Publish publish,
           com.hannonhill.www.ws.ns.AssetOperationService.Read read,
           com.hannonhill.www.ws.ns.AssetOperationService.ReadAccessRights readAccessRights,
           com.hannonhill.www.ws.ns.AssetOperationService.EditAccessRights editAccessRights,
           com.hannonhill.www.ws.ns.AssetOperationService.ReadWorkflowSettings readWorkflowSettings,
           com.hannonhill.www.ws.ns.AssetOperationService.EditWorkflowSettings editWorkflowSettings,
           com.hannonhill.www.ws.ns.AssetOperationService.ListSubscribers listSubscribers,
           com.hannonhill.www.ws.ns.AssetOperationService.CheckOut checkOut,
           com.hannonhill.www.ws.ns.AssetOperationService.CheckIn checkIn,
           com.hannonhill.www.ws.ns.AssetOperationService.Copy copy,
           com.hannonhill.www.ws.ns.AssetOperationService.SiteCopy siteCopy) {
           this.create = create;
           this.delete = delete;
           this.edit = edit;
           this.move = move;
           this.publish = publish;
           this.read = read;
           this.readAccessRights = readAccessRights;
           this.editAccessRights = editAccessRights;
           this.readWorkflowSettings = readWorkflowSettings;
           this.editWorkflowSettings = editWorkflowSettings;
           this.listSubscribers = listSubscribers;
           this.checkOut = checkOut;
           this.checkIn = checkIn;
           this.copy = copy;
           this.siteCopy = siteCopy;
    }


    /**
     * Gets the create value for this Operation.
     * 
     * @return create
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.Create getCreate() {
        return create;
    }


    /**
     * Sets the create value for this Operation.
     * 
     * @param create
     */
    public void setCreate(com.hannonhill.www.ws.ns.AssetOperationService.Create create) {
        this.create = create;
    }


    /**
     * Gets the delete value for this Operation.
     * 
     * @return delete
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.Delete getDelete() {
        return delete;
    }


    /**
     * Sets the delete value for this Operation.
     * 
     * @param delete
     */
    public void setDelete(com.hannonhill.www.ws.ns.AssetOperationService.Delete delete) {
        this.delete = delete;
    }


    /**
     * Gets the edit value for this Operation.
     * 
     * @return edit
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.Edit getEdit() {
        return edit;
    }


    /**
     * Sets the edit value for this Operation.
     * 
     * @param edit
     */
    public void setEdit(com.hannonhill.www.ws.ns.AssetOperationService.Edit edit) {
        this.edit = edit;
    }


    /**
     * Gets the move value for this Operation.
     * 
     * @return move
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.Move getMove() {
        return move;
    }


    /**
     * Sets the move value for this Operation.
     * 
     * @param move
     */
    public void setMove(com.hannonhill.www.ws.ns.AssetOperationService.Move move) {
        this.move = move;
    }


    /**
     * Gets the publish value for this Operation.
     * 
     * @return publish
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.Publish getPublish() {
        return publish;
    }


    /**
     * Sets the publish value for this Operation.
     * 
     * @param publish
     */
    public void setPublish(com.hannonhill.www.ws.ns.AssetOperationService.Publish publish) {
        this.publish = publish;
    }


    /**
     * Gets the read value for this Operation.
     * 
     * @return read
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.Read getRead() {
        return read;
    }


    /**
     * Sets the read value for this Operation.
     * 
     * @param read
     */
    public void setRead(com.hannonhill.www.ws.ns.AssetOperationService.Read read) {
        this.read = read;
    }


    /**
     * Gets the readAccessRights value for this Operation.
     * 
     * @return readAccessRights
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.ReadAccessRights getReadAccessRights() {
        return readAccessRights;
    }


    /**
     * Sets the readAccessRights value for this Operation.
     * 
     * @param readAccessRights
     */
    public void setReadAccessRights(com.hannonhill.www.ws.ns.AssetOperationService.ReadAccessRights readAccessRights) {
        this.readAccessRights = readAccessRights;
    }


    /**
     * Gets the editAccessRights value for this Operation.
     * 
     * @return editAccessRights
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.EditAccessRights getEditAccessRights() {
        return editAccessRights;
    }


    /**
     * Sets the editAccessRights value for this Operation.
     * 
     * @param editAccessRights
     */
    public void setEditAccessRights(com.hannonhill.www.ws.ns.AssetOperationService.EditAccessRights editAccessRights) {
        this.editAccessRights = editAccessRights;
    }


    /**
     * Gets the readWorkflowSettings value for this Operation.
     * 
     * @return readWorkflowSettings
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.ReadWorkflowSettings getReadWorkflowSettings() {
        return readWorkflowSettings;
    }


    /**
     * Sets the readWorkflowSettings value for this Operation.
     * 
     * @param readWorkflowSettings
     */
    public void setReadWorkflowSettings(com.hannonhill.www.ws.ns.AssetOperationService.ReadWorkflowSettings readWorkflowSettings) {
        this.readWorkflowSettings = readWorkflowSettings;
    }


    /**
     * Gets the editWorkflowSettings value for this Operation.
     * 
     * @return editWorkflowSettings
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.EditWorkflowSettings getEditWorkflowSettings() {
        return editWorkflowSettings;
    }


    /**
     * Sets the editWorkflowSettings value for this Operation.
     * 
     * @param editWorkflowSettings
     */
    public void setEditWorkflowSettings(com.hannonhill.www.ws.ns.AssetOperationService.EditWorkflowSettings editWorkflowSettings) {
        this.editWorkflowSettings = editWorkflowSettings;
    }


    /**
     * Gets the listSubscribers value for this Operation.
     * 
     * @return listSubscribers
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.ListSubscribers getListSubscribers() {
        return listSubscribers;
    }


    /**
     * Sets the listSubscribers value for this Operation.
     * 
     * @param listSubscribers
     */
    public void setListSubscribers(com.hannonhill.www.ws.ns.AssetOperationService.ListSubscribers listSubscribers) {
        this.listSubscribers = listSubscribers;
    }


    /**
     * Gets the checkOut value for this Operation.
     * 
     * @return checkOut
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.CheckOut getCheckOut() {
        return checkOut;
    }


    /**
     * Sets the checkOut value for this Operation.
     * 
     * @param checkOut
     */
    public void setCheckOut(com.hannonhill.www.ws.ns.AssetOperationService.CheckOut checkOut) {
        this.checkOut = checkOut;
    }


    /**
     * Gets the checkIn value for this Operation.
     * 
     * @return checkIn
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.CheckIn getCheckIn() {
        return checkIn;
    }


    /**
     * Sets the checkIn value for this Operation.
     * 
     * @param checkIn
     */
    public void setCheckIn(com.hannonhill.www.ws.ns.AssetOperationService.CheckIn checkIn) {
        this.checkIn = checkIn;
    }


    /**
     * Gets the copy value for this Operation.
     * 
     * @return copy
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.Copy getCopy() {
        return copy;
    }


    /**
     * Sets the copy value for this Operation.
     * 
     * @param copy
     */
    public void setCopy(com.hannonhill.www.ws.ns.AssetOperationService.Copy copy) {
        this.copy = copy;
    }


    /**
     * Gets the siteCopy value for this Operation.
     * 
     * @return siteCopy
     */
    public com.hannonhill.www.ws.ns.AssetOperationService.SiteCopy getSiteCopy() {
        return siteCopy;
    }


    /**
     * Sets the siteCopy value for this Operation.
     * 
     * @param siteCopy
     */
    public void setSiteCopy(com.hannonhill.www.ws.ns.AssetOperationService.SiteCopy siteCopy) {
        this.siteCopy = siteCopy;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Operation)) return false;
        Operation other = (Operation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.create==null && other.getCreate()==null) || 
             (this.create!=null &&
              this.create.equals(other.getCreate()))) &&
            ((this.delete==null && other.getDelete()==null) || 
             (this.delete!=null &&
              this.delete.equals(other.getDelete()))) &&
            ((this.edit==null && other.getEdit()==null) || 
             (this.edit!=null &&
              this.edit.equals(other.getEdit()))) &&
            ((this.move==null && other.getMove()==null) || 
             (this.move!=null &&
              this.move.equals(other.getMove()))) &&
            ((this.publish==null && other.getPublish()==null) || 
             (this.publish!=null &&
              this.publish.equals(other.getPublish()))) &&
            ((this.read==null && other.getRead()==null) || 
             (this.read!=null &&
              this.read.equals(other.getRead()))) &&
            ((this.readAccessRights==null && other.getReadAccessRights()==null) || 
             (this.readAccessRights!=null &&
              this.readAccessRights.equals(other.getReadAccessRights()))) &&
            ((this.editAccessRights==null && other.getEditAccessRights()==null) || 
             (this.editAccessRights!=null &&
              this.editAccessRights.equals(other.getEditAccessRights()))) &&
            ((this.readWorkflowSettings==null && other.getReadWorkflowSettings()==null) || 
             (this.readWorkflowSettings!=null &&
              this.readWorkflowSettings.equals(other.getReadWorkflowSettings()))) &&
            ((this.editWorkflowSettings==null && other.getEditWorkflowSettings()==null) || 
             (this.editWorkflowSettings!=null &&
              this.editWorkflowSettings.equals(other.getEditWorkflowSettings()))) &&
            ((this.listSubscribers==null && other.getListSubscribers()==null) || 
             (this.listSubscribers!=null &&
              this.listSubscribers.equals(other.getListSubscribers()))) &&
            ((this.checkOut==null && other.getCheckOut()==null) || 
             (this.checkOut!=null &&
              this.checkOut.equals(other.getCheckOut()))) &&
            ((this.checkIn==null && other.getCheckIn()==null) || 
             (this.checkIn!=null &&
              this.checkIn.equals(other.getCheckIn()))) &&
            ((this.copy==null && other.getCopy()==null) || 
             (this.copy!=null &&
              this.copy.equals(other.getCopy()))) &&
            ((this.siteCopy==null && other.getSiteCopy()==null) || 
             (this.siteCopy!=null &&
              this.siteCopy.equals(other.getSiteCopy())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCreate() != null) {
            _hashCode += getCreate().hashCode();
        }
        if (getDelete() != null) {
            _hashCode += getDelete().hashCode();
        }
        if (getEdit() != null) {
            _hashCode += getEdit().hashCode();
        }
        if (getMove() != null) {
            _hashCode += getMove().hashCode();
        }
        if (getPublish() != null) {
            _hashCode += getPublish().hashCode();
        }
        if (getRead() != null) {
            _hashCode += getRead().hashCode();
        }
        if (getReadAccessRights() != null) {
            _hashCode += getReadAccessRights().hashCode();
        }
        if (getEditAccessRights() != null) {
            _hashCode += getEditAccessRights().hashCode();
        }
        if (getReadWorkflowSettings() != null) {
            _hashCode += getReadWorkflowSettings().hashCode();
        }
        if (getEditWorkflowSettings() != null) {
            _hashCode += getEditWorkflowSettings().hashCode();
        }
        if (getListSubscribers() != null) {
            _hashCode += getListSubscribers().hashCode();
        }
        if (getCheckOut() != null) {
            _hashCode += getCheckOut().hashCode();
        }
        if (getCheckIn() != null) {
            _hashCode += getCheckIn().hashCode();
        }
        if (getCopy() != null) {
            _hashCode += getCopy().hashCode();
        }
        if (getSiteCopy() != null) {
            _hashCode += getSiteCopy().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Operation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "operation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("create");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "create"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "create"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("delete");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "delete"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "delete"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("edit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "edit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "edit"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("move");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "move"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "move"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publish");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "publish"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "publish"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("read");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "read"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "read"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("readAccessRights");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "readAccessRights"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "readAccessRights"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editAccessRights");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "editAccessRights"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "editAccessRights"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("readWorkflowSettings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "readWorkflowSettings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "readWorkflowSettings"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editWorkflowSettings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "editWorkflowSettings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "editWorkflowSettings"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listSubscribers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "listSubscribers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "listSubscribers"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkOut");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "checkOut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "checkOut"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkIn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "checkIn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "checkIn"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("copy");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "copy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "copy"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siteCopy");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "siteCopy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "siteCopy"));
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
