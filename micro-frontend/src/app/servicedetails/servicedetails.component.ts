import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, ParamMap, Router} from "@angular/router";
import {ServicesdataService} from "../services/servicesdata.service";
import {SingleEndpointConfiguration} from "../datamodels";
import  "rxjs/add/operator/switchMap";

@Component({
  selector: 'app-servicedetails',
  templateUrl: './servicedetails.component.html',
  styleUrls: ['./servicedetails.component.css']
})
export class ServicedetailsComponent implements OnInit {

  endpoint: SingleEndpointConfiguration;
  endpointName:string;
  service:string;

  constructor(private activatedRoute: ActivatedRoute,
              private servicesProvider: ServicesdataService,
              private router: Router) {
  }

  run(endpoint: SingleEndpointConfiguration) {
    this.router.navigate(['run', this.service, this.endpoint.name], {queryParams: {}});
  }

  ngOnInit() {

    this.activatedRoute.params.subscribe((params: Params) => {
      this.service = params['service'];
      this.endpointName = params['endpoint'];
      console.log('creating param')
      this.servicesProvider.getTaskApiUrl().subscribe(res => {
          const url = res
          this.servicesProvider.getEndpoint(url, this.service, this.endpointName)
            .subscribe((res: SingleEndpointConfiguration) => {
              console.log(`got endpoint for ${this.service} ${this.endpointName}`);
              this.endpoint = res;
            })
        }
      )
    })
    /*
     let service: String = this.route.snapshot.paramMap.get('service')
     let endpoint: String = this.route.snapshot.paramMap.get('endpoint')
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
