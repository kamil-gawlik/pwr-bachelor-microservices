import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/map";
@Injectable()
export class ServicesdataService {

//  private LOCAL_EUREKA = 'http://127.0.0.1:8090/task-api'
  private LOCAL_EUREKA = 'https://micro-frontend.herokuapp.com/task-api'

  constructor(private http: Http) {
  }


  getTaskApiUrl() {
    console.log('getting task-api url');
    return this.http.get(this.LOCAL_EUREKA)
      .map(r => r.json()[0]['homePageUrl']);
  }

  getServices(taskUrl:String) {
    const url = `${taskUrl}services`;
    console.log(`getting from ${url}`)
    return this.http.get(url).map(r => r.json())
  }

  getEndpoint(taskUrl:String, service: String, endpoint: String) {
    const url = `${taskUrl}services/${service}/${endpoint}`;
    console.log(`getting from ${url}`)
    return this.http.get(url).map(r => r.json())
  }
}
