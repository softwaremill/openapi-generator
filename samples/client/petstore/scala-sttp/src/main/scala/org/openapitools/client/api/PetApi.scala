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
package org.openapitools.client.api

import org.openapitools.client.model.ApiResponse
import java.io.File
import org.openapitools.client.model.Pet
import org.openapitools.client.core._
import sttp.client._
import sttp.model.Method

object PetApi {

  def apply(baseUrl: String = "http://petstore.swagger.io/v2")(
    implicit serializer: SttpSerializer
  ) = new PetApi(baseUrl)
}

class PetApi(baseUrl: String)(implicit serializer: SttpSerializer) {

  import serializer._

  /**
    * Expected answers:
    *   code 200 : Pet (successful operation)
    *   code 405 :  (Invalid input)
    *
    * @param pet Pet object that needs to be added to the store
    */
  def addPet(
    pet: Pet
  ): Request[Either[ResponseError[Exception], Pet], Nothing] =
    basicRequest
      .method(Method.POST, uri"$baseUrl/pet")
      .contentType("application/json")
      .body(pet)
      .response(asJson[Pet])

  /**
    * Expected answers:
    *   code 400 :  (Invalid pet value)
    *
    * @param petId Pet id to delete
    * @param apiKey
    */
  def deletePet(
    petId: Long,
    apiKey: Option[String] = None
  ): Request[Either[ResponseError[Exception], Unit], Nothing] =
    basicRequest
      .method(Method.DELETE, uri"$baseUrl/pet/${petId}")
      .contentType("application/json")
      .response(asJson[Unit])

  /**
    * Multiple status values can be provided with comma separated strings
    *
    * Expected answers:
    *   code 200 : Seq[Pet] (successful operation)
    *   code 400 :  (Invalid status value)
    *
    * @param status Status values that need to be considered for filter
    */
  def findPetsByStatus(
    status: Seq[String]
  ): Request[Either[ResponseError[Exception], Seq[Pet]], Nothing] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/pet/findByStatus?status=$status")
      .contentType("application/json")
      .response(asJson[Seq[Pet]])

  /**
    * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
    *
    * Expected answers:
    *   code 200 : Seq[Pet] (successful operation)
    *   code 400 :  (Invalid tag value)
    *
    * @param tags Tags to filter by
    */
  def findPetsByTags(
    tags: Seq[String]
  ): Request[Either[ResponseError[Exception], Seq[Pet]], Nothing] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/pet/findByTags?tags=$tags")
      .contentType("application/json")
      .response(asJson[Seq[Pet]])

  /**
    * Returns a single pet
    *
    * Expected answers:
    *   code 200 : Pet (successful operation)
    *   code 400 :  (Invalid ID supplied)
    *   code 404 :  (Pet not found)
    *
    * Available security schemes:
    *   api_key (apiKey)
    *
    * @param petId ID of pet to return
    */
  def getPetById(petId: Long)(
    implicit apiKey: ApiKeyValue
  ): Request[Either[ResponseError[Exception], Pet], Nothing] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/pet/${petId}")
      .contentType("application/json")
      .header("api_key", apiKey.value)
      .response(asJson[Pet])

  /**
    * Expected answers:
    *   code 200 : Pet (successful operation)
    *   code 400 :  (Invalid ID supplied)
    *   code 404 :  (Pet not found)
    *   code 405 :  (Validation exception)
    *
    * @param pet Pet object that needs to be added to the store
    */
  def updatePet(
    pet: Pet
  ): Request[Either[ResponseError[Exception], Pet], Nothing] =
    basicRequest
      .method(Method.PUT, uri"$baseUrl/pet")
      .contentType("application/json")
      .body(pet)
      .response(asJson[Pet])

  /**
    * Expected answers:
    *   code 405 :  (Invalid input)
    *
    * @param petId ID of pet that needs to be updated
    * @param name Updated name of the pet
    * @param status Updated status of the pet
    */
  def updatePetWithForm(
    petId: Long,
    name: Option[String] = None,
    status: Option[String] = None
  ): Request[Either[ResponseError[Exception], Unit], Nothing] =
    basicRequest
      .method(Method.POST, uri"$baseUrl/pet/${petId}")
      .contentType("application/x-www-form-urlencoded")
      .body(Map("name" -> name, "status" -> status))
      .response(asJson[Unit])

  /**
    * Expected answers:
    *   code 200 : ApiResponse (successful operation)
    *
    * @param petId ID of pet to update
    * @param additionalMetadata Additional data to pass to server
    * @param file file to upload
    */
  def uploadFile(
    petId: Long,
    additionalMetadata: Option[String] = None,
    file: Option[File] = None
  ): Request[Either[ResponseError[Exception], ApiResponse], Nothing] =
    basicRequest
      .method(Method.POST, uri"$baseUrl/pet/${petId}/uploadImage")
      .contentType("multipart/form-data")
      .body(Map("additionalMetadata" -> additionalMetadata, "file" -> file))
      .response(asJson[ApiResponse])

}
