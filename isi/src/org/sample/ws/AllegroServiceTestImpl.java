//package org.sample.ws;
//
//import java.io.IOException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
// 
//
//import javax.jws.WebService;
//
//import org.kobjects.base64.Base64;
//import org.ksoap2.SoapEnvelope;
//import org.ksoap2.SoapFault;
//import org.ksoap2.serialization.PropertyInfo;
//import org.ksoap2.serialization.SoapObject;
//import org.ksoap2.serialization.SoapSerializationEnvelope;
//import org.ksoap2.transport.HttpTransportSE;
//import org.ksoap2.transport.Transport;
//import org.xmlpull.v1.XmlPullParserException;
// 
///**
// * Przyklad wywolan metod doQuerySysStatus i doLoginEnc za pomoca frameworka ksoap2-android.
// *  
// * @author Grzegorz Byczynski
// */
//@WebService(targetNamespace = "http://ws.sample.org/", 
//			portName = "AllegroServiceTestImplPort", 
//			serviceName = "AllegroServiceTestImplService",
//			wsdlLocation = "http://ws.sample.org/AllegroServiceTestImplService"
//			)
//public class AllegroServiceTestImpl {
// 
//    private final int soapVersion = SoapEnvelope.VER11;
//    private final String endpointUri = "https://webapi.allegro.pl/service.php";
//    private final String namespace = "https://webapi.allegro.pl/service.php";
// 
////    public static void main(String[] args) throws SoapFault, NoSuchAlgorithmException {
////        AllegroServiceTestImpl allegro = new AllegroServiceTestImpl();
////        String apiKey = "12345678";
////        long versionKey = allegro.doQuerySysStatus(3, 1, apiKey);
////        String sessionHandlePart = allegro.doLogin("login", Base64.encode(MessageDigest.getInstance("SHA-256").digest("password".getBytes())), 1, versionKey, apiKey);
////        System.out.println("Version key: " + versionKey + ", sessionHandlePart: " + sessionHandlePart);
////    }
// 
//    public long doQuerySysStatus() throws SoapFault {
////    	public long doQuerySysStatus(int service, int country, String apiKey) throws SoapFault {
//        PropertyInfo sysvar = createPropertyInfo("sysvar", 3);
//        PropertyInfo countryId = createPropertyInfo("countryId", 1);
//        PropertyInfo webapiKey = createPropertyInfo("webapiKey", "WEB_API_KEY!");
// 
//        SoapObject response = this.sendSoap("DoQuerySysStatusRequest", "#doQuerySysStatus", sysvar, countryId, webapiKey);
//        return Long.parseLong(response.getPropertyAsString("verKey"));
//    }
// 
////    public String doLogin(String login, String passwordHash, int country, long versionKey, String apiKey) throws SoapFault {
////        PropertyInfo userLogin = createPropertyInfo("userLogin", login);
////        PropertyInfo userHashPassword = createPropertyInfo("userHashPassword", passwordHash);
////        PropertyInfo countryCode = createPropertyInfo("countryCode", country);
////        PropertyInfo webapiKey = createPropertyInfo("webapiKey", apiKey);
////        PropertyInfo localVersion = createPropertyInfo("localVersion", versionKey);
//// 
////        SoapObject response = this.sendSoap("DoLoginEncRequest", "#doLoginEnc", userLogin, userHashPassword, countryCode, webapiKey, localVersion);
////        return response.getPropertyAsString("sessionHandlePart");
////    }
// 
//    protected SoapObject sendSoap(String methodName, String soapAction, PropertyInfo... properties) throws SoapFault {
//        SoapObject request = new SoapObject(this.namespace, methodName);
//        for (PropertyInfo property : properties) {
//            request.addPropertyIfValue(property);
//        }
// 
//        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(this.soapVersion);
//        envelope.implicitTypes = true; // removes i:type attribute for SimpleTypes
//        envelope.setAddAdornments(false); // removes id & c:root attributes
//        envelope.setOutputSoapObject(request);
// 
//        Transport transport = new HttpTransportSE(this.endpointUri);
//        try {
//            transport.call(soapAction, envelope);
//        } catch (XmlPullParserException | IOException e) {
//            throw new IllegalStateException(e.getMessage(), e);
//        }
// 
//        if (envelope.bodyIn instanceof SoapFault) {
//            throw (SoapFault) envelope.bodyIn;
//        }
// 
//        return (SoapObject) envelope.bodyIn;
//    }
// 
//    protected PropertyInfo createPropertyInfo(String key, Object value) {
//        PropertyInfo property = new PropertyInfo();
//        property.setName(key);
//        property.setValue(value);
//        property.setNamespace(this.namespace);
//        return property;
//    }
//}
//
