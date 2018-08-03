package com.revature.services;

public class DealershipServiceProxy implements com.revature.services.DealershipService {
  private String _endpoint = null;
  private com.revature.services.DealershipService dealershipService = null;
  
  public DealershipServiceProxy() {
    _initDealershipServiceProxy();
  }
  
  public DealershipServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initDealershipServiceProxy();
  }
  
  private void _initDealershipServiceProxy() {
    try {
      dealershipService = (new com.revature.services.DealershipServiceImplServiceLocator()).getDealershipServiceImplPort();
      if (dealershipService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dealershipService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dealershipService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dealershipService != null)
      ((javax.xml.rpc.Stub)dealershipService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.revature.services.DealershipService getDealershipService() {
    if (dealershipService == null)
      _initDealershipServiceProxy();
    return dealershipService;
  }
  
  public java.lang.String addCar(com.revature.services.Car arg0) throws java.rmi.RemoteException, com.revature.services.LotFullException{
    if (dealershipService == null)
      _initDealershipServiceProxy();
    return dealershipService.addCar(arg0);
  }
  
  public com.revature.services.Car[] getAllCars() throws java.rmi.RemoteException{
    if (dealershipService == null)
      _initDealershipServiceProxy();
    return dealershipService.getAllCars();
  }
  
  
}