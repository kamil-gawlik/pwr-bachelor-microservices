import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {ServicesdataService} from "../services/servicesdata.service";
import {SingleEndpointConfiguration} from "../datamodels";
import "rxjs/add/operator/switchMap";

@Component({
  selector: 'app-servicedetails',
  templateUrl: './servicedetails.component.html',
  styleUrls: ['./servicedetails.component.css']
})
export class ServicedetailsComponent implements OnInit {

  endpoint: SingleEndpointConfiguration;


  constructor(private route: ActivatedRoute,
              private servicesProvider: ServicesdataService) {
  }

  ngOnInit() {

  this.route.params.switchMap((params: Params) =>{
    let service: String = params['service'];
    let endpoint: String = params['endpoint'];
    console.log('creating param')
    this.servicesProvider.getTaskApiUrl().subscribe(res => {
        const url = res
        this.servicesProvider.getEndpoint(url, service, endpoint)
          .subscribe((res: SingleEndpointConfiguration) => {
            console.log(`got enpoint for ${service} ${endpoint}`);
            this.endpoint = res;
          })
      }
    )
  })
    /*
    let service: String = this.route.paramMap.get('service')
    let endpoint: String = this.route.paramMap.get('endpoint')
    this.servicesProvider.getTaskApiUrl().subscribe(res => {
        const url = res
        this.servicesProvider.getEndpoint(url, service, endpoint)
          .subscribe((res: SingleEndpointConfiguration) => {
            console.log(`got enpoint for ${service} ${endpoint}`);
            this.endpoint = res;
          })
      }
    )
*/

  }


}
