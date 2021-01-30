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

import org.openapitools.client.model._
import org.json4s._
import sttp.client3.json4s.SttpJson4sApi
import scala.reflect.ClassTag

object JsonSupport extends SttpJson4sApi {
  def enumSerializers: Seq[Serializer[_]] = Seq[Serializer[_]]() :+
    new EnumNameSerializer(OrderEnums.Status) :+
    new EnumNameSerializer(PetEnums.Status)

  private class EnumNameSerializer[E <: Enumeration: ClassTag](enum: E) extends Serializer[E#Value] {
    import JsonDSL._
    val EnumerationClass: Class[E#Value] = classOf[E#Value]

    def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), E#Value] = {
      case (t @ TypeInfo(EnumerationClass, _), json) if isValid(json) =>
        json match {
          case JString(value) => enum.withName(value)
          case value => throw new MappingException(s"Can't convert $value to $EnumerationClass")
        }
    }

    private[this] def isValid(json: JValue) = json match {
      case JString(value) if enum.values.exists(_.toString == value) => true
      case _ => false
    }

    def serialize(implicit format: Formats): PartialFunction[Any, JValue] = {
      case i: E#Value => i.toString
      }
    }

  def apiModelSerializers: Seq[Serializer[_]] = Seq[Serializer[_]]() :+
    new CustomSerializer[ApiModel](_ => ({
      case _ => EmptyApiModel
    }, {
      case _: ApiModel => JObject()
    }))

  implicit val format: Formats = DefaultFormats ++ enumSerializers ++ DateSerializers.all ++ apiModelSerializers
  implicit val serialization: org.json4s.Serialization = org.json4s.jackson.Serialization
}
