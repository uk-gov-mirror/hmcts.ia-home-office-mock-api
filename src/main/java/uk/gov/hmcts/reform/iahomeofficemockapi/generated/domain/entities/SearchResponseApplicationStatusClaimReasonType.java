package uk.gov.hmcts.reform.iahomeofficemockapi.generated.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * Type of reason for claim on application. **Note:** may not be available for any cases
 */
@Schema(description = "Type of reason for claim on application. **Note:** may not be available for any cases")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-07-01T14:15:45.837+01:00[Europe/London]")

public class SearchResponseApplicationStatusClaimReasonType   {
  @JsonProperty("code")
  private String code;

  @JsonProperty("description")
  private String description;

  public SearchResponseApplicationStatusClaimReasonType code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Code for the claim reason type
   * @return code
  */
  @Schema(example = "HUMANRIGHTS", description = "Code for the claim reason type")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public SearchResponseApplicationStatusClaimReasonType description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the claim reason type
   * @return description
  */
  @Schema(example = "Human Rights", description = "Description of the claim reason type")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchResponseApplicationStatusClaimReasonType searchResponseApplicationStatusClaimReasonType = (SearchResponseApplicationStatusClaimReasonType) o;
    return Objects.equals(this.code, searchResponseApplicationStatusClaimReasonType.code) &&
        Objects.equals(this.description, searchResponseApplicationStatusClaimReasonType.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchResponseApplicationStatusClaimReasonType {\n");

    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

