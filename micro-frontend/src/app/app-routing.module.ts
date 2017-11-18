import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ServicedetailsComponent} from "./servicedetails/servicedetails.component";
import {AppComponent} from "./app.component";
import {ServicerequestComponent} from "./servicerequest/servicerequest.component";

/**
 * Routes avaliable in application
 */
const routes: Routes = [
  // {path: '', component: AppComponent},
  {path: 'details/:service/:endpoint', component: ServicedetailsComponent},
  {path: 'run/:service/:endpoint', component: ServicerequestComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
