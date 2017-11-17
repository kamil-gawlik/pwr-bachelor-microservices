import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ServicedetailsComponent} from "./servicedetails/servicedetails.component";
import {AppComponent} from "./app.component";

/**
 * Routes avaliable in application
 */
const routes: Routes = [
 // {path: '', component: AppComponent},
  {path: 'details/:service/:endpoint', component: ServicedetailsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
