/**
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.client.core

import org.json4s._
import sttp.client._
import org.openapitools.client.api.EnumsSerializers
import sttp.client.json4s.SttpJson4sApi

class SttpSerializer(implicit val format: Formats = DefaultFormats ++ EnumsSerializers.all ++ Serializers.all,
                     implicit val serialization: org.json4s.Serialization = org.json4s.jackson.Serialization) extends SttpJson4sApi


object Helpers {

  // Helper to handle Optional header parameters
  implicit class optionalParams(val request: RequestT[Identity, Either[String, String], Nothing]) extends AnyVal {
    def header( header: String, optValue: Option[Any]): RequestT[Identity, Either[String, String], Nothing] = {
      optValue.map( value => request.header(header, value.toString)).getOrElse(request)
    }
  }

}
