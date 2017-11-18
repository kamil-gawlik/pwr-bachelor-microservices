import {Component, OnInit, Output} from '@angular/core';
import {FieldDefinition, SingleEndpointConfiguration} from "../datamodels";
import {ActivatedRoute, Params, Router} from '@angular/router';
import {ServicesdataService} from "../services/servicesdata.service";
import {FormBuilder, FormControl, Validators, FormGroup} from '@angular/forms';

import  "rxjs/add/operator/switchMap";

@Component({
  selector: 'app-servicerequest',
  templateUrl: './servicerequest.component.html',
  styleUrls: ['./servicerequest.component.css']
})
export class ServicerequestComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute,
              private servicesProvider: ServicesdataService,
              private router: Router,
              fb: FormBuilder) {
    // this.options = fb.array([]);
  }

  endpoint: SingleEndpointConfiguration;
  endpointName: string;
  service: string;
  options: FormGroup;

  upload = {};

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
              this.options = this.toFormGroup(this.endpoint.input)
            })
        }
      )
    })
  }

  toFormGroup(fields: FieldDefinition[]) {
    let group: any = {};

    fields.forEach(f => {
      group[f.name] = f.required ? new FormControl(f.name || '', Validators.required)
        : new FormControl(f.name || '');
    });
    return new FormGroup(group);
  }

  fileChange(event: any) {
    for (const file of event.target.files) {
      this.upload['file'] = file;
    }
    console.log(this.upload);
  }

  goBack() {
    this.router.navigate(['details', this.service, this.endpointName], {queryParams: {}});
  }

  send() {

  }

  isFileType(i: FieldDefinition): boolean {
    return i.name == 'file';
  }

  showChanges() {
    console.log(this.options)
  }
}
