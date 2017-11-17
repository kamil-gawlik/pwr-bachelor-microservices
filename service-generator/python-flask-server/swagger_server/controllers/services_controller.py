import connexion
from swagger_server.models.service_information import ServiceInformation
from swagger_server.models.single_endpoint_configuration import SingleEndpointConfiguration
from datetime import date, datetime
from typing import List, Dict
from six import iteritems
from ..util import deserialize_date, deserialize_datetime


def func/{func_id}(service_name):
    """
    Find specyfication of concrete endpoint
    Returns a single function description
    :param service_name: ID of func to return
    :type service_name: str

    :rtype: SingleEndpointConfiguration
    """
    return 'do some magic!'


def services_get():
    """
    Returns api specyfication
    Returns all informations about how to run calculations on microservice

    :rtype: ServiceInformation
    """
    return 'do some magic!'
