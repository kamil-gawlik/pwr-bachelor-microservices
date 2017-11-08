package pwr.kgl.taskapi

case class ServiceInformation(val enpoints: List[SingleEndpointConfiguration])

case class SingleEndpointConfiguration(
                                        val name: String,
                                        val path: String,
                                        val method: String,
                                        val input: List[FieldDefinition],
                                        val output: List[FieldDefinition]
                                      )

case class FieldDefinition(
                            val name: String,
                            val `type`: String,
                            val required: Boolean,
                            val additional_description: Option[String]
                          )