/**
 * Block.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 12, 2007 (02:39:05 EDT) WSDL2Java emitter.
 */

package com.hannonhill.www.ws.ns.AssetOperationService;

public class Block  extends com.hannonhill.www.ws.ns.AssetOperationService.ExpiringAsset  implements java.io.Serializable {
    public Block() {
    }

    public Block(
           java.lang.String id,
           java.lang.String name,
           java.lang.String parentFolderId,
           java.lang.String parentFolderPath,
           java.lang.String path,
           java.util.Calendar lastModifiedDate,
           java.lang.String lastModifiedBy,
           java.util.Calendar createdDate,
           java.lang.String createdBy,
           java.lang.String siteId,
           java.lang.String siteName,
           com.hannonhill.www.ws.ns.AssetOperationService.Metadata metadata,
           java.lang.String metadataSetId,
           java.lang.String metadataSetPath,
           java.lang.String expirationFolderId,
           java.lang.String expirationFolderPath,
           java.lang.Boolean expirationFolderRecycled) {
        super(
            id,
            name,
            parentFolderId,
            parentFolderPath,
            path,
            lastModifiedDate,
            lastModifiedBy,
            createdDate,
            createdBy,
            siteId,
            siteName,
            metadata,
            metadataSetId,
            metadataSetPath,
            expirationFolderId,
            expirationFolderPath,
            expirationFolderRecycled);
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Block)) return false;
        Block other = (Block) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Block.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.hannonhill.com/ws/ns/AssetOperationService", "block"));
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
