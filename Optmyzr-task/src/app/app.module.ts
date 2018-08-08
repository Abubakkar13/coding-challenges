import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { MapHomeComponent } from './components/map-home/map-home.component';
import { InfoWindowComponent } from './components/info-window/info-window.component';
import {AppRouterModule} from './app.router.module';
import {AgmCoreModule} from '@agm/core';



@NgModule({
  declarations: [
    AppComponent,
    MapHomeComponent,
    InfoWindowComponent
  ],
  imports: [
    BrowserModule,
    AppRouterModule,
    AgmCoreModule.forRoot({
      apiKey: 'YOUR-API-KEY'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
