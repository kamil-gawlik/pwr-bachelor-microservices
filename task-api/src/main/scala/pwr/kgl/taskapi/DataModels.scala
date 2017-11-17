package pwr.kgl.taskapi

case class ServiceInformation(val endpoints: List[SingleEndpointConfiguration])

case class SingleEndpointConfiguration(
                                        val name: String,
                                        val path: String,
                                        val method: String,
                                        val input: List[FieldDefinition],
                                        val output: List[FieldDefinition],
                                        consumes: Option[String],
                                        produces: Option[String]
                                      )

case class FieldDefinition(
                            val name: String,
                            val `type`: String,
                            val required: Boolean,
                            val additional_description: Option[String]
                          )

case class ShortInfo(name:String, endpoints:List[String])
