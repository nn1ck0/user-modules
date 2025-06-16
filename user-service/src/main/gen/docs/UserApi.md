# UserApi

All URIs are relative to *http://localhost:8081*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1CreatePost**](UserApi.md#apiV1CreatePost) | **POST** /api/v1/create | Create User |
| [**apiV1IdDelete**](UserApi.md#apiV1IdDelete) | **DELETE** /api/v1/{id} | Delete User by id |
| [**apiV1IdGet**](UserApi.md#apiV1IdGet) | **GET** /api/v1/{id} | Get User by id |
| [**apiV1UpdatePut**](UserApi.md#apiV1UpdatePut) | **PUT** /api/v1/update | Update User |


<a id="apiV1CreatePost"></a>
# **apiV1CreatePost**
> UserDto apiV1CreatePost(userDto)

Create User

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8081");

    UserApi apiInstance = new UserApi(defaultClient);
    UserDto userDto = new UserDto(); // UserDto | 
    try {
      UserDto result = apiInstance.apiV1CreatePost(userDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApi#apiV1CreatePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userDto** | [**UserDto**](UserDto.md)|  | |

### Return type

[**UserDto**](UserDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK! User is created |  -  |
| **502** | Server offline |  -  |

<a id="apiV1IdDelete"></a>
# **apiV1IdDelete**
> apiV1IdDelete(id)

Delete User by id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8081");

    UserApi apiInstance = new UserApi(defaultClient);
    Long id = 1L; // Long | 
    try {
      apiInstance.apiV1IdDelete(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApi#apiV1IdDelete");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK! User was deleted |  -  |
| **404** | User was not found |  -  |

<a id="apiV1IdGet"></a>
# **apiV1IdGet**
> UserDto apiV1IdGet(id)

Get User by id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8081");

    UserApi apiInstance = new UserApi(defaultClient);
    Long id = 1L; // Long | 
    try {
      UserDto result = apiInstance.apiV1IdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApi#apiV1IdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**|  | |

### Return type

[**UserDto**](UserDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK! User is found |  -  |
| **404** | User was not found |  -  |

<a id="apiV1UpdatePut"></a>
# **apiV1UpdatePut**
> UserDto apiV1UpdatePut(userDto)

Update User

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8081");

    UserApi apiInstance = new UserApi(defaultClient);
    UserDto userDto = new UserDto(); // UserDto | 
    try {
      UserDto result = apiInstance.apiV1UpdatePut(userDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApi#apiV1UpdatePut");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userDto** | [**UserDto**](UserDto.md)|  | |

### Return type

[**UserDto**](UserDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK! User is updated |  -  |
| **502** | Server offline |  -  |

