package com.example.dataentryproject.base.dto;

/**
 * Response implements an application to have custom response.
 *
 * @author vishal.jain
 * @since 03/07/2018.
 */
public class Response implements Cloneable {

  private Integer code; // HTTP Status Code
  private String message; // Response Message (Success, Error , Failure)
  private Object data; // Data to be returned

  /**
   * This is parameterized constructor to create object with code, message and data.
   *
   * @param code
   *          Integer value of HTTP Status
   * @param message
   *          String value of response message
   * @param data
   *          Object to be return in response
   */
  public Response(Integer code, String message, Object data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  /**
   * This method is used to retrieve the HTTP Status Code.
   *
   * @return Code Integer value of HTTP Status
   */
  public Integer getCode() {
    return code;
  }

  /**
   * This method is used to set the HTTP Status Code.
   *
   * @param code
   *          Integer value of HTTP Status
   */
  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * This method is used to retrieve the response message.
   *
   * @return message String value
   */
  public String getMessage() {
    return message;
  }

  /**
   * This method is used to set the response message like "Success, Failure".
   *
   * @param message
   *          String value of message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * This method is used to retrieve the data .
   *
   * @return data Object
   */
  public Object getData() {
    return data;
  }

  /**
   * This method is used to set the data .
   *
   * @param data
   *          Object to be return in response
   */
  public void setData(Object data) {
    this.data = data;
  }
}
