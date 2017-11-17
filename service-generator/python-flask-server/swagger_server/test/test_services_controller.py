# coding: utf-8

from __future__ import absolute_import

from swagger_server.models.service_information import ServiceInformation
from swagger_server.models.single_endpoint_configuration import SingleEndpointConfiguration
from . import BaseTestCase
from six import BytesIO
from flask import json


class TestServicesController(BaseTestCase):
    """ ServicesController integration test stubs """

    def test_func/{func_id}(self):
        """
        Test case for func/{func_id}

        Find specyfication of concrete endpoint
        """
        response = self.client.open('//services/{service_name}'.format(service_name='service_name_example'),
                                    method='GET')
        self.assert200(response, "Response body is : " + response.data.decode('utf-8'))

    def test_services_get(self):
        """
        Test case for services_get

        Returns api specyfication
        """
        response = self.client.open('//services',
                                    method='GET')
        self.assert200(response, "Response body is : " + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
