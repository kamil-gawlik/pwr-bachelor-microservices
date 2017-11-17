import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {ServicesdataService} from "./services/servicesdata.service";
import {MatListModule} from '@angular/material/list';
import {AppRoutingModule} from './app-routing.module';
import {ServicedetailsComponent} from './servicedetails/servicedetails.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatButtonModule} from '@angular/material/button';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatIconModule} from '@angular/material/icon';
import {BrowserAnimationsModule}  from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ServicedetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    MatListModule,
    AppRoutingModule,
    MatSidenavModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatIconModule,
    BrowserAnimationsModule

  ],
  providers: [ServicesdataService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
