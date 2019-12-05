package br.ufsc.das.discovery.advance;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.uddi.api_v3.AccessPoint;
import org.uddi.api_v3.BindingTemplate;
import org.uddi.api_v3.BusinessService;
import org.uddi.api_v3.CategoryBag;
import org.uddi.api_v3.FindService;
import org.uddi.api_v3.GetServiceDetail;
import org.uddi.api_v3.KeyedReference;
import org.uddi.api_v3.ServiceDetail;
import org.uddi.api_v3.ServiceInfo;
import org.uddi.api_v3.ServiceList;
import org.uddi.v3_service.UDDIInquiryPortType;

//import com.sun.istack.internal.logging.Logger;

public abstract class ServiceDiscoveryHelper {

	//private static final Logger logger = Logger.getLogger(ServiceDiscoveryHelper.class);

	private static final UDDIAccessor uddi = new UDDIAccessor();

	public static Result discoverServiceEndpoint(String serviceCategory,String KindofService) throws Exception {

		UDDIInquiryPortType inquiryService = uddi.getInquiryService();

		FindService findServiceRequest = new FindService();

		CategoryBag categoryBag = new CategoryBag();

		KeyedReference keyedReference = new KeyedReference();
		keyedReference.setTModelKey("uddi:das.ufsc.br:servicecategory");
		keyedReference.setKeyName("das.ufsc.br:servicecategory");
		keyedReference.setKeyValue(serviceCategory);

		categoryBag.getKeyedReference().add(keyedReference);

		findServiceRequest.setCategoryBag(categoryBag);

		ServiceList result = inquiryService.findService(findServiceRequest);

		List<ServiceInfo> servicesInfo = result.getServiceInfos() != null ? result.getServiceInfos().getServiceInfo()
				: Collections.emptyList();

		//logger.info("Found " + servicesInfo.size() + " service(s) for " + serviceCategory);

		if (servicesInfo.isEmpty())
			throw new RuntimeException("There is no service available for " + serviceCategory);

		Collection<String> serviceKeys = new HashSet<String>();

		for (ServiceInfo s : servicesInfo) {
			serviceKeys.add(s.getServiceKey());
		}

		// Getting details of services
		GetServiceDetail gsd = new GetServiceDetail();

		gsd.getServiceKey().addAll(serviceKeys);

		ServiceDetail serviceDetail = inquiryService.getServiceDetail(gsd);

		List<BusinessService> services = serviceDetail.getBusinessService();

		// TODO: sort services by some criteria (ex. QoS attributes modeled as
		// keyedReferences in categoryBag)

		services = Collections.singletonList(services.get(new Random().nextInt(services.size())));

		for (BusinessService service : services) {

			String serviceKey = service.getServiceKey();

			CategoryBag serviceCategoryBag = service.getCategoryBag();

			if (serviceCategoryBag != null) {

				StringBuilder sb = new StringBuilder();

				for (KeyedReference k : serviceCategoryBag.getKeyedReference()) {
					sb.append("\ttModelKey=" + k.getTModelKey() + ", keyName=" + k.getKeyName() + ", keyValue="
							+ k.getKeyValue() + "\n");
				}

				//logger.info("Information for serviceKey=" + serviceKey + "\n" + sb);
			}

			for (BindingTemplate b : service.getBindingTemplates().getBindingTemplate()) {

				AccessPoint acessPoint = b.getAccessPoint();

				if (acessPoint.getUseType() != null && acessPoint.getUseType().equalsIgnoreCase("endpoint")) {

					String endpoint = b.getAccessPoint().getValue();

					//logger.info(	"Returning endpoint " + endpoint + " of serviceKey=" + serviceKey + ", serviceCategory="
					//				+ serviceCategory);
					
					Result ended = new Result();
					
					
					
					//return endpoint.substring(endpoint.indexOf("://") + 3);
					
					if(KindofService.equals("REST"))
					{   
						String Stringendpoint=endpoint.substring(endpoint.indexOf("://") + 3);
					
						String temporal[] = Stringendpoint.split("");
						
						int count = temporal.length;
						String HOST="";
						String PORT="";
						String SERVICE="";
						boolean first=false;
						boolean second=false;
						for(int n=0;n<count;n++)
						{
							
							if(temporal[n].equals(":") && !first) first=true;
							else if(temporal[n].equals("/") && !second) second=true;
							
							if(!first)
							{
								HOST=HOST+temporal[n];
							}
							else if(!second )
							{
								
								if(!temporal[n].equals(":"))PORT=PORT+temporal[n];
								
							}
							else 
							{
								SERVICE=SERVICE+temporal[n];
							}
							
						}
						ended.setHost(HOST);
						ended.setPath(SERVICE);
						ended.setPort(PORT);
						return ended;
						
						
					}
					if(KindofService.equals("SOAP"))
					{

						ended.setHost(endpoint.substring(endpoint.indexOf("://") + 3));
						
						return ended;
					}

				
				}
			}
		}

		throw new RuntimeException("There is no service binding available for " + serviceCategory);
	}
}
