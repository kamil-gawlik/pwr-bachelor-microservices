import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {HttpModule} from "@angular/http";
import {AppComponent} from "./app.component";
import {NavbarComponent} from "./navbar/navbar.component";
import {ServicesdataService} from "./services/servicesdata.service";
import {MatListModule} from "@angular/material/list";
import {AppRoutingModule} from "./app-routing.module";
import {ServicedetailsComponent} from "./servicedetails/servicedetails.component";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatButtonModule} from "@angular/material/button";
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import {MatIconModule} from "@angular/material/icon";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ServicerequestComponent} from "./servicerequest/servicerequest.component";
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ReactiveFormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material';
import { FormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ServicedetailsComponent,
    ServicerequestComponent
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
    MatCardModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    FormsModule
  ],
  providers: [ServicesdataService, FormBuilder],
  bootstrap: [AppComponent]
})
export class AppModule {
}
