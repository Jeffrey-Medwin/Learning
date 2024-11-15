package com.rest.restlearning.client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONObject;

public class ClientService {
	public static void main(String[] args) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/restlearning/employee/getall");
        httpGet.setHeader("Accept", "application/json");
        
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
        	int status = response.getStatusLine().getStatusCode();
        	System.out.println("Status code: " + status);
        	
        	if (status == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());
                JSONObject jsonObject = new JSONObject(responseBody);
                
                if (jsonObject.has("employee")) {
                	Object object = jsonObject.getJSONObject("employee");
                	JSONObject employeJsonObject = (JSONObject) object; 
					
                	if (object instanceof JSONObject) {
                		System.out.println("Employee Details");
    					System.out.println("------------------");
    					System.out.println("ID: " + employeJsonObject.getInt("id"));
    					System.out.println("Name: " + employeJsonObject.getString("name"));
    					System.out.println("Salary: " + employeJsonObject.getDouble("salary"));
					}
				}
            } else {
                System.out.println("Request failed with status code: " + status);
            }
        } catch (Exception exception) {
			// TODO: handle exception
		}
	}
}
