package com.revature.services;

public class LibraryServiceProxy implements com.revature.services.LibraryService {
  private String _endpoint = null;
  private com.revature.services.LibraryService libraryService = null;
  
  public LibraryServiceProxy() {
    _initLibraryServiceProxy();
  }
  
  public LibraryServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initLibraryServiceProxy();
  }
  
  private void _initLibraryServiceProxy() {
    try {
      libraryService = (new com.revature.services.LibraryServiceImplServiceLocator()).getLibraryServiceImplPort();
      if (libraryService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)libraryService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)libraryService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (libraryService != null)
      ((javax.xml.rpc.Stub)libraryService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.revature.services.LibraryService getLibraryService() {
    if (libraryService == null)
      _initLibraryServiceProxy();
    return libraryService;
  }
  
  public java.lang.String addBook(com.revature.services.Book arg0) throws java.rmi.RemoteException, com.revature.services.LibraryFullException{
    if (libraryService == null)
      _initLibraryServiceProxy();
    return libraryService.addBook(arg0);
  }
  
  public com.revature.services.Book[] getAllBooks() throws java.rmi.RemoteException{
    if (libraryService == null)
      _initLibraryServiceProxy();
    return libraryService.getAllBooks();
  }
  
  
}