import {Component, OnInit} from '@angular/core';
import {ServicesdataService} from "../services/servicesdata.service";
import {ShortInfo} from "../datamodels";
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private servicesProvider: ServicesdataService,
              private router: Router) {
  }

  title: String = "test"
  services: ShortInfo[] = [];

  ngOnInit() {
    this.getServices();
  }


  getServices() {
    this.servicesProvider.getTaskApiUrl()
      .subscribe(res => {
          const url = res
          this.servicesProvider.getServices(url).subscribe((res: ShortInfo[]) => {
            console.log(`got services: ${res}`);
            this.services = res;
          })
        }
      )

  }

  goToDetails(service: String, endpoint: String): void {
    this.router.navigate(['details', service, endpoint], {queryParams: {}});
  }
}
