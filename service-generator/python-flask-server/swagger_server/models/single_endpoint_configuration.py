# coding: utf-8

from __future__ import absolute_import
from swagger_server.models.field_definition import FieldDefinition
from .base_model_ import Model
from datetime import date, datetime
from typing import List, Dict
from ..util import deserialize_model


class SingleEndpointConfiguration(Model):
    """
    NOTE: This class is auto generated by the swagger code generator program.
    Do not edit the class manually.
    """
    def __init__(self, name: str=None, path: str=None, method: str=None, input: List[FieldDefinition]=None, output: List[FieldDefinition]=None, consumes: str=None, produces: str=None):
        """
        SingleEndpointConfiguration - a model defined in Swagger

        :param name: The name of this SingleEndpointConfiguration.
        :type name: str
        :param path: The path of this SingleEndpointConfiguration.
        :type path: str
        :param method: The method of this SingleEndpointConfiguration.
        :type method: str
        :param input: The input of this SingleEndpointConfiguration.
        :type input: List[FieldDefinition]
        :param output: The output of this SingleEndpointConfiguration.
        :type output: List[FieldDefinition]
        :param consumes: The consumes of this SingleEndpointConfiguration.
        :type consumes: str
        :param produces: The produces of this SingleEndpointConfiguration.
        :type produces: str
        """
        self.swagger_types = {
            'name': str,
            'path': str,
            'method': str,
            'input': List[FieldDefinition],
            'output': List[FieldDefinition],
            'consumes': str,
            'produces': str
        }

        self.attribute_map = {
            'name': 'name',
            'path': 'path',
            'method': 'method',
            'input': 'input',
            'output': 'output',
            'consumes': 'consumes',
            'produces': 'produces'
        }

        self._name = name
        self._path = path
        self._method = method
        self._input = input
        self._output = output
        self._consumes = consumes
        self._produces = produces

    @classmethod
    def from_dict(cls, dikt) -> 'SingleEndpointConfiguration':
        """
        Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The SingleEndpointConfiguration of this SingleEndpointConfiguration.
        :rtype: SingleEndpointConfiguration
        """
        return deserialize_model(dikt, cls)

    @property
    def name(self) -> str:
        """
        Gets the name of this SingleEndpointConfiguration.
        Short service name

        :return: The name of this SingleEndpointConfiguration.
        :rtype: str
        """
        return self._name

    @name.setter
    def name(self, name: str):
        """
        Sets the name of this SingleEndpointConfiguration.
        Short service name

        :param name: The name of this SingleEndpointConfiguration.
        :type name: str
        """
        if name is None:
            raise ValueError("Invalid value for `name`, must not be `None`")

        self._name = name

    @property
    def path(self) -> str:
        """
        Gets the path of this SingleEndpointConfiguration.
        relative path to enpoint

        :return: The path of this SingleEndpointConfiguration.
        :rtype: str
        """
        return self._path

    @path.setter
    def path(self, path: str):
        """
        Sets the path of this SingleEndpointConfiguration.
        relative path to enpoint

        :param path: The path of this SingleEndpointConfiguration.
        :type path: str
        """
        if path is None:
            raise ValueError("Invalid value for `path`, must not be `None`")

        self._path = path

    @property
    def method(self) -> str:
        """
        Gets the method of this SingleEndpointConfiguration.
        request type

        :return: The method of this SingleEndpointConfiguration.
        :rtype: str
        """
        return self._method

    @method.setter
    def method(self, method: str):
        """
        Sets the method of this SingleEndpointConfiguration.
        request type

        :param method: The method of this SingleEndpointConfiguration.
        :type method: str
        """
        allowed_values = ["GET", "PUT", "POST"]
        if method not in allowed_values:
            raise ValueError(
                "Invalid value for `method` ({0}), must be one of {1}"
                .format(method, allowed_values)
            )

        self._method = method

    @property
    def input(self) -> List[FieldDefinition]:
        """
        Gets the input of this SingleEndpointConfiguration.
        Detailed input descriptions

        :return: The input of this SingleEndpointConfiguration.
        :rtype: List[FieldDefinition]
        """
        return self._input

    @input.setter
    def input(self, input: List[FieldDefinition]):
        """
        Sets the input of this SingleEndpointConfiguration.
        Detailed input descriptions

        :param input: The input of this SingleEndpointConfiguration.
        :type input: List[FieldDefinition]
        """
        if input is None:
            raise ValueError("Invalid value for `input`, must not be `None`")

        self._input = input

    @property
    def output(self) -> List[FieldDefinition]:
        """
        Gets the output of this SingleEndpointConfiguration.
        Detailed input descriptions

        :return: The output of this SingleEndpointConfiguration.
        :rtype: List[FieldDefinition]
        """
        return self._output

    @output.setter
    def output(self, output: List[FieldDefinition]):
        """
        Sets the output of this SingleEndpointConfiguration.
        Detailed input descriptions

        :param output: The output of this SingleEndpointConfiguration.
        :type output: List[FieldDefinition]
        """
        if output is None:
            raise ValueError("Invalid value for `output`, must not be `None`")

        self._output = output

    @property
    def consumes(self) -> str:
        """
        Gets the consumes of this SingleEndpointConfiguration.
        Content type of consumed input - default \"application/json\"

        :return: The consumes of this SingleEndpointConfiguration.
        :rtype: str
        """
        return self._consumes

    @consumes.setter
    def consumes(self, consumes: str):
        """
        Sets the consumes of this SingleEndpointConfiguration.
        Content type of consumed input - default \"application/json\"

        :param consumes: The consumes of this SingleEndpointConfiguration.
        :type consumes: str
        """

        self._consumes = consumes

    @property
    def produces(self) -> str:
        """
        Gets the produces of this SingleEndpointConfiguration.
        Content type of output - \"application/json\"

        :return: The produces of this SingleEndpointConfiguration.
        :rtype: str
        """
        return self._produces

    @produces.setter
    def produces(self, produces: str):
        """
        Sets the produces of this SingleEndpointConfiguration.
        Content type of output - \"application/json\"

        :param produces: The produces of this SingleEndpointConfiguration.
        :type produces: str
        """

        self._produces = produces

