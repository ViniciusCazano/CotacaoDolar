import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CotacaoListagemComponent } from './cotacao-listagem/cotacao-listagem.component';

@NgModule({
  declarations: [
    AppComponent,
    CotacaoListagemComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
