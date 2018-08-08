/**
 * LibraryServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.revature.services;

public class LibraryServiceImplServiceLocator extends org.apache.axis.client.Service implements com.revature.services.LibraryServiceImplService {

    public LibraryServiceImplServiceLocator() {
    }


    public LibraryServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LibraryServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LibraryServiceImplPort
    private java.lang.String LibraryServiceImplPort_address = "http://localhost:8080/soap-service-demo/library";

    public java.lang.String getLibraryServiceImplPortAddress() {
        return LibraryServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LibraryServiceImplPortWSDDServiceName = "LibraryServiceImplPort";

    public java.lang.String getLibraryServiceImplPortWSDDServiceName() {
        return LibraryServiceImplPortWSDDServiceName;
    }

    public void setLibraryServiceImplPortWSDDServiceName(java.lang.String name) {
        LibraryServiceImplPortWSDDServiceName = name;
    }

    public com.revature.services.LibraryService getLibraryServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LibraryServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLibraryServiceImplPort(endpoint);
    }

    public com.revature.services.LibraryService getLibraryServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.revature.services.LibraryServiceImplServiceSoapBindingStub _stub = new com.revature.services.LibraryServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getLibraryServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLibraryServiceImplPortEndpointAddress(java.lang.String address) {
        LibraryServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.revature.services.LibraryService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.revature.services.LibraryServiceImplServiceSoapBindingStub _stub = new com.revature.services.LibraryServiceImplServiceSoapBindingStub(new java.net.URL(LibraryServiceImplPort_address), this);
                _stub.setPortName(getLibraryServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("LibraryServiceImplPort".equals(inputPortName)) {
            return getLibraryServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services.revature.com/", "LibraryServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services.revature.com/", "LibraryServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LibraryServiceImplPort".equals(portName)) {
            setLibraryServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
