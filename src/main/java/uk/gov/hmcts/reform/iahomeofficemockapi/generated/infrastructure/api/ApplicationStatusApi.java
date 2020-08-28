/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.0).
 * https://openapi-generator.tech Do not edit the class manually.
 */
package uk.gov.hmcts.reform.iahomeofficemockapi.generated.infrastructure.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import javax.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
import uk.gov.hmcts.reform.iahomeofficemockapi.generated.domain.entities.SearchErrorResponse;
import uk.gov.hmcts.reform.iahomeofficemockapi.generated.domain.entities.SearchParameters;
import uk.gov.hmcts.reform.iahomeofficemockapi.generated.domain.entities.SearchResponse;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-07-01T14:15:45.837+01:00[Europe/London]")

@Validated
@Api(value = "applicationStatus", description = "the applicationStatus API")
public interface ApplicationStatusApi {

    static final Logger log = LoggerFactory.getLogger(ApplicationStatusApi.class);

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /applicationStatus/getBySearchParameters : Finds applications by search parameters (initially one).
     *
     * @param searchParameters  (required)
     * @return OK (status code 200)
     *         or Invalid status value (status code 400)
     */
    @ApiOperation(value = "Finds applications by search parameters (initially one).", nickname = "applicationStatusGetBySearchParametersPost", notes = "", response = SearchResponse.class, tags = {})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = SearchResponse.class),
        @ApiResponse(code = 400, message = "Invalid status value", response = SearchErrorResponse.class)})
    @RequestMapping(value = "/applicationStatus/getBySearchParameters",
        produces = {"application/json"},
        consumes = {"application/json"},
        method = RequestMethod.POST)
    default ResponseEntity<SearchResponse> applicationStatusGetBySearchParametersPost(
        @ApiParam(value = "", required = true) @Valid @RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken,
        @ApiParam(value = "", required = true) @Valid @RequestBody SearchParameters searchParameters) {

        final Optional<NativeWebRequest> nativeWebRequest = getRequest();
        if (nativeWebRequest.isPresent()) {

            final NativeWebRequest request = nativeWebRequest.get();

            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                    log.info("/applicationStatus/getBySearchParameters nativeWebRequest->return mock response");

                    final String documentReference = searchParameters.getSearchParams().get(0).getSpValue();

                    if (documentReference.equalsIgnoreCase("1212/009900362015")
                        || documentReference.equalsIgnoreCase("2/032323")) {
                        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                    }

                    String responseJson = null;
                    try {
                        responseJson = getResponseJson(documentReference);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    String exampleString = "";
                    ApiUtil.setExampleResponse(request, "application/json", responseJson);
                    break;
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST /token : returns JWT access_token for given client_id and client_secret..
     *
     * @param searchParameters  (required)
     * @return OK (status code 200)
     *         or Invalid status value (status code 400)
     */
    @ApiOperation(value = "get acces token.", nickname = "tokenPost", notes = "", response = String.class, tags = {})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = String.class)
    })
    @RequestMapping(value = "/token",
        produces = {"application/json"},
        consumes = {"application/x-www-form-urlencoded"},
        method = RequestMethod.POST)
    default ResponseEntity<SearchResponse> tokenPost(
        @ApiParam(value = "", required = true) @Valid @RequestBody MultiValueMap<String, String> requestBody) {

        getRequest().ifPresent(request -> {
            log.info("/token request->return mock response");

            String jwtToken = "{"
                + "\"access_token\": \"some_access_token\","
                + "\"expires_in\": 300,"
                + "\"token_type\": \"bearer\","
                + "\"not-before-policy\": 0,"
                + "\"scope\": \"email profile\""
                + "}";
            ApiUtil.setExampleResponse(request, "application/json", jwtToken);
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @NotNull
    private String getResponseJson(String homeOfficeReference) throws IOException {

        String responseJsonFile;

        switch (homeOfficeReference) {
            case "1212-0099-0061-7075": // Valid UAN reference
                responseJsonFile = "ho-api_get-by-search-params_200-valid_response-01.json";
                break;
            case "1212-0099-0062-8083":
                responseJsonFile = "ho-api_get-by-serach-params_200_valid-response-02.json";
                break;
            case "020639760": // CID reference response
                responseJsonFile = "ho-api_get-by-search-params_200-valid_response-01.json";
                break;
            case "020651434": // CID reference - not Asylum case response
                responseJsonFile = "ho-api_get-by-search-params_200-valid_response-01.json";
                break;
            case "1212-0099-0029-3029": // Valid UAN - no data found
                responseJsonFile = "ho_api_get-by-search-params_200_no-data-found-uan-ref.json";
                break;
            case "123123123": // Valid CID - no data found
                responseJsonFile = "ho_api_get-by-search-params_200_no-data-found-uan-ref.json";
                break;
            default:
                throw new IOException("Invalid home office reference : " + homeOfficeReference);
        }

        final File hoSearchResponseResourceFile
            = ResourceUtils.getFile("classpath:" + responseJsonFile);

        return new String(Files.readAllBytes(hoSearchResponseResourceFile.toPath()));
    }

}
