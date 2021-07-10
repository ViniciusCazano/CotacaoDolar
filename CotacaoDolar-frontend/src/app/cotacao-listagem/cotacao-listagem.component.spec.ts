import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CotacaoListagemComponent } from './cotacao-listagem.component';

describe('CotacaoListagemComponent', () => {
  let component: CotacaoListagemComponent;
  let fixture: ComponentFixture<CotacaoListagemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CotacaoListagemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CotacaoListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
