import {Component, OnInit, Output} from '@angular/core';
import {FieldDefinition, SingleEndpointConfiguration} from "../datamodels";
import {ActivatedRoute, Params, Router} from '@angular/router';
import {ServicesdataService} from "../services/servicesdata.service";
import {FormControl, Validators, FormGroup} from '@angular/forms';
import {Http, Response, RequestOptions} from '@angular/http';
import  "rxjs/add/operator/switchMap";
import "rxjs/add/operator/map";

@Component({
  selector: 'app-servicerequest',
  templateUrl: './servicerequest.component.html',
  styleUrls: ['./servicerequest.component.css']
})
export class ServicerequestComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute,
              private servicesProvider: ServicesdataService,
              private router: Router,
              private http: Http) {
  }

  endpoint: SingleEndpointConfiguration;
  endpointName: string;
  service: string;

  taskApiUrl: string;
  options: FormGroup;
  submitted = false;
  file = null;

  result;


  onSubmit() {
    this.submitted = true;
    this.sendTask();
  }

  private sendTask() {
    const url = `${this.taskApiUrl}services/${this.service}${this.endpoint.path}`
    console.log(url)
    let body;
    let headers = new Headers();
    if (this.file !== null) {
      body = new FormData();
      body.append('file', this.file, {type: "multipart/form-data"});
      body.append('task', JSON.stringify(this.options.value))// this.options.value, {type: "application/json"})
      headers.append('Content-Type', undefined)
    } else {
      body = this.options.value
    }
    this.http.post(url, body, {headers:headers}).map(r => r.json()).subscribe((res =>
        this.result = Object.keys(res).map(key => ({key, value: res[key]}))
    ));
  }

  ngOnInit() {
    this.activatedRoute.params.subscribe((params: Params) => {
      this.service = params['service'];
      this.endpointName = params['endpoint'];
      console.log('creating param')
      this.servicesProvider.getTaskApiUrl().subscribe(res => {
          this.taskApiUrl = res
          this.servicesProvider.getEndpoint(this.taskApiUrl, this.service, this.endpointName)
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
      if (f.type != 'file') {
        group[f.name] = f.required ? new FormControl('', Validators.required) : new FormControl('');
      }
    });
    return new FormGroup(group);
  }

  fileChange(event: any) {
    for (const file of event.target.files) {
      this.file = file;
    }
    console.log(this.file);
  }

  goBack() {
    this.router.navigate(['details', this.service, this.endpointName], {queryParams: {}});
  }

  isFileType(i: FieldDefinition): boolean {
    return i.name == 'file';
  }

  showChanges() {
    console.log(this.options.value)
  }

}
