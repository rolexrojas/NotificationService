package com.gcs.deoxys.types;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionApiResponseDTO {


    @JsonProperty("Success")
    private String Success;

    @JsonProperty("ResponseMessage")
    private String ResponseMessage;


    public String getSuccess() {
        return Success;
    }

    public void setSuccess(String success) {
        Success = success;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        ResponseMessage = responseMessage;
    }

    public String toString()
    {

        return "Success: " +
                this.getSuccess() +
                "  Response: " +
                this.getResponseMessage();
    }
}
