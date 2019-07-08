package ca.jrvs.apps.twitter.example;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "reportDate",
        "grossProfit",
        "costOfRevenue",
        "operatingRevenue",
        "totalRevenue",
        "operatingIncome",
        "netIncome"
})
public class Financial {

    @JsonProperty("reportDate")
    private String reportDate;
    @JsonProperty("grossProfit")
    private Integer grossProfit;
    @JsonProperty("costOfRevenue")
    private Integer costOfRevenue;
    @JsonProperty("operatingRevenue")
    private Integer operatingRevenue;
    @JsonProperty("totalRevenue")
    private Integer totalRevenue;
    @JsonProperty("operatingIncome")
    private Integer operatingIncome;
    @JsonProperty("netIncome")
    private Integer netIncome;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("reportDate")
    public String getReportDate() {
        return reportDate;
    }

    @JsonProperty("reportDate")
    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    @JsonProperty("grossProfit")
    public Integer getGrossProfit() {
        return grossProfit;
    }

    @JsonProperty("grossProfit")
    public void setGrossProfit(Integer grossProfit) {
        this.grossProfit = grossProfit;
    }

    @JsonProperty("costOfRevenue")
    public Integer getCostOfRevenue() {
        return costOfRevenue;
    }

    @JsonProperty("costOfRevenue")
    public void setCostOfRevenue(Integer costOfRevenue) {
        this.costOfRevenue = costOfRevenue;
    }

    @JsonProperty("operatingRevenue")
    public Integer getOperatingRevenue() {
        return operatingRevenue;
    }

    @JsonProperty("operatingRevenue")
    public void setOperatingRevenue(Integer operatingRevenue) {
        this.operatingRevenue = operatingRevenue;
    }

    @JsonProperty("totalRevenue")
    public Integer getTotalRevenue() {
        return totalRevenue;
    }

    @JsonProperty("totalRevenue")
    public void setTotalRevenue(Integer totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    @JsonProperty("operatingIncome")
    public Integer getOperatingIncome() {
        return operatingIncome;
    }

    @JsonProperty("operatingIncome")
    public void setOperatingIncome(Integer operatingIncome) {
        this.operatingIncome = operatingIncome;
    }

    @JsonProperty("netIncome")
    public Integer getNetIncome() {
        return netIncome;
    }

    @JsonProperty("netIncome")
    public void setNetIncome(Integer netIncome) {
        this.netIncome = netIncome;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}